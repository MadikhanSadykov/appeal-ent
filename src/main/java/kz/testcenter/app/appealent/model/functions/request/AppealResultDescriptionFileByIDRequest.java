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
public class AppealResultDescriptionFileByIDRequest {

    // 1
    @Schema(name = "File ID", example = "1", required = true)
    @JsonProperty("in_file_id")
    private Integer fileId;

    @JsonProperty("log")
    private WriteLogRequest writeLogRequest;

}
