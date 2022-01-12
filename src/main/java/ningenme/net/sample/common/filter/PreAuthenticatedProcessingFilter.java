package ningenme.net.sample.common.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

import javax.servlet.http.HttpServletRequest;

@Slf4j
public class PreAuthenticatedProcessingFilter extends AbstractPreAuthenticatedProcessingFilter {


    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        return "";
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
        return request.getHeader("API_KEY");
    }

}
