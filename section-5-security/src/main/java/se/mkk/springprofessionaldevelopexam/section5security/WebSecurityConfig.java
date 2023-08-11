package se.mkk.springprofessionaldevelopexam.section5security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests( //
                authz -> authz //
                        .requestMatchers("/actuator/health").permitAll() //
                        .requestMatchers("/actuator**").hasRole("ACTUATOR") //
                        .requestMatchers(HttpMethod.POST, "/api/persons").hasRole("ADMIN") //
                        .requestMatchers("/api/persons").hasAnyRole("USER", "ADMIN") //
                        .anyRequest().authenticated()) //
                .httpBasic(Customizer.withDefaults()) //
                .csrf(CsrfConfigurer::disable);

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(PasswordEncoder passwordEncoder) {
        UserDetails user = User.withUsername("user").password(passwordEncoder.encode("user")) //
                .roles("USER").build();
        UserDetails admin = User.withUsername("admin").password(passwordEncoder.encode("admin")) //
                .roles("USER", "ADMIN").build();
        UserDetails actuator = User.withUsername("actuator").password(passwordEncoder.encode("actuator")) //
                .roles("ACTUATOR").build();
        return new InMemoryUserDetailsManager(user, admin, actuator);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
