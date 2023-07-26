package kz.testcenter.app.appealent.dao.impl;

import kz.testcenter.app.appealent.dao.SubjectDAO;
import kz.testcenter.app.appealent.model.functions.request.SubjectListRequest;
import kz.testcenter.app.appealent.model.functions.response.SubjectListResponse;
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

import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_CALL_FROM_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_EXPERT_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_ROLE_TYPE_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_TEST_TYPE_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_USER_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNameConstant.GET_SUBJECT_LIST_FUNCTION;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNumberOfFieldsConstant.NUMBER_OF_RETURN_FIELDS_OF_GET_SUBJECT_LIST_FUNCTION;

@Component
@RequiredArgsConstructor
public class SubjectDAOImpl implements SubjectDAO {

    private final EntityManager entityManager;

    @Override
    @Transactional
    public List<SubjectListResponse> getSubjectList(SubjectListRequest subjectListRequest) {
        StoredProcedureQuery query = entityManager
                .createStoredProcedureQuery(GET_SUBJECT_LIST_FUNCTION)
                .registerStoredProcedureParameter(IN_USER_ID_FIELD, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_ROLE_TYPE_ID_FIELD, Short.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_TEST_TYPE_ID_FIELD, Short.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_EXPERT_ID_FIELD, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_CALL_FROM_ID_FIELD, Short.class, ParameterMode.IN)

                .setParameter(IN_USER_ID_FIELD, subjectListRequest.getUserId())
                .setParameter(IN_ROLE_TYPE_ID_FIELD, subjectListRequest.getRoleTypeId())
                .setParameter(IN_TEST_TYPE_ID_FIELD, subjectListRequest.getTestTypeId())
                .setParameter(IN_EXPERT_ID_FIELD, subjectListRequest.getExpertId())
                .setParameter(IN_CALL_FROM_ID_FIELD, subjectListRequest.getCallFromId());

        query.execute();
        List<Object[]> queryResultTable = query.getResultList();
        List<SubjectListResponse> subjectListResponses = new ArrayList<>();

        for (Object[] tableRow : queryResultTable) {
            Map<Integer, Object> fieldNumberOfSubjectListResponseMap = new HashMap<>();
            for (int numOfColumn = 0; numOfColumn < NUMBER_OF_RETURN_FIELDS_OF_GET_SUBJECT_LIST_FUNCTION; numOfColumn++) {
                fieldNumberOfSubjectListResponseMap.put(numOfColumn + 1, tableRow[numOfColumn]);
            }
            subjectListResponses.add(SubjectListResponse.build(fieldNumberOfSubjectListResponseMap));
        }
        return subjectListResponses;
    }

}
