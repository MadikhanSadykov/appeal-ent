package kz.testcenter.app.appealent.model.functions.response.appeal;

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
public class AppealListResponse {

    // 0
    @JsonProperty("out_appeal_id")
    private Integer appealId;
    // 1
    @JsonProperty("out_test_server_id")
    private Short testServerId;
    // 2
    @JsonProperty("out_appeal_type_id")
    private Short appealTypeId;
    // 3
    @JsonProperty("out_appeal_type_name_kaz")
    private String appealTypeNameKaz;
    // 4
    @JsonProperty("out_appeal_type_name_rus")
    private String appealTypeNameRus;
    // 5
    @JsonProperty("out_test_type_id")
    private Short testTypeId;
    // 6
    @JsonProperty("out_student_test_id")
    private Integer studentTestId;
    // 7
    @JsonProperty("out_student_test_subject_id")
    private Integer studentTestSubjectId;
    // 8
    @JsonProperty("out_subject_id")
    private Integer subjectId;
    // 9
    @JsonProperty("out_subject_name_kaz")
    private String subjectNameKaz;
    // 10
    @JsonProperty("out_subject_name_rus")
    private String subjectNameRus;
    // 11
    @JsonProperty("out_lang_id")
    private Short langId;
    // 12
    @JsonProperty("out_lang_name_kaz")
    private String langNameKaz;
    // 13
    @JsonProperty("out_lang_name_rus")
    private String langNameRus;
    // 14
    @JsonProperty("out_var_subject_id")
    private Integer varSubjectId;
    // 15
    @JsonProperty("out_variant_from_db_test")
    private Integer variantFromDbTest;
    // 16
    @JsonProperty("out_additional_text_id")
    private Integer additionalTextId;
    // 17
    @JsonProperty("out_additional_text_type_id")
    private Short additionalTextTypeId;
    // 18
    @JsonProperty("out_additional_text_type_name_kaz")
    private String additionalTextTypeNameKaz;
    // 19
    @JsonProperty("out_additional_text_type_name_rus")
    private String additionalTextTypeNameRus;
    // 20
    @JsonProperty("out_question_num")
    private Short questionNum;
    // 21
    @JsonProperty("out_question_type_id")
    private Short questionTypeId;
    // 22
    @JsonProperty("question_type_name_kaz")
    private String questionTypeNameKaz;
    // 23
    @JsonProperty("out_question_type_name_rus")
    private String questionTypeNameRus;
    // 24
    @JsonProperty("out_question_id")
    private Integer questionId;
    // 25
    @JsonProperty("out_sub_subject_id")
    private Integer subSubjectId;
    // 26
    @JsonProperty("out_sub_subject_name_kaz")
    private String subSubjectNameKaz;
    // 27
    @JsonProperty("out_sub_subject_name_rus")
    private String subSubjectNameRus;
    //28
    @JsonProperty("out_can_appeal")
    private Short canAppeal;
    // 29
    @JsonProperty("out_student_appeal_reason_type_id")
    private Short studentAppealReasonTypeId;
    // 30
    @JsonProperty("out_student_appeal_reason_name_kaz")
    private String studentAppealReasonNameKaz;
    // 31
    @JsonProperty("out_student_appeal_reason_name_rus")
    private String studentAppealReasonNameRus;
    // 32
    @JsonProperty("out_student_appeal_reason_description")
    private String studentAppealReasonDescription;
    // 33
    @JsonProperty("out_appeal_result_type_id")
    private Short appealResultTypeId;
    // 34
    @JsonProperty("out_appeal_result_type_kaz")
    private String appealResultTypeKaz;
    // 35
    @JsonProperty("out_appeal_result_type_rus")
    private String appealResultTypeRus;
    // 36
    @JsonProperty("out_test_score")
    private Short testScore;
    // 37
    @JsonProperty("out_max_available_score")
    private Short maxAvailableScore;
    // 38
    @JsonProperty("out_appeal_score")
    private Short appealScore;
    // 39
    @JsonProperty("out_appeal_status_type_id")
    private Short appealStatusTypeId;
    //40
    @JsonProperty("out_appeal_status_type_name_kaz")
    private String appealStatusTypeNameKaz;
    // 41
    @JsonProperty("out_appeal_status_type_name_rus")
    private String appealStatusTypeNameRus;
    // 42
    @JsonProperty("out_chairman_id")
    private Integer chairmanId;
    // 43
    @JsonProperty("out_chairman_name")
    private String chairmanName;
    // 44
    @JsonProperty("out_chairman_comment")
    private String chairmanComment;
    // 45
    @JsonProperty("out_chairman_set_agreement_at")
    private String chairmanSetAgreementAt;
    // 46
    @JsonProperty("out_expert_appeal_reason_type_id")
    private Short expertAppealReasonTypeId;
    // 47
    @JsonProperty("out_expert_appeal_reason_name_kaz")
    private String expertAppealReasonNameKaz;
    // 48
    @JsonProperty("out_expert_appeal_reason_name_rus")
    private String expertAppealReasonNameRus;
    // 49
    @JsonProperty("out_expert_appeal_prev_result_type_id")
    private Short expertAppealPrevResultTypeId;
    // 50
    @JsonProperty("out_expert_appeal_prev_result_name_kaz")
    private String expertAppealPrevResultNameKaz;
    // 51
    @JsonProperty("out_expert_appeal_prev_result_name_rus")
    private String expertAppealPrevResultNameRus;
    // 52
    @JsonProperty("out_expert_appeal_prev_appeal_score")
    private Short expertAppealPrevAppealScore;
    // 53
    @JsonProperty("out_expert_id")
    private Integer expertId;
    // 54
    @JsonProperty("out_expert_name")
    private String expertName;
    // 55
    @JsonProperty("out_expert_set_result_at")
    private String expertSetResultAt;
    // 56
    @JsonProperty("out_uploaded_file_id")
    private Integer uploadedFileId;
    // 57
    @JsonProperty("out_created_at")
    private Date createdAt;

