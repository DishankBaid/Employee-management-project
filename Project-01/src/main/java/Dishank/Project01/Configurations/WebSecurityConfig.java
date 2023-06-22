package Dishank.Project01.Configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig implements WebMvcConfigurer {
    private static final String[] WHITELIST={
            "/",
            "/employees",
            "/position",
            "/employees/{id}",
            "/employees/deleteAll",
            "/employees/information",
            "/registration",
            "add_employees",
            "/getEmployees/{id}"
    };

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(11);
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((auth)->auth.requestMatchers(WHITELIST).permitAll().anyRequest()
                        .authenticated())
                .build();
    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/employees/**")
                .allowedOrigins("http://127.0.0.1:5500")
                .allowedMethods("*")
                .allowedHeaders("*");

        registry.addMapping("/registration")
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowedOrigins("http://127.0.0.1:5500");
    }

//    @Bean
//    AuthenticationProvider authenticationProvider(){
//        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
//        provider.setUserDetailsService(userDetailsService);
//        provider.setPasswordEncoder(new BCryptPasswordEncoder());
//
//        return provider;
//    }

}
