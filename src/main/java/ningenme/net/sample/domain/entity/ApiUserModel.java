package ningenme.net.sample.domain.entity;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.sample.domain.value.AuthorityModel;
import org.springframework.security.core.userdetails.User;

import java.util.List;

@Slf4j
public class ApiUserModel extends User{

    public ApiUserModel(@NonNull final List<AuthorityModel> authorityModelList) {
        super("userId", "", authorityModelList);
    }
}
