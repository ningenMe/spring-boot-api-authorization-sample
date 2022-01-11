package ningenme.net.sample.infrastructure.mysql;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.sample.domain.entity.ApiUserModel;
import ningenme.net.sample.infrastructure.mysql.dto.UserDto;
import ningenme.net.sample.infrastructure.mysql.mapper.ApiUserMysqlMapper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ApiUserMysqlRepository {

    private final ApiUserMysqlMapper userMysqlMapper;

    public ApiUserModel getUserModel(@NonNull final String apiToken) {
        return UserDto.getApiUserModel(userMysqlMapper.select(apiToken));
    }
}
