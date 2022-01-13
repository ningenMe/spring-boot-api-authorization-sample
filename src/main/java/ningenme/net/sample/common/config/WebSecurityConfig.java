package ningenme.net.sample.common.config;

import lombok.RequiredArgsConstructor;
import ningenme.net.sample.common.filter.PreAuthenticatedProcessingFilter;
import ningenme.net.sample.domain.service.ApiUserService;
import ningenme.net.sample.infrastructure.mysql.ApiUserMysqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final ApiUserService apiUserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()

                .addFilter(preAuthenticatedProcessingFilter())

                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()

                .csrf()
                .disable()

                .headers()
                .cacheControl()
                .disable()

                .and()
                .cors()
                .disable();
    }

    @Bean
    PreAuthenticatedAuthenticationProvider preAuthenticatedAuthenticationProvider() {
        final PreAuthenticatedAuthenticationProvider preAuthenticatedAuthenticationProvider
                = new PreAuthenticatedAuthenticationProvider();
        preAuthenticatedAuthenticationProvider
                .setPreAuthenticatedUserDetailsService(apiUserService);
        preAuthenticatedAuthenticationProvider
                .setUserDetailsChecker(new AccountStatusUserDetailsChecker());
        return preAuthenticatedAuthenticationProvider;
    }

    @Bean
    PreAuthenticatedProcessingFilter preAuthenticatedProcessingFilter() throws Exception {
        final PreAuthenticatedProcessingFilter preAuthenticatedProcessingFilter
                = new PreAuthenticatedProcessingFilter();
        preAuthenticatedProcessingFilter.setAuthenticationManager(authenticationManager());
        return preAuthenticatedProcessingFilter;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(preAuthenticatedAuthenticationProvider());
    }
}
