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
public class AppealStatisticByQuestionResponse {

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
    @JsonProperty("out_cnt_question_all")
    private Integer cntQuestionAll;

    // 7
    @JsonProperty("out_cnt_question_all_udov")
    private Integer cntQuestionAllUdov;

    // 8
    @JsonProperty("out_cnt_question_all_neudov")
    private Integer cntQuestionAllNeudov;

    // 9
    @JsonProperty("out_cnt_qid_content_all")
    private Integer cntQidContentAll;

    // 10
    @JsonProperty("out_cnt_qid_tech_all")
    private Integer cntQidTechAll;

    // 11
    @JsonProperty("out_cnt_qid_udov_content")
    private Integer cntQidUdovContent;

    // 12
    @JsonProperty("out_cnt_qid_udov_tech")
    private Integer cntQidUdovTech;

    // 13
    @JsonProperty("out_cnt_qid_neudov_content")
    private Integer cntQidNeudovContent;

    // 14
    @JsonProperty("out_cnt_qid_neudov_tech")
    private Integer cntQidNeudovTech;

    // 15
    @JsonProperty("out_cnt_appeal_all")
    private Integer cntAppealAll;

    // 16
    @JsonProperty("out_cnt_content_all")
    private Integer cntContentAll;

    // 17
    @JsonProperty("out_cnt_tech_all")
    private Integer cntTechAll;

    // 18
    @JsonProperty("out_cnt_finish_all")
    private Integer cntFinishAll;

    // 19
    @JsonProperty("out_cnt_finish_content")
    private Integer cntFinishContent;

    // 20
    @JsonProperty("out_cnt_finish_tech")
    private Integer cntFinishTech;

    // 21
    @JsonProperty("out_cnt_none_all")
    private Integer cntNoneAll;

    // 22
    @JsonProperty("out_cnt_none_content")
    private Integer cntNoneContent;

    // 23
    @JsonProperty("out_cnt_none_tech")
    private Integer cntNoneTech;

    // 24
    @JsonProperty("out_cnt_raspred")
    private Integer cntRaspred;

    // 25
    @JsonProperty("out_cnt_raspred_content")
    private Integer cntRaspredContent;

    // 26
    @JsonProperty("out_cnt_raspred_tech")
    private Integer cntRaspredTech;

    // 27
    @JsonProperty("out_cnt_work")
    private Integer cntWork;

    // 28
    @JsonProperty("out_cnt_work_content")
    private Integer cntWorkContent;

    // 29
    @JsonProperty("out_cnt_work_tech")
    private Integer cntWorkTech;

    // 30
    @JsonProperty("out_cnt_pred")
    private Integer cntPred;

    // 31
    @JsonProperty("out_cnt_pred_content")
    private Integer cntPredContent;

    // 32
    @JsonProperty("out_cnt_pred_tech")
    private Integer cntPredTech;

    // 33
    @JsonProperty("out_cnt_predend")
    private Integer cntPredend;

    // 34
    @JsonProperty("out_cnt_predend_content")
    private Integer cntPredendContent;

    // 35
    @JsonProperty("out_cnt_predend_tech")
    private Integer cntPredendTech;

    // 36
    @JsonProperty("out_cnt_predback")
    private Integer cntpredback;

    // 37
    @JsonProperty("out_cnt_predback_content")
    private Integer cntPredbackContent;

    // 38
    @JsonProperty("out_cnt_predback_tech")
    private Integer cntPredbackTech;

    // 39
    @JsonProperty("out_cnt_neudov")
    private Integer cntNeudov;

    // 40
    @JsonProperty("out_cnt_neudov_content")
    private Integer cntNeudovContent;

    // 41
    @JsonProperty("out_cnt_neudov_tech")
    private Integer cntNeudovTech;

    // 42
    @JsonProperty("out_cnt_prev_udov_all")
    private Integer cntPrevUdovAll;

    // 43
    @JsonProperty("out_cnt_prev_udov_content")
    private Integer cntPrevUdovContent;

    // 44
    @JsonProperty("out_cnt_prev_udov_tech")
    private Integer cntPrevUdovTech;

    // 45
    @JsonProperty("out_cnt_prev_udov_one")
    private Integer cntPrevUdovOne;

    // 46
    @JsonProperty("out_cnt_prev_udov_one_content")
    private Integer cntPrevUdovOneContent;

    // 47
    @JsonProperty("out_cnt_prev_udov_one_tech")
    private Integer cntPrevUdovOneTech;

    // 48
    @JsonProperty("out_cnt_prev_udov_two")
    private Integer cntPrevUdovTwo;

    // 49
    @JsonProperty("out_cnt_prev_udov_two_content")
    private Integer cntPrevUdovTwoContent;

    // 50
    @JsonProperty("out_cnt_prev_udov_two_tech")
    private Integer IntegercntPrevUdovTwoTech;

    // 51
    @JsonProperty("out_cnt_udov_all")
    private Integer cntUdovAll;

    // 52
    @JsonProperty("out_cnt_udov_content")
    private Integer cntUdovContent;

    // 53
    @JsonProperty("out_cnt_udov_tech")
    private Integer cntUdovTech;

    // 54
    @JsonProperty("out_cnt_udov_one")
    private Integer cntUdovOne;

    // 55
    @JsonProperty("out_cnt_udov_one_content")
    private Integer cntUdovOneContent;

    // 56
    @JsonProperty("out_cnt_udov_one_tech")
    private Integer cntUdovOneTech;

    // 57
    @JsonProperty("out_cnt_udov_two")
    private Integer cntUdovTwo;

    // 58
    @JsonProperty("out_cnt_udov_two_content")
    private Integer cntUdovTwoContent;

    // 59
    @JsonProperty("out_cnt_udov_two_tech")
    private Integer cntUdovTwoTech;

    public static AppealStatisticByQuestionResponse build(
            Map<Integer, Object> fieldNumberOfAppealStatisticByQuestionResponseMap) {
        return new AppealStatisticByQuestionResponse(
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(1),
                (String) fieldNumberOfAppealStatisticByQuestionResponseMap.get(2),
                (String) fieldNumberOfAppealStatisticByQuestionResponseMap.get(3),
                (String) fieldNumberOfAppealStatisticByQuestionResponseMap.get(4),
                (String) fieldNumberOfAppealStatisticByQuestionResponseMap.get(5),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(6),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(7),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(8),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(9),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(10),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(11),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(12),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(13),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(14),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(15),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(16),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(17),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(18),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(19),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(20),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(21),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(22),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(23),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(24),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(25),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(26),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(27),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(28),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(29),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(30),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(31),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(32),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(33),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(34),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(35),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(36),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(37),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(38),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(39),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(40),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(41),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(42),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(43),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(44),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(45),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(46),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(47),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(48),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(49),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(50),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(51),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(52),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(53),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(54),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(55),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(56),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(57),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(58),
                (Integer) fieldNumberOfAppealStatisticByQuestionResponseMap.get(59)
        );
    }

}
