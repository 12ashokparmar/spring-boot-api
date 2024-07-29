package com.ap.api.config;

 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true)*/
@Configuration
@EnableGlobalMethodSecurity(
        // securedEnabled = true,
        // jsr250Enabled = true,
        prePostEnabled = true)
public class WebSecurityConfig implements WebMvcConfigurer {
 
 
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .exceptionHandling().and()
                //.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER).and()
               // .authorizeRequests().antMatchers("/api/public/common/auth/**").permitAll()
                .authorizeRequests().antMatchers(HttpMethod.POST,AuthenticationConfigConstants.AUTH_WHITELIST).permitAll()
                .antMatchers(HttpMethod.POST,AuthenticationConfigConstants.SWAGGER_LIST).permitAll()
                .and().authorizeRequests().antMatchers(HttpMethod.GET,AuthenticationConfigConstants.AUTH_WHITELIST).permitAll()
                .antMatchers(HttpMethod.GET,AuthenticationConfigConstants.SWAGGER_LIST).permitAll()
                .anyRequest().authenticated();

        // fix H2 database console: Refused to display ' in a frame because it set 'X-Frame-Options' to 'deny'
        http.headers().frameOptions().sameOrigin();

       // http.authenticationProvider(authenticationProvider());

      //  http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
    
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");
    }

 
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

   /* @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        registry.addInterceptor(new AuthenticationHandlerInterceptor());
    }*/

}