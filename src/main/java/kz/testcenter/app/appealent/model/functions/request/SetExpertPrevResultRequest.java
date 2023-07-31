package kz.testcenter.app.appealent.model.functions.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SetExpertPrevResultRequest {

    // 1
    @JsonProperty("in_appeal_id")
    private Integer appealId;

    // 2
    @JsonProperty("in_appeal_type_id")
    private Short appealTypeId;

    // 3
    @JsonProperty("in_test_server_id")
    private Short testServerId;

    // 4
    @JsonProperty("in_expert_id")
    private Integer expertId;

    // 5
    @JsonProperty("in_expert_appeal_reason_type_id")
    private Short expertAppealReasonTypeId;

    // 6
    @JsonProperty("in_expert_appeal_prev_result_type_id")
    private Short expertAppealPrevResultTypeId;

    // 7
    @JsonProperty("in_expert_appeal_prev_appeal_score")
    private Short expertAppealPrevAppealScore;

    @JsonProperty("log")
    private WriteLogRequest writeLogRequest;

}
