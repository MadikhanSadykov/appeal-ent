package kz.testcenter.app.appealent.model.functions.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_APPEAL_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_APPEAL_TYPE_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_EXPERT_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_IGNORE_NOT_SUITABLE_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_LANG_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_SUBJECT_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_TEST_SERVER_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_TEST_TYPE_ID_FIELD;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppealSetToExpertRequest {

    // 1
    @Schema(name = IN_APPEAL_ID_FIELD, example = "1")
    @JsonProperty(IN_APPEAL_ID_FIELD)
    private Integer appealId;

    // 2
    @Schema(name = IN_APPEAL_TYPE_ID_FIELD, example = "1")
    @JsonProperty(IN_APPEAL_TYPE_ID_FIELD)
    private Short appealTypeId;

    // 3
    @Schema(name = IN_TEST_SERVER_ID_FIELD, example = "1")
    @JsonProperty(IN_TEST_SERVER_ID_FIELD)
    private Short testServerId;

    // 4
    @Schema(name = IN_LANG_ID_FIELD, example = "1")
    @JsonProperty(IN_LANG_ID_FIELD)
    private Short langId;

    // 5
    @Schema(name = IN_SUBJECT_ID_FIELD, example = "1")
    @JsonProperty(IN_SUBJECT_ID_FIELD)
    private Short subjectId;

    // 6
    @Schema(name = IN_TEST_TYPE_ID_FIELD, example = "1")
    @JsonProperty(IN_TEST_TYPE_ID_FIELD)
    private Short testTypeId;

    // 7
    @Schema(name = IN_EXPERT_ID_FIELD, example = "1")
    @JsonProperty(IN_EXPERT_ID_FIELD)
    private Integer expertId;

    // 8
    @Schema(name = IN_IGNORE_NOT_SUITABLE_FIELD, example = "1")
    @JsonProperty(IN_IGNORE_NOT_SUITABLE_FIELD)
    private Short ignoreNotSuitable;

    @JsonProperty("log")
    private WriteLogRequest writeLogRequest;

}
