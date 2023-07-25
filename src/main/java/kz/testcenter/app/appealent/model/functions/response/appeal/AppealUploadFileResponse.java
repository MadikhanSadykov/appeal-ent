package kz.testcenter.app.appealent.model.functions.response.appeal;

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
public class AppealUploadFileResponse {

    // 1
    @JsonProperty("out_id")
    private Integer id;

    // 2
    @JsonProperty("out_file_name")
    private String fileName;

    // 3
    @JsonProperty("out_test_server_id")
    private Short testServerId;

    // 4
    @JsonProperty("out_created_at")
    private Timestamp createdAt;

    public static AppealUploadFileResponse build(Map<Integer, Object> fieldNumberOfAppealUploadFileResponseMap) {
        return new AppealUploadFileResponse(
                (Integer) fieldNumberOfAppealUploadFileResponseMap.get(1),
                (String) fieldNumberOfAppealUploadFileResponseMap.get(2),
                (Short) fieldNumberOfAppealUploadFileResponseMap.get(3),
                (Timestamp) fieldNumberOfAppealUploadFileResponseMap.get(4)
        );
    }
}
