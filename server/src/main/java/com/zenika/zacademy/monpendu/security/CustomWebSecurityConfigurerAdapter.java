package com.zenika.zacademy.monpendu.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class CustomWebSecurityConfigurerAdapter {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    private RestAuthenticationEntryPoint authenticationEntryPoint;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(expressionInterceptUrlRegistry ->
                        // On demande que tous les appels à api soient authentifiés
                        expressionInterceptUrlRegistry
                                // Permet d'autoriser les utilisateurs à accéder au Swagger
                                .requestMatchers(HttpMethod.GET, "/swagger-ui/*").permitAll()
                                .requestMatchers(HttpMethod.GET, "/v3/api-docs", "/v3/api-docs/*").permitAll()
//                                .requestMatchers(HttpMethod.GET, "/games").permitAll()
                                .requestMatchers(HttpMethod.POST, "/games/*/rounds").permitAll()
                                .requestMatchers(HttpMethod.GET, "/rounds").permitAll()
                                .requestMatchers(HttpMethod.GET, "/rounds/*").permitAll()
                                .requestMatchers(HttpMethod.POST, "/rounds/*/searched/*").permitAll()
                                // Les autres sont autorisés par défaut :)
                                .anyRequest().authenticated())
                // On désactive le csrf car pas besoin en mode stateless
                .csrf(AbstractHttpConfigurer::disable)
                // On s'assure d'être en mode stateless (No COOKIE !!!!)
                .sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // S'il y a une erreur, on utilise le point d'entrée authenticationEntryPoint
                // On renvoie un code d'erreur 401, mais on pourrait très bien renvoyer vers la page d'authentification
                .httpBasic(httpSecurityHttpBasicConfigurer -> httpSecurityHttpBasicConfigurer.authenticationEntryPoint(authenticationEntryPoint));
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Permet de fournir à Spring security le mode de hachage utilisé
        return passwordEncoder;
    }
}
