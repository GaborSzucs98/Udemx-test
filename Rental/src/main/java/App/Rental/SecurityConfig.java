package App.Rental;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()        
            .requestMatchers("/Admin/**").hasRole("ADMIN")
            .anyRequest().permitAll()
            .and()
            .formLogin().defaultSuccessUrl("/Admin/Allcar", true)
            .and()
            .httpBasic();
        return http.build();
    }
    
    @Bean
    public UserDetailsService users() {
        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}admin")
                .roles("USER","ADMIN")
                .build();
        return new InMemoryUserDetailsManager(admin);
    }
    
}
