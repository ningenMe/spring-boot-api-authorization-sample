package ningenme.net.sample.infrastructure.mysql.mapper;

import lombok.NonNull;
import ningenme.net.sample.infrastructure.mysql.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMysqlMapper {

    @Select(
            "SELECT user.user_id, role_name " +
            "FROM user " +
            "JOIN j_user_role " +
            "ON user.user_id = j_user_role.user_id " +
            "JOIN role " +
            "ON j_user_role.role_id = role.role_id " +
            "WHERE api_token = #{apiToken}"
    )
    List<UserDto> select(@NonNull final String apiToken);

}
