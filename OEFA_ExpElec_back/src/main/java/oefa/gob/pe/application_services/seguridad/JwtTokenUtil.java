package oefa.gob.pe.application_services.seguridad;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Component
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = -2550185165626007488L;
    @Value("${jwt.secret}")
    private String secret;

    //retrieve username from jwt token
    String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    List<GrantedAuthority> getRolesFromToken(String token) {
        var claims = getAllClaimsFromToken(token);
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<XsRoles> roles = (ArrayList<XsRoles>) mapper.convertValue(claims.get("roles", ArrayList.class), new TypeReference<List<XsRoles>>() {
        });
        if (roles == null || roles.isEmpty()) {
            return new ArrayList<>();
        }
        return roles.stream().map(xsr -> (GrantedAuthority) new XsAuthority(xsr.getUNombrePerfil())).toList();
    }

    //retrieve expiration date from jwt token
    Instant getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration).toInstant();
    }

    <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    //for retrieveing any information from token we will need the secret key
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
    }

    //check if the token has expired
    private Boolean isTokenExpired(String token) {
        final Instant expiration = getExpirationDateFromToken(token);
        return expiration.isBefore(Instant.now());
    }

    //validate token
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
