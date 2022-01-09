package ningenme.net.sample.infrastructure.mysql;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.sample.domain.entity.UserModel;
import ningenme.net.sample.infrastructure.mysql.dto.UserDto;
import ningenme.net.sample.infrastructure.mysql.mapper.UserMysqlMapper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserMysqlRepository {

    private final UserMysqlMapper userMysqlMapper;

    public UserModel getUserModel(@NonNull final String apiToken) {
        return UserDto.getUserModel(userMysqlMapper.select(apiToken));
    }
}
