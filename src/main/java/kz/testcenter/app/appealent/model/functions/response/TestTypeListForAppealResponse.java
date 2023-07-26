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
public class TestTypeListForAppealResponse {

    // 1
    @JsonProperty("id")
    private Short id;

    // 2
    @JsonProperty("name_kaz")
    private String nameKaz;

    // 3
    @JsonProperty("name_rus")
    private String nameRus;

    public static TestTypeListForAppealResponse build(Map<Integer, Object> fieldNumberOfTestTypeListForAppealResponseMap) {
        return new TestTypeListForAppealResponse(
                (Short) fieldNumberOfTestTypeListForAppealResponseMap.get(1),
                (String) fieldNumberOfTestTypeListForAppealResponseMap.get(2),
                (String) fieldNumberOfTestTypeListForAppealResponseMap.get(3)
        );
    }

}
