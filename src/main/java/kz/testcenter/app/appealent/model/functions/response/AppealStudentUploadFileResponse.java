package kz.testcenter.app.appealent.model.functions.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppealStudentUploadFileResponse {

    // 1
    @JsonProperty("out_student_test_id")
    private Integer studentTestId;

    // 2
    @JsonProperty("out_appeal_id")
    private Integer appealId;

    // 3
    @JsonProperty("out_file_id")
    private Integer fileId;

    // 4
    @JsonProperty("out_file_name")
    private String fileName;

    // 5
    @JsonProperty("out_test_server_id")
    private Short testServerId;

    // 6
    @JsonProperty("out_created_at")
    private Timestamp createdAt;

    public static AppealStudentUploadFileResponse build(
            Map<Integer, Object> fieldNumberOfAppealStudentUploadFileResponseMap) {
        return new AppealStudentUploadFileResponse(
                (Integer) fieldNumberOfAppealStudentUploadFileResponseMap.get(1),
                (Integer) fieldNumberOfAppealStudentUploadFileResponseMap.get(2),
                (Integer) fieldNumberOfAppealStudentUploadFileResponseMap.get(3),
                (String) fieldNumberOfAppealStudentUploadFileResponseMap.get(4),
                (Short) fieldNumberOfAppealStudentUploadFileResponseMap.get(5),
                (Timestamp) fieldNumberOfAppealStudentUploadFileResponseMap.get(6)
        );
    }

}
