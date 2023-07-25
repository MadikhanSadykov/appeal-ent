package kz.testcenter.app.appealent.dao.impl;

import kz.testcenter.app.appealent.dao.ExpertDAO;
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

import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_TEST_TYPE_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_USER_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNameConstant.GET_EXPERT_SUBJECT_LIST_FUNCTION;
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
}
