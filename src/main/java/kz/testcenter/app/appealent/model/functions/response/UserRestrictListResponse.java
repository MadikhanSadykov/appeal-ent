package kz.testcenter.app.appealent.model.functions.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRestrictListResponse {

    // 1
    @JsonProperty("out_user_id")
    private Integer userId;

    // 2
    @JsonProperty("out_perm")
    private Short perm;

    // 3
    @JsonProperty("out_user_role_type_id")
    private Short userRoleTypeId;

    public static UserRestrictListResponse build(Map<Integer, Object> fieldNumberOfUserRestrictListResponseMap) {
        return new UserRestrictListResponse(
                (Integer) fieldNumberOfUserRestrictListResponseMap.get(1),
                (Short) fieldNumberOfUserRestrictListResponseMap.get(2),
                (Short) fieldNumberOfUserRestrictListResponseMap.get(3)
        );
    }

}
