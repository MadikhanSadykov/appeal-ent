package kz.testcenter.app.appealent.model.functions.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SetAppealResultDescriptionFileRequest {

    // 1
    @JsonProperty("in_original_question_id")
    private Long originalQuestionId;

    // 2
    @JsonProperty("in_appeal_type_id")
    private Short appealTypeId;

    // 3
    @JsonProperty("in_test_server_id")
    private Short testServerId;

    // 4
    @JsonProperty("in_appeal_id")
    private Integer appealId;

    // 5
    @JsonProperty("in_expert_id")
    private Integer expertId;

    // 6
    @Schema(name = "in_appeal_result_file", example = "iqufoiduwqouh219843h2914y03", description = "Byte Array of the file")
    @JsonProperty("in_appeal_result_file")
    private Byte[] appealResultFile;

}
