package kz.testcenter.app.appealent.model.functions.response.appeal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppealResultDescriptionListByQuestionIDResponse {

    // 0
    @JsonProperty("out_id")
    private BigInteger id;

    // 1
    @JsonProperty("out_appeal_id")
    private Integer appealId;

    // 2
    @JsonProperty("out_original_question_id")
    private BigInteger originalQuestionId;

    // 3
    @JsonProperty("out_appeal_score")
    private Short appealScore;

    // 4
    @JsonProperty("out_student_reason_name")
    private String studentReasonName;

    // 5
    @JsonProperty("out_expert_reason_name")
    private String expertReasonName;

    // 6
    @JsonProperty("out_appeal_result_name")
    private String appealResultName;

    // 7
    @JsonProperty("out_appeal_status_name")
    private String appealStatusName;

    // 8
    @JsonProperty("out_appeal_type_name")
    private String appealTypeName;

    // 9
    @JsonProperty("out_appeal_created_at")
    private Timestamp appealCreatedAt;

    // 10
    @JsonProperty("out_result_file_created_at")
    private Timestamp resultFileCreatedAt;

    public static AppealResultDescriptionListByQuestionIDResponse build(
            Map<Integer, Object> fieldNumberOfAppealResultDescriptionListByQuestionIDResponseMap) {
        return new AppealResultDescriptionListByQuestionIDResponse(
                (BigInteger) fieldNumberOfAppealResultDescriptionListByQuestionIDResponseMap.get(0),
                (Integer) fieldNumberOfAppealResultDescriptionListByQuestionIDResponseMap.get(1),
                (BigInteger) fieldNumberOfAppealResultDescriptionListByQuestionIDResponseMap.get(2),
                (Short) fieldNumberOfAppealResultDescriptionListByQuestionIDResponseMap.get(3),
                (String) fieldNumberOfAppealResultDescriptionListByQuestionIDResponseMap.get(4),
                (String) fieldNumberOfAppealResultDescriptionListByQuestionIDResponseMap.get(5),
                (String) fieldNumberOfAppealResultDescriptionListByQuestionIDResponseMap.get(6),
                (String) fieldNumberOfAppealResultDescriptionListByQuestionIDResponseMap.get(7),
                (String) fieldNumberOfAppealResultDescriptionListByQuestionIDResponseMap.get(8),
                (Timestamp) fieldNumberOfAppealResultDescriptionListByQuestionIDResponseMap.get(9),
                (Timestamp) fieldNumberOfAppealResultDescriptionListByQuestionIDResponseMap.get(10));
    }

}
