package com.example.tienda;

import com.example.tienda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigureAdpter{
    
    @Autowired
    private UserService userDetailsService;
    private final UserService UserDetailsService;
 
    
    @Bean 
    public BCryptPasswordEncoder passwordEnconder(){ /*el BCryptPasswordEncoder se encripta la contraseña */
        return new BCryptPasswordEncoder();    
    }
    @Bean
    public UserService getUserService() {
        return new UserService();
    }
    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEnconder());
        daoAuthenticationProvider.setUserDetailsService(getUserService());
        return daoAuthenticationProvider;
    
}
@Bean
public AuthenticationSuccessHandler appAuthenticationSuccessHandler() {
    return new AppAuthenticationSuccessHandler();
}
public SecurityConfig(UserService userPrincipalDetailsService){
        this.UserDetailsService = userPrincipalDetailsService;
}
 @Override 
 protected void configure (AuthenticationManagerBuilder auth) {
     auth.authenticationProvider(authenticationProvider());
 }
 
 @Override
 protected void configure (HttpSecurity http) throws Exception {
     http.authorizeRequests()
             .antMatchers("/persona","/login")
             .hasRole("ADMIN")
             .antMatchers("/personaN","persona","/" ,"/login")   
             .hasAnyRole("USER","VENDEDOR" ,"ADMIN")
             .anyRequest().authenticated()
             .and()
             .formLogin()
             .loginPage("/login").permitAll().defaultSuccessUrl("/persona",true).and().logout()
             .logoutUrl("/logout")
             .logoutSuccessUrl("/");
             
             
     
     
 }
 

    }
