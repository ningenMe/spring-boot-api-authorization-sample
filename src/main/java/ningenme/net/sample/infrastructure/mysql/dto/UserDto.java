package ningenme.net.sample.infrastructure.mysql.dto;

import lombok.Data;
import lombok.NonNull;
import ningenme.net.sample.domain.entity.UserModel;
import ningenme.net.sample.domain.value.RoleModel;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserDto {
    private Integer userId;
    private String roleName;

    public static UserModel getUserModel(@NonNull final List<UserDto> userDtoList) {
        return UserModel.of(
                userDtoList.stream().findFirst().get().getUserId(),
                userDtoList.stream().map(userDto -> RoleModel.of(userDto.getRoleName())).collect(Collectors.toList())
        );
    }
}
