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
public class AppealResultDescriptionFileRequest {

    // 0
    @Schema(name = "Appeal ID", example = "1", required = true)
    @JsonProperty("in_appeal_id")
    private Integer appealId;

    // 1
    @Schema(name = "Appeal Type ID", example = "1", required = true)
    @JsonProperty("in_appeal_type_id")
    private Short appealTypeId;

    // 2
    @Schema(name = "Test Server ID", example = "1", required = true)
    @JsonProperty("in_test_server_id")
    private Short testServerId;

    // 3
    @Schema(name = "Expert ID", example = "1", required = true)
    @JsonProperty("in_expert_id")
    private Integer expertId;

}
