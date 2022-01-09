package ningenme.net.sample.domain.entity;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.sample.domain.value.RoleModel;

import java.util.List;

@Data
@RequiredArgsConstructor(staticName = "of")
public class UserModel {
    @NonNull
    private final Integer userId;
    @NonNull
    private final List<RoleModel> roleModelList;
}
