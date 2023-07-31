package kz.testcenter.app.appealent.model.functions.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_CALL_FROM_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_EXPERT_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_ROLE_TYPE_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_TEST_TYPE_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_USER_ID_FIELD;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubjectListRequest {

    // 1
    @Schema(name = IN_USER_ID_FIELD, example = "1")
    @JsonProperty(IN_USER_ID_FIELD)
    private Integer userId;

    // 2
    @Schema(name = IN_ROLE_TYPE_ID_FIELD, example = "1")
    @JsonProperty(IN_ROLE_TYPE_ID_FIELD)
    private Short roleTypeId;

    // 3
    @Schema(name = IN_TEST_TYPE_ID_FIELD, example = "1")
    @JsonProperty(IN_TEST_TYPE_ID_FIELD)
    private Short testTypeId;

    // 4
    @Schema(name = IN_EXPERT_ID_FIELD, example = "1")
    @JsonProperty(IN_EXPERT_ID_FIELD)
    private Integer expertId;

    // 5
    @Schema(name = IN_CALL_FROM_ID_FIELD, example = "1")
    @JsonProperty(IN_CALL_FROM_ID_FIELD)
    private Short callFromId;

    @JsonProperty("log")
    private WriteLogRequest writeLogRequest;

}
