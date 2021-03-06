package ningenme.net.sample.infrastructure.mysql.dto;

import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.sample.domain.entity.ApiUserModel;
import ningenme.net.sample.domain.value.AuthorityModel;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Slf4j
public class UserDto {
    private Integer userId;
    private String authorityName;

    public static ApiUserModel getApiUserModel(@NonNull final List<UserDto> userDtoList) {
        return new ApiUserModel(userDtoList.stream().map(userDto -> AuthorityModel.of(userDto.getAuthorityName())).collect(Collectors.toList()));
    }
}
