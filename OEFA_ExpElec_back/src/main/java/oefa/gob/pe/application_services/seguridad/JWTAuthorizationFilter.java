package oefa.gob.pe.application_services.seguridad;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

@Log4j2
@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {

	private static final Pattern BEARER_REGEX = Pattern.compile("Bearer ?");
	private final JwtUserDetailsService jwtUserDetailsService;
	private final JwtTokenUtil jwtTokenUtil;

	public JWTAuthorizationFilter(JwtUserDetailsService jwtUserDetailsService, JwtTokenUtil jwtTokenUtil) {
		this.jwtUserDetailsService = jwtUserDetailsService;
		this.jwtTokenUtil = jwtTokenUtil;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain chain)
			throws ServletException, IOException {

		final String requestTokenHeader = request.getHeader("Authorization");

		String username = null;
		String jwtToken = null;
		List<GrantedAuthority> roles = new ArrayList<>();
		// JWT Token is in the form "Bearer token". Remove Bearer word and get
		// only the Token
		/* if (!Objects.equals(request.getMethod(), "GET") || !request.getRequestURI().startsWith("/actuator")) {
			log.warn("No hay JWT presente " + request.getMethod() + " " + request.getRequestURI());
		} */

		if(requestTokenHeader != null){
			if (!requestTokenHeader.isEmpty() && requestTokenHeader.startsWith("Bearer ") /* &&  requestTokenHeader != null */ ) {
				jwtToken = BEARER_REGEX.matcher(requestTokenHeader).replaceAll("");
				try {
					username = jwtTokenUtil.getUsernameFromToken(jwtToken);
					roles = jwtTokenUtil.getRolesFromToken(jwtToken);
				} catch (IllegalArgumentException e) {
					log.warn("Unable to get JWT Token");
				} catch (ExpiredJwtException e) {
					log.warn("JWT Token has expired");
				}
			} else {
				if (!Objects.equals(request.getMethod(), "GET") || !request.getRequestURI().startsWith("/actuator")) {
					log.warn("No hay JWT presente " + request.getMethod() + " " + request.getRequestURI());
				}
			}
		}else{
			if (!Objects.equals(request.getMethod(), "GET") || !request.getRequestURI().startsWith("/actuator")) {
				log.warn("No hay JWT presente " + request.getMethod() + " " + request.getRequestURI());
			}
		}
		

		// Once we get the token validate it.
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username, roles);

			// if token is valid configure Spring Security to manually set
			// authentication
			if (Boolean.TRUE.equals(jwtTokenUtil.validateToken(jwtToken, userDetails))) {

				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				// After setting the Authentication in the context, we specify
				// that the current user is authenticated. So it passes the
				// Spring Security Configurations successfully.
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		chain.doFilter(request, response);
	}

}