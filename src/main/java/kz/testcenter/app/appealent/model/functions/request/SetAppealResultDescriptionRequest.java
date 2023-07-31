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
public class SetAppealResultDescriptionRequest {

    // 1
    @Schema(name = "in_appeal_id", example = "1", required = true)
    @JsonProperty("in_appeal_id")
    private Integer appealId;

    // 2
    @Schema(name = "in_appeal_type_id", example = "1", required = true)
    @JsonProperty("in_appeal_type_id")
    private Short appealTypeId;

    // 3
    @Schema(name = "in_test_server_id", example = "1", required = true)
    @JsonProperty("in_test_server_id")
    private Short testServerId;

    // 4
    @Schema(name = "in_appeal_result_description", example = "string", required = true)
    @JsonProperty("in_appeal_result_description")
    private String appealResultDescription;

}
