package bg.softuni.Mobilelele.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public ApplicationSecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {

        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                // allow access to all static resources
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                // allows access to the home page, register and login
                .antMatchers("/","/users/register","/users/login").permitAll()
                // forbid all other pages for unauthenticated users
                .antMatchers("/**").authenticated()
                .and()
                // configure login with html form, two input fields
                .formLogin()
                // our login page is located at that path
                .loginPage("/users/login")
                // this is the name of <input> in the login html form where user writes his username,
                // value will be presented at out UserDetailsService
                .usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
                .passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY)
                // if login is successful we go at index page
                .defaultSuccessUrl("/")
                // if is not successful we go at this error page
                .failureForwardUrl("/users/login-error")
                .and()
                .logout()
                // it's url which spring implement for me, log out user
                .logoutUrl("/users/logout")
                // after logout go to index page
                .logoutSuccessUrl("/")
                // remove the session from server
                .invalidateHttpSession(true)
                // delete the cookie that references my session
                .deleteCookies("JSESSIONID");

    }
}
