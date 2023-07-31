package kz.testcenter.app.appealent.model.functions.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppealStatisticByQuestionIDRequest {

    // 1
    @Schema(name = "Test Type Id", example = "1")
    @JsonProperty("in_test_type_id")
    private Short testTypeId;

    // 2
    @Schema(name = "Start Date", example = "2010-07-10")
    @JsonProperty("in_start_date")
    private Date startDate;

    // 3
    @Schema(name = "Finish date", example = "2025-07-10")
    @JsonProperty("in_finish_date")
    private Date finishDate;

    @JsonProperty("log")
    private WriteLogRequest writeLogRequest;

}
