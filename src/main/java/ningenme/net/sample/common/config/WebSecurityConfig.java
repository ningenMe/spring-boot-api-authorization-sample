package ningenme.net.sample.common.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .mvcMatchers(HttpMethod.GET , "/test1").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .disable()

                .csrf()
                .disable()

                .headers()
                .cacheControl()
                .disable()

                .and()
                .cors()
                .disable();
    }
}
