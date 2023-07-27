package kz.testcenter.app.appealent.dao.impl;

import kz.testcenter.app.appealent.dao.UserDAO;
import kz.testcenter.app.appealent.model.functions.response.UserRestrictListResponse;
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

import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_ORG_TYPE_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_TEST_TYPE_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_USER_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNameConstant.GET_USER_RESTRICT_LIST_FUNCTION;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNumberOfFieldsConstant.NUMBER_OF_RETURN_FIELDS_OF_GET_USER_RESTRICT_LIST_FUNCTION;

@Component
@RequiredArgsConstructor
public class UserDAOImpl implements UserDAO {

    private final EntityManager entityManager;

    @Override
    @Transactional
    public List<UserRestrictListResponse> getUserRestrictListResponse(Integer userId, Short testTypeId, Short orgTypeId) {
        StoredProcedureQuery query = entityManager
                .createStoredProcedureQuery(GET_USER_RESTRICT_LIST_FUNCTION)
                .registerStoredProcedureParameter(IN_USER_ID_FIELD, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_TEST_TYPE_ID_FIELD, Short.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_ORG_TYPE_ID_FIELD, Short.class, ParameterMode.IN)

                .setParameter(IN_USER_ID_FIELD, userId)
                .setParameter(IN_TEST_TYPE_ID_FIELD, testTypeId)
                .setParameter(IN_ORG_TYPE_ID_FIELD, orgTypeId);

        query.execute();
        List<Object[]> queryResultTable = query.getResultList();
        List<UserRestrictListResponse> userRestrictListResponses = new ArrayList<>();

        for (Object[] tableRow : queryResultTable) {
            Map<Integer, Object> fieldNumberOfUserRestrictListMap = new HashMap<>();
            for (int numOfColumn = 0; numOfColumn < NUMBER_OF_RETURN_FIELDS_OF_GET_USER_RESTRICT_LIST_FUNCTION; numOfColumn++) {
                fieldNumberOfUserRestrictListMap.put(numOfColumn + 1, tableRow[numOfColumn]);
            }
            userRestrictListResponses.add(UserRestrictListResponse.build(fieldNumberOfUserRestrictListMap));
        }
        return userRestrictListResponses;
    }

}
