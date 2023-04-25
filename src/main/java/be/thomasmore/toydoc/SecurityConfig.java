package be.thomasmore.toydoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity // Schakel Spring Security in
public class SecurityConfig {

    // Configureer de beveiligingsketen
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN") // Beperk toegang tot "/admin" voor gebruikers met de rol "ROLE_ADMIN"
                .anyRequest().permitAll(); // Sta toegang toe tot alle andere URL's
        http.formLogin()
                .loginPage("/user/login"); // Gebruik aangepaste inlogpagina
        http.logout()
                .logoutUrl("/user/logout"); // Gebruik aangepaste uitlog-URL
        return http.build();
    }

    // Configureer beveiligingsfilter om toegang tot H2-console te negeren
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers(new AntPathRequestMatcher("/h2-console/**"));
    }

    // Gebruik de datasource om gebruikers te verifiëren en autorisaties te verkrijgen
    @Autowired
    private DataSource dataSource;
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication() // Gebruik JDBC-authenticatie
                .dataSource(dataSource) // Gebruik de opgegeven datasource
                .usersByUsernameQuery(
                        "select username,password,true from app_user where username = ?") // Query om gebruikers te vinden
                .authoritiesByUsernameQuery(
                        "select username, role from app_user where username = ?"); // Query om autorisaties te vinden
    }

    // Configureer het wachtwoordcoderingsalgoritme
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Gebruik BCrypt om wachtwoorden te coderen
    }

}