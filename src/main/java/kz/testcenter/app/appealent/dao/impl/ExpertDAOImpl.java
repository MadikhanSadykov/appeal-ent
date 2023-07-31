package kz.testcenter.app.appealent.dao.impl;

import kz.testcenter.app.appealent.dao.ExpertDAO;
import kz.testcenter.app.appealent.model.functions.request.SetExpertPrevResultRequest;
import kz.testcenter.app.appealent.model.functions.response.ExpertSubjectListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_APPEAL_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_APPEAL_TYPE_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_EXPERT_APPEAL_PREV_APPEAL_SCORE_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_EXPERT_APPEAL_PREV_RESULT_TYPE_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_EXPERT_APPEAL_REASON_TYPE_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_EXPERT_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_TEST_SERVER_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_TEST_TYPE_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_USER_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNameConstant.GET_EXPERT_SUBJECT_LIST_FUNCTION;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNameConstant.SET_EXPERT_PREV_RESULT_FUNCTION;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNumberOfFieldsConstant.NUMBER_OF_RETURN_FIELDS_OF_GET_EXPERT_SUBJECT_LIST_FUNCTION;

@Component
@RequiredArgsConstructor
public class ExpertDAOImpl implements ExpertDAO {

    private final EntityManager entityManager;

    @Override
    @Transactional
    public List<ExpertSubjectListResponse> getExpertSubjectListFun(Integer userId, Short testTypeId) {
        StoredProcedureQuery query = entityManager
                .createStoredProcedureQuery(GET_EXPERT_SUBJECT_LIST_FUNCTION)
                .registerStoredProcedureParameter(IN_USER_ID_FIELD, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_TEST_TYPE_ID_FIELD, Short.class, ParameterMode.IN)

                .setParameter(IN_USER_ID_FIELD, userId)
                .setParameter(IN_TEST_TYPE_ID_FIELD, testTypeId);

        query.execute();
        List<Object[]> queryResultTable = query.getResultList();
        List<ExpertSubjectListResponse> expertSubjectListResponses = new ArrayList<>();

        for (Object[] tableRow : queryResultTable) {
            Map<Integer, Object> fieldNumberOfExpertSubjectListResponseMap = new HashMap<>();
            for (int numOfColumn = 0;
                 numOfColumn < NUMBER_OF_RETURN_FIELDS_OF_GET_EXPERT_SUBJECT_LIST_FUNCTION;
                 numOfColumn++) {
                fieldNumberOfExpertSubjectListResponseMap.put(numOfColumn + 1, tableRow[numOfColumn]);
            }
            expertSubjectListResponses.add(
                    ExpertSubjectListResponse
                            .build(fieldNumberOfExpertSubjectListResponseMap));
        }
        return expertSubjectListResponses;
    }

    @Override
    public Short setExpertPrevResult(SetExpertPrevResultRequest setExpertPrevResultRequest) {
        StoredProcedureQuery query = entityManager
                .createStoredProcedureQuery(SET_EXPERT_PREV_RESULT_FUNCTION)
                .registerStoredProcedureParameter(IN_APPEAL_ID_FIELD, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_APPEAL_TYPE_ID_FIELD, Short.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_TEST_SERVER_ID_FIELD, Short.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_EXPERT_ID_FIELD, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_EXPERT_APPEAL_REASON_TYPE_ID_FIELD, Short.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_EXPERT_APPEAL_PREV_RESULT_TYPE_ID_FIELD, Short.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_EXPERT_APPEAL_PREV_APPEAL_SCORE_FIELD, Short.class, ParameterMode.IN)

                .setParameter(IN_APPEAL_ID_FIELD, setExpertPrevResultRequest.getAppealId())
                .setParameter(IN_APPEAL_TYPE_ID_FIELD, setExpertPrevResultRequest.getAppealTypeId())
                .setParameter(IN_TEST_SERVER_ID_FIELD, setExpertPrevResultRequest.getTestServerId())
                .setParameter(IN_EXPERT_ID_FIELD, setExpertPrevResultRequest.getExpertId())
                .setParameter(IN_EXPERT_APPEAL_REASON_TYPE_ID_FIELD, setExpertPrevResultRequest.getExpertAppealReasonTypeId())
                .setParameter(IN_EXPERT_APPEAL_PREV_RESULT_TYPE_ID_FIELD, setExpertPrevResultRequest.getExpertAppealPrevResultTypeId())
                .setParameter(IN_EXPERT_APPEAL_PREV_APPEAL_SCORE_FIELD, setExpertPrevResultRequest.getExpertAppealPrevAppealScore());

        query.executeUpdate();
        return (Short) query.getSingleResult();
    }

}
