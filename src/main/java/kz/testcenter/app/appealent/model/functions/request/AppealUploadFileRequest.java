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
public class AppealUploadFileRequest {

    // 1
    @Schema(name = "Appeal ID", example = "1")
    @JsonProperty("in_appeal_id")
    private Integer appealId;

    // 2
    @Schema(name = "Appeal Type ID", example = "1")
    @JsonProperty("in_appeal_type_id")
    private Short appealTypeId;

    // 3
    @Schema(name = "Test Server ID", example = "1")
    @JsonProperty("in_test_server_id")
    private Short testServerId;

}
