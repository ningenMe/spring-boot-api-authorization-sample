package ningenme.net.sample.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.sample.domain.entity.ApiUserModel;
import ningenme.net.sample.infrastructure.mysql.ApiUserMysqlRepository;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
public class ApiUserService implements AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> {

    private final ApiUserMysqlRepository userMysqlRepository;

    @Override
    public UserDetails loadUserDetails(PreAuthenticatedAuthenticationToken token) throws UsernameNotFoundException {
        final ApiUserModel apiUserModel = userMysqlRepository.getUserModel(token.getPrincipal().toString());
        log.error(apiUserModel.getAuthorities().toString());
        return apiUserModel;
    }
}
