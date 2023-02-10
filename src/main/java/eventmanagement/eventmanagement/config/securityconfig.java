package eventmanagement.eventmanagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@EnableWebSecurity
public class securityconfig extends WebSecurityConfigurerAdapter{
    @Autowired
    private UserDetailsService userDetailsService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.userDetailsService(userDetailsService);
        auth.inMemoryAuthentication().withUser("murali")
                .password("murali")
                .roles("admin");



    }
    @Bean
     public PasswordEncoder getpasswordencoder(){
        return NoOpPasswordEncoder.getInstance();
     }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.cors().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
     http.authorizeRequests()
             .antMatchers("/api/attendee/registor").permitAll()
             .antMatchers("/event/events").permitAll()
             .antMatchers("/event/createevent").permitAll()
             .antMatchers("/api/attendee/attendees").permitAll()
    .antMatchers("/**").permitAll()
             .and().formLogin();
    }
}
