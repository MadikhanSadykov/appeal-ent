package kz.testcenter.app.appealent.dao.impl;

import kz.testcenter.app.appealent.dao.UserDAO;
import kz.testcenter.app.appealent.model.functions.request.AuthUserRequest;
import kz.testcenter.app.appealent.model.functions.request.UserChangePasswordRequest;
import kz.testcenter.app.appealent.model.functions.response.AuthUserResponse;
import kz.testcenter.app.appealent.model.functions.response.UserRestrictListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_LOGIN_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_ORG_TYPE_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_PASSWORD_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_TEST_TYPE_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_USER_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_USER_STATUS_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNameConstant.AUTH_USER_FUNCTION;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNameConstant.GET_USER_RESTRICT_LIST_FUNCTION;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNameConstant.USER_CHANGE_PASSWORD_FUNCTION;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNumberOfFieldsConstant.NUMBER_OF_RETURN_FIELDS_OF_AUTH_USER_FUNCTION;
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

    @Override
    @Transactional
    public AuthUserResponse authUser(AuthUserRequest authUserRequest) {
        // todo: remove - delegate encoding to frontend
        String passwordBase64 = Base64.getEncoder().encodeToString(authUserRequest.getPassword().getBytes());

        StoredProcedureQuery query = entityManager
                .createStoredProcedureQuery(AUTH_USER_FUNCTION)
                .registerStoredProcedureParameter(IN_LOGIN_FIELD, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_PASSWORD_FIELD, String.class, ParameterMode.IN)

                .setParameter(IN_LOGIN_FIELD, authUserRequest.getLogin())
                .setParameter(IN_PASSWORD_FIELD, passwordBase64);

        query.execute();
        List<Object[]> queryResultTable = query.getResultList();
        Object[] tableRow = queryResultTable.get(0);

        Map<Integer, Object> fieldNumberOfAuthUserResponseMap = new HashMap<>();
        for (int numOfColumn = 0; numOfColumn < NUMBER_OF_RETURN_FIELDS_OF_AUTH_USER_FUNCTION; numOfColumn++) {
            fieldNumberOfAuthUserResponseMap.put(numOfColumn + 1, tableRow[numOfColumn]);
        }

        return AuthUserResponse.build(fieldNumberOfAuthUserResponseMap);
    }

    @Override
    @Transactional
    public String getRoleNameByUserId(Integer userId) {
        Query query = entityManager.createNativeQuery("select r.code from ref.user_role_type as r\n" +
                "where id in (\n" +
                "    select res.user_role_type_id from public.user_restrict as res\n" +
                "    where res.user_id = :userId);");
        query.setParameter("userId", userId);
        return (String) query.getSingleResult();
    }

    @Override
    @Transactional
    public Short userChangePassword(UserChangePasswordRequest userChangePasswordRequest) {
        StoredProcedureQuery query = entityManager
                .createStoredProcedureQuery(USER_CHANGE_PASSWORD_FUNCTION)
                .registerStoredProcedureParameter(IN_ID_FIELD, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_USER_STATUS_ID_FIELD, Short.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_PASSWORD_FIELD,String.class, ParameterMode.IN)

                .setParameter(IN_ID_FIELD, userChangePasswordRequest.getId())
                .setParameter(IN_USER_STATUS_ID_FIELD, userChangePasswordRequest.getUserStatusId())
                .setParameter(IN_PASSWORD_FIELD, userChangePasswordRequest.getPassword());

        query.executeUpdate();
        return (Short) query.getSingleResult();
    }

}
