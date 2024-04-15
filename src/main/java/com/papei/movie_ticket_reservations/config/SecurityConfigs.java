package com.papei.movie_ticket_reservations.config;

import com.papei.movie_ticket_reservations.filter.JwtAuthFilter;
import com.papei.movie_ticket_reservations.service.impl.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@EnableWebSecurity
@Configuration
public class SecurityConfigs {

    @Autowired
    private JwtAuthFilter authFilter;

//    private final WebClient userInfoClient;
//
//    public SecurityConfigs(WebClient userInfoClient) {
//        this.userInfoClient = userInfoClient;
//    }

    // User Creation
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(request -> request
                        .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/swagger-ui/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/swagger-resources/*")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/v3/api-docs/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/v3/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/api/**")).permitAll()
//                                .requestMatchers(new AntPathRequestMatcher("/movies/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/auth/welcome")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/users/new")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/movies/**")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/hall/**")).permitAll()

                        .requestMatchers(new AntPathRequestMatcher("/auth/generateToken")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/auth/url")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/auth/callback")).permitAll()
//                        .requestMatchers(new AntPathRequestMatcher("/login")).permitAll()
//                        .requestMatchers(new AntPathRequestMatcher("/token")).permitAll().requestMatchers(req -> "OPTIONS".equals(req.getMethod())).permitAll()

//                                .requestMatchers("/auth/user/**").authenticated()
//                                .requestMatchers("/auth/admin/**").authenticated()
                        .requestMatchers(new AntPathRequestMatcher("/users/delete/{userId}")).hasAnyRole("ADMIN", "SUPERADMIN")
                        .anyRequest().authenticated()

                );

//                        .oauth2ResourceServer(c -> c.opaqueToken(opaqueToken ->
//                                opaqueToken.introspector(introspector())));
        http.authenticationProvider(authenticationProvider()).addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);

        http.csrf((csrf) ->
                csrf.ignoringRequestMatchers(
                        new AntPathRequestMatcher("/h2-console/**"),
                        new AntPathRequestMatcher("/auth/**"),
                        new AntPathRequestMatcher("/users/**"),
                        new AntPathRequestMatcher("/movies/**"),
                        new AntPathRequestMatcher("/login")
                ).csrfTokenRepository(
                        CookieCsrfTokenRepository.withHttpOnlyFalse()
                )
        );
        http
                .cors(Customizer.withDefaults())
                .exceptionHandling(customizer -> customizer.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
                .sessionManagement(c -> c.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

//        http.csrf(AbstractHttpConfigurer::disable);
        http.headers((headers) -> headers
                .frameOptions(
                        HeadersConfigurer.FrameOptionsConfig::disable
                )
        );
        http
                .cors(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable());
        return http.build();
    }

//    @Bean
//    public OpaqueTokenIntrospector introspector() {
//        return new GoogleOpaqueTokenIntrospector(userInfoClient);
//    }
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Requestor-Type","Content-Type"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }



//    private ClientRegistration googleClientRegistration() {
//        return ClientRegistration.withRegistrationId("google")
//                .clientId("409672159858-77ue31tdiduh4r0ap8o1vb1moud74p9r.apps.googleusercontent.com")
//                .clientSecret("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")
//                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
//                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//                .redirectUri("http://localhost:4200/home/login/oauth2/code/google")
//                .scope("openid", "profile", "email", "address", "phone")
//                .authorizationUri("https://accounts.google.com/o/oauth2/v2/auth")
//                .tokenUri("https://www.googleapis.com/oauth2/v4/token")
//                .userInfoUri("https://www.googleapis.com/oauth2/v3/userinfo")
//                .userNameAttributeName(IdTokenClaimNames.SUB)
//                .jwkSetUri("https://www.googleapis.com/oauth2/v3/certs")
//                .clientName("Google")
//                .build();
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

//    @Bean
//    public OpaqueTokenAuthenticationProvider opaqueTokenAuthenticationProvider(OpaqueTokenIntrospector introspector) {
//        return new OpaqueTokenAuthenticationProvider(introspector);
//    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }


}
