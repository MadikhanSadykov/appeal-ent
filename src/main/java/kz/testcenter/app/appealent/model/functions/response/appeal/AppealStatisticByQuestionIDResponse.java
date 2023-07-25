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
public class AppealStatisticByQuestionIDResponse {

    // 1
    @JsonProperty("out_subject_id")
    private Integer subjectId;

    // 2
    @JsonProperty("out_subject_name_kaz")
    private String subjectNameKaz;

    // 3
    @JsonProperty("out_subject_name_rus")
    private String subjectNameRus;

    // 4
    @JsonProperty("out_lang_name_kaz")
    private String langNameKaz;

    // 5
    @JsonProperty("out_lang_name_rus")
    private String langNameRus;

    // 6
    @JsonProperty("out_question_id")
    private Integer questionId;

    // 7
    @JsonProperty("out_cnt_appeal_all")
    private Integer cntAppealAll;

    // 8
    @JsonProperty("out_cnt_content_all")
    private Integer cntContentAll;

    // 9
    @JsonProperty("out_cnt_tech_all")
    private Integer cntTechAll;

    // 10
    @JsonProperty("out_cnt_finish_all")
    private Integer cntFinishAll;

    // 11
    @JsonProperty("out_cnt_finish_content")
    private Integer cntFinishContent;

    // 12
    @JsonProperty("out_cnt_finish_tech")
    private Integer cntFinishTech;

    // 13
    @JsonProperty("out_cnt_none_all")
    private Integer cntNoneAll;

    // 14
    @JsonProperty("out_cnt_none_content")
    private Integer cntNoneContent;

    // 15
    @JsonProperty("out_cnt_none_tech")
    private Integer cntNoneTech;

    // 16
    @JsonProperty("out_cnt_raspred")
    private Integer cntRaspred;

    // 17
    @JsonProperty("out_cnt_raspred_content")
    private Integer cntRaspredContent;

    // 18
    @JsonProperty("out_cnt_raspred_tech")
    private Integer cntRaspredTech;

    // 19
    @JsonProperty("out_cnt_work")
    private Integer cntWork;

    // 20
    @JsonProperty("out_cnt_work_content")
    private Integer cntWorkContent;

    // 21
    @JsonProperty("out_cnt_work_tech")
    private Integer cntWorkTech;

    // 22
    @JsonProperty("out_cnt_pred")
    private Integer cntPred;

    // 23
    @JsonProperty("out_cnt_pred_content")
    private Integer cntPredContent;

    // 24
    @JsonProperty("out_cnt_pred_tech")
    private Integer cntPredTech;

    // 25
    @JsonProperty("out_cnt_predend")
    private Integer cntPredend;

    // 26
    @JsonProperty("out_cnt_predend_content")
    private Integer cntPredendContent;

    // 27
    @JsonProperty("out_cnt_predend_tech")
    private Integer cntPredendTech;

    // 28
    @JsonProperty("out_cnt_predback")
    private Integer cntpredback;

    // 29
    @JsonProperty("out_cnt_predback_content")
    private Integer cntPredbackContent;

    // 30
    @JsonProperty("out_cnt_predback_tech")
    private Integer cntPredbackTech;

    // 31
    @JsonProperty("out_cnt_neudov")
    private Integer cntNeudov;

    // 32
    @JsonProperty("out_cnt_neudov_content")
    private Integer cntNeudovContent;

    // 33
    @JsonProperty("out_cnt_neudov_tech")
    private Integer cntNeudovTech;

    // 34
    @JsonProperty("out_cnt_prev_udov_all")
    private Integer cntPrevUdovAll;

    // 35
    @JsonProperty("out_cnt_prev_udov_content")
    private Integer cntPrevUdovContent;

    // 36
    @JsonProperty("out_cnt_prev_udov_tech")
    private Integer cntPrevUdovTech;

    // 37
    @JsonProperty("out_cnt_prev_udov_one")
    private Integer cntPrevUdovOne;

    // 38
    @JsonProperty("out_cnt_prev_udov_one_content")
    private Integer cntPrevUdovOneContent;


    // 39
    @JsonProperty("out_cnt_prev_udov_one_tech")
    private Integer cntPrevUdovOneTech;

    // 40
    @JsonProperty("out_cnt_prev_udov_two")
    private Integer cntPrevUdovTwo;

    // 41
    @JsonProperty("out_cnt_prev_udov_two_content")
    private Integer cntPrevUdovTwoContent;

    // 42
    @JsonProperty("out_cnt_prev_udov_two_tech")
    private Integer IntegercntPrevUdovTwoTech;

    // 43
    @JsonProperty("out_cnt_udov_all")
    private Integer cntUdovAll;

    // 44
    @JsonProperty("out_cnt_udov_content")
    private Integer cntUdovContent;

    // 45
    @JsonProperty("out_cnt_udov_tech")
    private Integer cntUdovTech;

    // 46
    @JsonProperty("out_cnt_udov_one")
    private Integer cntUdovOne;

    // 47
    @JsonProperty("out_cnt_udov_one_content")
    private Integer cntUdovOneContent;

    // 48
    @JsonProperty("out_cnt_udov_one_tech")
    private Integer cntUdovOneTech;

    // 49
    @JsonProperty("out_cnt_udov_two")
    private Integer cntUdovTwo;

    // 50
    @JsonProperty("out_cnt_udov_two_content")
    private Integer cntUdovTwoContent;

    // 51
    @JsonProperty("out_cnt_udov_two_tech")
    private Integer cntUdovTwoTech;

    public static AppealStatisticByQuestionIDResponse build(
            Map<Integer, Object> fieldNumberOfAppealStatisticByQuestionIDResponseMap) {
        return new AppealStatisticByQuestionIDResponse(
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(1),
                (String) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(2),
                (String) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(3),
                (String) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(4),
                (String) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(5),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(6),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(7),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(8),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(9),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(10),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(11),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(12),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(13),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(14),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(15),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(16),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(17),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(18),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(19),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(20),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(21),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(22),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(23),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(24),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(25),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(26),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(27),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(28),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(29),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(30),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(31),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(32),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(33),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(34),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(35),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(36),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(37),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(38),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(39),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(40),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(41),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(42),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(43),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(44),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(45),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(46),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(47),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(48),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(49),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(50),
                (Integer) fieldNumberOfAppealStatisticByQuestionIDResponseMap.get(51)
        );
    }
}
