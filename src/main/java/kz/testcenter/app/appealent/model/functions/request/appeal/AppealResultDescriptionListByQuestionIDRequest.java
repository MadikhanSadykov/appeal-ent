package kz.testcenter.app.appealent.model.functions.request.appeal;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppealResultDescriptionListByQuestionIDRequest {

    // 0
    @Schema(name = "Appeal Type Id", example = "1")
    @JsonProperty("in_appeal_type_id")
    private Short appealTypeId;

    // 1
    @Schema(name = "Test Server ID", example = "1")
    @JsonProperty("in_test_server_id")
    private Short testServerId;

    // 2
    @Schema(name = "Expert Id", example = "1")
    @JsonProperty("in_expert_id")
    private Integer expertId;

    // 3
    @Schema(name = "Original Question ID", example = "1")
    @JsonProperty("in_original_question_id")
    private Long originalQuestionId;

}
