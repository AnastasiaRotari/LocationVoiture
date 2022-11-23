package ajc.sopra.locationVoiture.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// @formatter:off
		return http.antMatcher("/**")
			.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authorizeRequests()
				.antMatchers(HttpMethod.OPTIONS).permitAll()
				.antMatchers(HttpMethod.POST ,"/api/client/inscription").anonymous()
				.antMatchers(HttpMethod.POST ,"/api/loueur/inscription").anonymous()
				.antMatchers(HttpMethod.PATCH,"/api/client/**").hasRole("CLIENT")
				.antMatchers(HttpMethod.PATCH,"/api/loueur/**").hasRole("LOUEUR")
				.antMatchers(HttpMethod.POST, "/api/location/**").hasRole("CLIENT")
				.antMatchers(HttpMethod.PATCH, "/api/location/**").hasRole("CLIENT")
				.antMatchers(HttpMethod.POST, "/api/annonce/**").hasRole("LOUEUR")
				.antMatchers(HttpMethod.PATCH, "/api/annonce/**").hasRole("LOUEUR")
				.antMatchers(HttpMethod.POST, "/api/modele/**").hasRole("LOUEUR")
				.antMatchers(HttpMethod.PATCH, "/api/modele/**").hasRole("LOUEUR")
				.antMatchers(HttpMethod.GET).permitAll()
				.antMatchers(HttpMethod.DELETE).permitAll()
				.antMatchers(HttpMethod.PUT).permitAll()
				.anyRequest().hasRole("ADMIN")
			.and()
			.httpBasic()
			.and()
			.build();
		// @formatter:on
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
