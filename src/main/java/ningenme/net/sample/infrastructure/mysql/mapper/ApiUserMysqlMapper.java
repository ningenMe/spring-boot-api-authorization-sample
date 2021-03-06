package ningenme.net.sample.infrastructure.mysql.mapper;

import lombok.NonNull;
import ningenme.net.sample.infrastructure.mysql.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ApiUserMysqlMapper {

    @Select(
            "SELECT user.user_id, authority_name " +
            "FROM user " +
            "JOIN j_user_authority " +
            "ON user.user_id = j_user_authority.user_id " +
            "JOIN authority " +
            "ON j_user_authority.authority_id = authority.authority_id " +
            "WHERE api_token = #{apiToken}"
    )
    List<UserDto> select(@NonNull final String apiToken);

}
