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
public class StudentInfoResponse {

    // 1
    @JsonProperty("out_online_student_test_id")
    private Integer onlineStudentTestId;

    // 2
    @JsonProperty("out_iin")
    private String iin;

    // 3
    @JsonProperty("out_lastname")
    private String lastName;

    // 4
    @JsonProperty("out_firstname")
    private String firstName;

    // 5
    @JsonProperty("out_patronymic")
    private String patronymic;

    // 6
    @JsonProperty("out_test_started_at")
    private String testStartedAt;

    // 7
    @JsonProperty("out_remote_student_test_id")
    private Integer remoteStudentTestId;

    public static StudentInfoResponse build(Map<Integer, Object> fieldNumberOfStudentInfoResponseMap) {
        return new StudentInfoResponse(
                (Integer) fieldNumberOfStudentInfoResponseMap.get(1),
                (String) fieldNumberOfStudentInfoResponseMap.get(2),
                (String) fieldNumberOfStudentInfoResponseMap.get(3),
                (String) fieldNumberOfStudentInfoResponseMap.get(4),
                (String) fieldNumberOfStudentInfoResponseMap.get(5),
                (String) fieldNumberOfStudentInfoResponseMap.get(6),
                (Integer) fieldNumberOfStudentInfoResponseMap.get(7)
        );
    }

}
