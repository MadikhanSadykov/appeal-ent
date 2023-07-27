package kz.testcenter.app.appealent.model.functions.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import kz.testcenter.app.appealent.model.functions.request.AuthUserRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthUserResponse {

    // 1
    @JsonProperty("out_user_id")
    private Integer userId;

    // 2
    @JsonProperty("out_username")
    private String username;

    // 3
    @JsonProperty("out_user_status_id")
    private Integer userStatusId;

    // 4
    @JsonProperty("out_result_login")
    private Integer resultLogin;

    public static AuthUserResponse build(Map<Integer, Object> fieldNumberOfAuthUserResponseMap) {
        return new AuthUserResponse(
                (Integer) fieldNumberOfAuthUserResponseMap.get(1),
                (String) fieldNumberOfAuthUserResponseMap.get(2),
                (Integer) fieldNumberOfAuthUserResponseMap.get(3),
                (Integer) fieldNumberOfAuthUserResponseMap.get(4)
        );
    }

}
