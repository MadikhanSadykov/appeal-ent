package kz.testcenter.app.appealent.model.functions.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_LOGIN_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_PASSWORD_FIELD;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthUserRequest {

    // 1
    @JsonProperty(IN_LOGIN_FIELD)
    private String login;

    // 2
    @JsonProperty(IN_PASSWORD_FIELD)
    private String password;

}
