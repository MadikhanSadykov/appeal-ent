package kz.testcenter.app.appealent.model.functions.response.appeal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppealResultDescriptionFileResponse {

    // 0
    @JsonProperty("out_id")
    private BigInteger id;

    // 1
    @JsonProperty("out_file_data")
    private byte[] fileData;

    public static AppealResultDescriptionFileResponse build(Map<Integer, Object> fieldNumberOfAppealResultDescriptionFileMap) {
        return new AppealResultDescriptionFileResponse(
                (BigInteger) fieldNumberOfAppealResultDescriptionFileMap.get(0),
                (byte[]) fieldNumberOfAppealResultDescriptionFileMap.get(1)
        );
    }

}
