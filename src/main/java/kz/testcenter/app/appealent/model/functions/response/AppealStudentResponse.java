package kz.testcenter.app.appealent.model.functions.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppealStudentResponse {

    // 1
    @JsonProperty("out_appeal_id")
    private Integer appealId;

    // 2
    @JsonProperty("out_test_server_id")
    private Short testServerId;

    // 3
    @JsonProperty("out_appeal_type_id")
    private Short appealTypeId;

    // 4
    @JsonProperty("out_subject_id")
    private Integer subjectId;

    // 5
    @JsonProperty("out_created_at")
    private Date createdAt;

    // 6
    @JsonProperty("out_appeal_status_name_kaz")
    private String appealStatusNameKaz;

    // 7
    @JsonProperty("out_appeal_status_name_rus")
    private String appealStatusNameRus;

    // 8
    @JsonProperty("out_appeal_result_name_kaz")
    private String appealResultNameKaz;

    // 9
    @JsonProperty("out_appeal_result_name_rus")
    private String appealResultNameRus;

    // 10
    @JsonProperty("out_subject_name_kaz")
    private String subjectNameKaz;

    // 11
    @JsonProperty("out_subject_name_rus")
    private String subjectNameRus;

    // 12
    @JsonProperty("out_appeal_score")
    private Short appealScore;

    // 13
    @JsonProperty("out_test_score")
    private Short testScore;

    // 14
    @JsonProperty("out_appeal_reason_type_kaz")
    private String appealReasonTypeKaz;

    // 15
    @JsonProperty("out_appeal_reason_type_rus")
    private String appealReasonTypeRus;

    // 16
    @JsonProperty("out_student_appeal_reason_description")
    private String studentAppealReasonDescription;

    // 17
    @JsonProperty("out_expert_reason_type_name_kaz")
    private String expertReasonTypeNameKaz;

    // 18
    @JsonProperty("out_expert_reason_type_name_rus")
    private String expertReasonTypeNameRus;

    public static AppealStudentResponse build(Map<Integer, Object> fieldNumberOfAppealStudentResponseMap) {
        return new AppealStudentResponse(
                (Integer) fieldNumberOfAppealStudentResponseMap.get(1),
                (Short) fieldNumberOfAppealStudentResponseMap.get(2),
                (Short)fieldNumberOfAppealStudentResponseMap.get(3),
                (Integer) fieldNumberOfAppealStudentResponseMap.get(4),
                (Date) fieldNumberOfAppealStudentResponseMap.get(5),
                (String) fieldNumberOfAppealStudentResponseMap.get(6),
                (String) fieldNumberOfAppealStudentResponseMap.get(7),
                (String) fieldNumberOfAppealStudentResponseMap.get(8),
                (String) fieldNumberOfAppealStudentResponseMap.get(9),
                (String) fieldNumberOfAppealStudentResponseMap.get(10),
                (String) fieldNumberOfAppealStudentResponseMap.get(11),
                (Short)fieldNumberOfAppealStudentResponseMap.get(12),
                (Short)fieldNumberOfAppealStudentResponseMap.get(13),
                (String) fieldNumberOfAppealStudentResponseMap.get(14),
                (String) fieldNumberOfAppealStudentResponseMap.get(15),
                (String) fieldNumberOfAppealStudentResponseMap.get(16),
                (String) fieldNumberOfAppealStudentResponseMap.get(17),
                (String) fieldNumberOfAppealStudentResponseMap.get(18));
    }

}
