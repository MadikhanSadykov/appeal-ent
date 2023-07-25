package kz.testcenter.app.appealent.model.functions.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpertSubjectListResponse {

    // 1
    @JsonProperty("out_test_type_id")
    private Short testTypeId;

    // 2
    @JsonProperty("out_appeal_type_id")
    private Short appealTypeId;

    // 3
    @JsonProperty("out_subject_id")
    private Integer subjectId;

    // 4
    @JsonProperty("out_user_id")
    private Integer userId;

    // 5
    @JsonProperty("out_user_name")
    private String userName;

    // 6
    @JsonProperty("out_appeal_type_name_kaz")
    private String appealTypeNameKaz;

    // 7
    @JsonProperty("out_appeal_type_name_rus")
    private String appealTypeNameRus;

    // 8
    @JsonProperty("out_test_type_name_kaz")
    private String testTypeNameKaz;

    // 9
    @JsonProperty("out_test_type_name_rus")
    private String testTypeNameRus;

    // 10
    @JsonProperty("out_subject_name_kaz")
    private String subjectNameKaz;

    // 11
    @JsonProperty("out_subject_name_rus")
    private String subjectNameRus;

    // 12
    @JsonProperty("out_lang_id")
    private Short langId;

    // 13
    @JsonProperty("out_lang_name_kaz")
    private String langNameKaz;

    // 14
    @JsonProperty("out_lang_name_rus")
    private String langNameRus;

    public static ExpertSubjectListResponse build(Map<Integer, Object> fieldNumberOfExpertSubjectListResponseMap) {
        return new ExpertSubjectListResponse(
                (Short) fieldNumberOfExpertSubjectListResponseMap.get(1),
                (Short) fieldNumberOfExpertSubjectListResponseMap.get(2),
                (Integer) fieldNumberOfExpertSubjectListResponseMap.get(3),
                (Integer) fieldNumberOfExpertSubjectListResponseMap.get(4),
                (String) fieldNumberOfExpertSubjectListResponseMap.get(5),
                (String) fieldNumberOfExpertSubjectListResponseMap.get(6),
                (String) fieldNumberOfExpertSubjectListResponseMap.get(7),
                (String) fieldNumberOfExpertSubjectListResponseMap.get(8),
                (String) fieldNumberOfExpertSubjectListResponseMap.get(9),
                (String) fieldNumberOfExpertSubjectListResponseMap.get(10),
                (String) fieldNumberOfExpertSubjectListResponseMap.get(11),
                (Short) fieldNumberOfExpertSubjectListResponseMap.get(12),
                (String) fieldNumberOfExpertSubjectListResponseMap.get(13),
                (String) fieldNumberOfExpertSubjectListResponseMap.get(14)
        );
    }
}
