package ningenme.net.sample.common.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

import javax.servlet.http.HttpServletRequest;

@Slf4j
public class PreAuthenticatedProcessingFilter extends AbstractPreAuthenticatedProcessingFilter {


    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        log.error("principal");
        log.error(request.getHeader("API_KEY"));
        return request.getHeader("API_KEY");
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
        log.error("credential");
        log.error(request.getHeader("API_KEY"));
        return request.getHeader("API_KEY");
    }

}
