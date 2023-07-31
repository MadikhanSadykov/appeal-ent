package kz.testcenter.app.appealent.model.functions.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_ACTION_TYPE_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_DESCR_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_IP_ADDRESS_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_OBJECT_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_ORG_TYPE_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_USER_ID_FIELD;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WriteLogRequest {

    // 1
    @JsonProperty(IN_ORG_TYPE_ID_FIELD)
    private Short orgTypeId;

    // 2
    @JsonProperty(IN_USER_ID_FIELD)
    private Integer userId;

    // 3
    @JsonProperty(IN_ACTION_TYPE_ID_FIELD)
    private Short actionTypeId;

    // 4
    @JsonProperty(IN_DESCR_FIELD)
    private String descr;

    // 5
    @JsonProperty(IN_OBJECT_ID_FIELD)
    private Integer objectId;

    // 6
    @JsonProperty(IN_IP_ADDRESS_FIELD)
    private String ipAddress;

}
