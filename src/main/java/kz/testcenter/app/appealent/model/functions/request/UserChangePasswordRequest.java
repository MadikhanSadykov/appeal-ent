package kz.testcenter.app.appealent.model.functions.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserChangePasswordRequest {

    // 1
    @JsonProperty("in_id")
    private Integer id;

    // 2
    @JsonProperty("in_user_status_id")
    private Short userStatusId;

    // 3
    @JsonProperty("in_password")
    private String password;

    @JsonProperty("log")
    private WriteLogRequest writeLogRequest;

}
