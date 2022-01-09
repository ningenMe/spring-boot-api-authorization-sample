package ningenme.net.sample.domain.value;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum RoleModel {
    TEST1("test1"),
    TEST2("test2"),
    TEST3("test3"),
    ;
    private final String value;

    public static RoleModel of(@NonNull final String value) {
        for (final RoleModel roleModel: RoleModel.values()) {
            if (Objects.equals(roleModel.getValue(), value)) {
                return roleModel;
            }
        }
        throw new RuntimeException();
    }
}