    public static AppealListResponse build(Map<Integer, Object> numberAndFieldOfAppealListResponseMap) {
        return new AppealListResponse(
                (Integer) numberAndFieldOfAppealListResponseMap.get(0),
                (Short) numberAndFieldOfAppealListResponseMap.get(1),
                (Short) numberAndFieldOfAppealListResponseMap.get(2),
                (String) numberAndFieldOfAppealListResponseMap.get(3),
                (String) numberAndFieldOfAppealListResponseMap.get(4),
                (Short) numberAndFieldOfAppealListResponseMap.get(5),
                (Integer) numberAndFieldOfAppealListResponseMap.get(6),
                (Integer) numberAndFieldOfAppealListResponseMap.get(7),
                (Integer) numberAndFieldOfAppealListResponseMap.get(8),
                (String) numberAndFieldOfAppealListResponseMap.get(9),
                (String) numberAndFieldOfAppealListResponseMap.get(10),
                (Short) numberAndFieldOfAppealListResponseMap.get(11),
                (String) numberAndFieldOfAppealListResponseMap.get(12),
                (String) numberAndFieldOfAppealListResponseMap.get(13),
                (Integer) numberAndFieldOfAppealListResponseMap.get(14),
                (Integer) numberAndFieldOfAppealListResponseMap.get(15),
                (Integer) numberAndFieldOfAppealListResponseMap.get(16),
                (Short) numberAndFieldOfAppealListResponseMap.get(17),
                (String) numberAndFieldOfAppealListResponseMap.get(18),
                (String) numberAndFieldOfAppealListResponseMap.get(19),
                (Short) numberAndFieldOfAppealListResponseMap.get(20),
                (Short) numberAndFieldOfAppealListResponseMap.get(21),
                (String) numberAndFieldOfAppealListResponseMap.get(22),
                (String) numberAndFieldOfAppealListResponseMap.get(23),
                (Integer) numberAndFieldOfAppealListResponseMap.get(24),
                (Integer) numberAndFieldOfAppealListResponseMap.get(25),
                (String) numberAndFieldOfAppealListResponseMap.get(26),
                (String) numberAndFieldOfAppealListResponseMap.get(27),
                (Short) numberAndFieldOfAppealListResponseMap.get(28),
                (Short) numberAndFieldOfAppealListResponseMap.get(29),
                (String) numberAndFieldOfAppealListResponseMap.get(30),
                (String) numberAndFieldOfAppealListResponseMap.get(31),
                (String) numberAndFieldOfAppealListResponseMap.get(32),
                (Short) numberAndFieldOfAppealListResponseMap.get(33),
                (String) numberAndFieldOfAppealListResponseMap.get(34),
                (String) numberAndFieldOfAppealListResponseMap.get(35),
                (Short) numberAndFieldOfAppealListResponseMap.get(36),
                (Short) numberAndFieldOfAppealListResponseMap.get(37),
                (Short) numberAndFieldOfAppealListResponseMap.get(38),
                (Short) numberAndFieldOfAppealListResponseMap.get(39),
                (String) numberAndFieldOfAppealListResponseMap.get(40),
                (String) numberAndFieldOfAppealListResponseMap.get(41),
                (Integer) numberAndFieldOfAppealListResponseMap.get(42),
                (String) numberAndFieldOfAppealListResponseMap.get(43),
                (String) numberAndFieldOfAppealListResponseMap.get(44),
                (String) numberAndFieldOfAppealListResponseMap.get(45),
                (Short) numberAndFieldOfAppealListResponseMap.get(46),
                (String) numberAndFieldOfAppealListResponseMap.get(47),
                (String) numberAndFieldOfAppealListResponseMap.get(48),
                (Short) numberAndFieldOfAppealListResponseMap.get(49),
                (String) numberAndFieldOfAppealListResponseMap.get(50),
                (String) numberAndFieldOfAppealListResponseMap.get(51),
                (Short) numberAndFieldOfAppealListResponseMap.get(52),
                (Integer) numberAndFieldOfAppealListResponseMap.get(53),
                (String) numberAndFieldOfAppealListResponseMap.get(54),
                (String) numberAndFieldOfAppealListResponseMap.get(55),
                (Integer) numberAndFieldOfAppealListResponseMap.get(56),
                (Date) numberAndFieldOfAppealListResponseMap.get(57)
        );
    }
}
