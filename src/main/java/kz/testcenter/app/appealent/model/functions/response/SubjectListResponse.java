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
public class SubjectListResponse {

    // 1
    @JsonProperty("out_test_type_id")
    private Short testTypeId;

    // 2
    @JsonProperty("out_subject_id")
    private Integer subjectId;

    // 3
    @JsonProperty("out_subject_name_kaz")
    private String subjectNameKaz;

    // 4
    @JsonProperty("out_subject_name_rus")
    private String subjectNameRus;

    // 5
    @JsonProperty("out_lang_id")
    private Short langId;

    // 6
    @JsonProperty("out_lang_name_kaz")
    private String langNameKaz;

    // 7
    @JsonProperty("out_lang_name_rus")
    private String langNameRus;

    public static SubjectListResponse build(Map<Integer, Object> fieldNumberOfSubjectListResponseMap) {
        return new SubjectListResponse(
                (Short) fieldNumberOfSubjectListResponseMap.get(1),
                (Integer) fieldNumberOfSubjectListResponseMap.get(2),
                (String) fieldNumberOfSubjectListResponseMap.get(3),
                (String) fieldNumberOfSubjectListResponseMap.get(4),
                (Short) fieldNumberOfSubjectListResponseMap.get(5),
                (String) fieldNumberOfSubjectListResponseMap.get(6),
                (String) fieldNumberOfSubjectListResponseMap.get(7));
    }

}
