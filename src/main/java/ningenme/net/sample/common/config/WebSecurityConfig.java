package ningenme.net.sample.common.config;

import lombok.RequiredArgsConstructor;
import ningenme.net.sample.common.filter.PreAuthenticatedProcessingFilter;
import ningenme.net.sample.domain.service.ApiUserService;
import ningenme.net.sample.domain.value.AuthorityModel;
import ningenme.net.sample.infrastructure.mysql.ApiUserMysqlRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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

    private final ApiUserMysqlRepository apiUserMysqlRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilter(preAuthenticatedProcessingFilter())
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()

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
    ApiUserService apiUserService() {
        return new ApiUserService(apiUserMysqlRepository);
    }

    @Bean
    PreAuthenticatedAuthenticationProvider preAuthenticatedAuthenticationProvider() {
        final PreAuthenticatedAuthenticationProvider preAuthenticatedAuthenticationProvider
                = new PreAuthenticatedAuthenticationProvider();
        preAuthenticatedAuthenticationProvider
                .setPreAuthenticatedUserDetailsService(apiUserService());
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
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(preAuthenticatedAuthenticationProvider());
    }
}
