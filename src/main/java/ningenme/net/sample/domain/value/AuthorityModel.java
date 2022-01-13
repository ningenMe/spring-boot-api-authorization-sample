package ningenme.net.sample.domain.value;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Objects;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum AuthorityModel implements GrantedAuthority {
    TEST1("test1"),
    TEST2("test2"),
    TEST3("test3"),
    TEST4("test4"),
    ;
    private final String value;

    public static AuthorityModel of(@NonNull final String value) {
        for (final AuthorityModel authorityModel: AuthorityModel.values()) {
            if (Objects.equals(authorityModel.getAuthority(), value)) {
                return authorityModel;
            }
        }
        throw new RuntimeException();
    }

    @Override
    public String getAuthority() {
        return value;
    }

}
