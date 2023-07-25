package kz.testcenter.app.appealent.model.functions.response.appeal;

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
public class AppealByIDResponse {

    // 0
    @JsonProperty("out_additional_text_id")
    private Integer additionalTextId;

    // 1
    @JsonProperty("out_additional_text_url")
    private String additionalTextUrl;

    // 2
    @JsonProperty("out_additional_text_b64")
    private String additionalTextB64;

    // 3
    @JsonProperty("out_question_b64")
    private String questionB64;

    // 4
    @JsonProperty("out_answers_ord")
    private Short answersOrd;

    // 5
    @JsonProperty("out_letter")
    private String letter;

    // 6
    @JsonProperty("out_answer_b64")
    private String answerB64;

    // 7
    @JsonProperty("out_is_selected")
    private Short isSelected;

    // 8
    @JsonProperty("out_is_correct_answers")
    private Short isCorrectAnswers;

    // 9
    @JsonProperty("out_additional_text_type_id")
    private Short additionalTextTypeId;

    // 10
    @JsonProperty("out_question_type_id")
    private Short questionTypeId;

    // 11
    @JsonProperty("out_question_id")
    private Integer questionId;

    public static AppealByIDResponse build(Map<Integer, Object> numberAndFieldOfAppealByIDResponse) {
        return new AppealByIDResponse(
                (Integer) numberAndFieldOfAppealByIDResponse.get(0),
                (String) numberAndFieldOfAppealByIDResponse.get(1),
                (String) numberAndFieldOfAppealByIDResponse.get(2),
                (String) numberAndFieldOfAppealByIDResponse.get(3),
                (Short) numberAndFieldOfAppealByIDResponse.get(4),
                (String) numberAndFieldOfAppealByIDResponse.get(5),
                (String) numberAndFieldOfAppealByIDResponse.get(6),
                (Short) numberAndFieldOfAppealByIDResponse.get(7),
                (Short) numberAndFieldOfAppealByIDResponse.get(8),
                (Short) numberAndFieldOfAppealByIDResponse.get(9),
                (Short) numberAndFieldOfAppealByIDResponse.get(10),
                (Integer) numberAndFieldOfAppealByIDResponse.get(11)
        );
    }

}
