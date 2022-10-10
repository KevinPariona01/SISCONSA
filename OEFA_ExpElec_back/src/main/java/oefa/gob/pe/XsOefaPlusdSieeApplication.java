package oefa.gob.pe;

import io.micrometer.core.instrument.MeterRegistry;
import oefa.gob.pe.application_services.seguridad.JWTAuthorizationFilter;
import oefa.gob.pe.infraestructure_cross_cuting.config_properties.Oefa;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.time.Duration;

@SpringBootApplication(exclude = {RedisAutoConfiguration.class})
@EnableConfigurationProperties({Oefa.class})
@EnableFeignClients
@EnableAsync
@EnableCaching
@EnableJpaAuditing(modifyOnCreate = false)
@EnableJpaRepositories
public class XsOefaPlusdSieeApplication {
	private static final Logger logger = LogManager.getLogger(XsOefaPlusdSieeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(XsOefaPlusdSieeApplication.class, args);
		logger.info("Se inicio la aplicación ;)");
	}

	@Bean
	MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
		return registry -> registry.config().commonTags("application", "IMA-BACKEND");
	}

	@Bean
	@Profile("redis")
	public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
		return (builder) -> builder
				.withCacheConfiguration("5s",
						RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(5)))
				.withCacheConfiguration("15s",
						RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(15)))
				.withCacheConfiguration("30s",
						RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(30)))
				.withCacheConfiguration("1m",
						RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(1)))
				.withCacheConfiguration("5m",
						RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(5)))
				.withCacheConfiguration("10m",
						RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(10)))
				.withCacheConfiguration("15m",
						RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(15)))
				.withCacheConfiguration("30m",
						RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(30)))
				.withCacheConfiguration("1h",
						RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofHours(1)))
				.withCacheConfiguration("2h",
						RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofHours(2)))
				.withCacheConfiguration("6h",
						RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofHours(6)))
				.withCacheConfiguration("12h",
						RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofHours(12)))
				.withCacheConfiguration("2d",
						RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(2)))
				.withCacheConfiguration("3d",
						RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(3)))
				.withCacheConfiguration("5d",
						RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(5)))
				.withCacheConfiguration("7d",
						RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(7)));
	}

	@ConditionalOnProperty(prefix = "spring", name = "cache.type", havingValue = "redis")
	@Configuration
	@Import({RedisAutoConfiguration.class})
	public class ApplicationRedisConfig {

	}

	@Component
	public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

		private static final long serialVersionUID = -7858869558953243875L;

		@Override
		public void commence(HttpServletRequest request, HttpServletResponse response,
							 AuthenticationException authException) throws IOException {

			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
		}
	}

	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		private final JWTAuthorizationFilter jwtRequestFilter;

		WebSecurityConfig(JWTAuthorizationFilter jwtRequestFilter) {
			this.jwtRequestFilter = jwtRequestFilter;
		}

		@Bean
		@Override
		public AuthenticationManager authenticationManagerBean() throws Exception {
			return super.authenticationManagerBean();
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			// http.csrf().disable()
			http.cors().and().csrf().disable() // CORS
					// .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
					.authorizeRequests()
					//.antMatchers(HttpMethod.GET, "/").permitAll()
					
					.regexMatchers("^https?://localhost:?\\d{0,5}").permitAll()
					.regexMatchers("^https?://[A-Za-z\\-\\d.]*\\.oefa\\.gob\\.pe:?\\d{0,5}").permitAll()
					// .antMatchers(HttpMethod.POST, "/seguridad/api/token/**").permitAll()
					// .antMatchers(HttpMethod.POST, "/seguridad/api/usuario/**").permitAll()
					// Direcciones usadas por kubernetes para verificar si el contenedor esta en buen estado o no
					.antMatchers(HttpMethod.GET, "/actuator/**").permitAll()
					// FRONT (TEMP)
					.antMatchers("/siee/api/token/**").permitAll()
					.antMatchers("/version.json").permitAll()
					.anyRequest()
					.authenticated();
			http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		}

		@Override
		public void configure(WebSecurity web) throws Exception {
			web
			.ignoring()
				.antMatchers("/siee/api/usuario/**");
		}

		
	}
}
