package kz.testcenter.app.appealent.dao.impl;

import kz.testcenter.app.appealent.dao.AppealDAO;
import kz.testcenter.app.appealent.model.functions.request.AppealByIDRequest;
import kz.testcenter.app.appealent.model.functions.request.AppealListRequest;
import kz.testcenter.app.appealent.model.functions.response.AppealByIDResponse;
import kz.testcenter.app.appealent.model.functions.response.AppealListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.*;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNameConstant.GET_APPEAL_BY_ID_FUNCTION;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNameConstant.GET_APPEAL_LIST_FUNCTION;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNumberOfFieldsConstant.NUMBER_OF_RETURN_FIELDS_OF_GET_APPEAL_BY_ID_FUNCTION;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNumberOfFieldsConstant.NUMBER_OF_RETURN_FIELDS_OF_GET_APPEAL_LIST_FUNCTION;

@Component
@RequiredArgsConstructor
public class AppealDAOImpl implements AppealDAO {

    private final EntityManager entityManager;

    @Override
    @Transactional
    public List<AppealListResponse> getAppealListFun(AppealListRequest appealListRequest) {

        StoredProcedureQuery query = entityManager
                .createStoredProcedureQuery(GET_APPEAL_LIST_FUNCTION)
                .registerStoredProcedureParameter(IN_TEST_TYPE_ID_FIELD, Short.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_START_DATE_FILED, Date.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_END_DATE_FIELD, Date.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_EXPERT_ID_FIELD, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_SUBJECT_ID_FIELD, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_LANG_ID_FIELD, Short.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_APPEAL_TYPE_ID_FIELD, Short.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_APPEAL_STATUS_TYPE_IDS_FIELD, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_ORDER_LIST_FIELDS_FIELD, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_USER_ROLE_TYPE_ID_FIELD, Short.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_COMMISSION_MEMBER_TYPE_ID_FIELD, Short.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_MID_FIELD, Integer.class, ParameterMode.IN)

                .setParameter(IN_TEST_TYPE_ID_FIELD, appealListRequest.getTestTypeId())
                .setParameter(IN_START_DATE_FILED, appealListRequest.getStartDate())
                .setParameter(IN_END_DATE_FIELD, appealListRequest.getEndDate())
                .setParameter(IN_EXPERT_ID_FIELD, appealListRequest.getExpertId())
                .setParameter(IN_SUBJECT_ID_FIELD, appealListRequest.getSubjectId())
                .setParameter(IN_LANG_ID_FIELD, appealListRequest.getLangId())
                .setParameter(IN_APPEAL_TYPE_ID_FIELD, appealListRequest.getAppealTypeId())
                .setParameter(IN_APPEAL_STATUS_TYPE_IDS_FIELD, appealListRequest.getAppealStatusTypeIds())
                .setParameter(IN_ORDER_LIST_FIELDS_FIELD, appealListRequest.getOrderListFields())
                .setParameter(IN_USER_ROLE_TYPE_ID_FIELD, appealListRequest.getUserRoleTypeId())
                .setParameter(IN_COMMISSION_MEMBER_TYPE_ID_FIELD, appealListRequest.getCommissionMemberTypeId())
                .setParameter(IN_MID_FIELD, appealListRequest.getMid());

        query.execute();
        List<Object[]> queryResultTable = query.getResultList();

        List<AppealListResponse> appealListResponses = new ArrayList<>();
        for (Object[] tableRow : queryResultTable) {
            Map<Integer, Object> fieldNumberOfAppealListResponseMap = new HashMap<>();

            for (int numOfColumn = 0; numOfColumn < NUMBER_OF_RETURN_FIELDS_OF_GET_APPEAL_LIST_FUNCTION; numOfColumn++) {
                fieldNumberOfAppealListResponseMap.put(numOfColumn, tableRow[numOfColumn]);
            }
            appealListResponses.add(AppealListResponse.build(fieldNumberOfAppealListResponseMap));
        }
        return appealListResponses;
    }

    @Override
    public List<AppealByIDResponse> getAppealByIdFun(AppealByIDRequest appealByIDRequest) {
        StoredProcedureQuery query = entityManager
                .createStoredProcedureQuery(GET_APPEAL_BY_ID_FUNCTION)
                .registerStoredProcedureParameter(IN_APPEAL_ID_FIELD, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_APPEAL_TYPE_ID_FIELD, Short.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_TEST_SERVER_ID_FIELD, Short.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_CRYPT_KEY_FIELD, String.class, ParameterMode.IN)

                .setParameter(IN_APPEAL_ID_FIELD, appealByIDRequest.getAppealId())
                .setParameter(IN_APPEAL_TYPE_ID_FIELD, appealByIDRequest.getAppealTypeId())
                .setParameter(IN_TEST_SERVER_ID_FIELD, appealByIDRequest.getTestServerId())
                .setParameter(IN_CRYPT_KEY_FIELD, appealByIDRequest.getCryptKey());

        query.execute();
        List<Object[]> queryResultTable = query.getResultList();

        List<AppealByIDResponse> appealByIDResponses = new ArrayList<>();
        for (Object[] tableRow : queryResultTable) {
            Map<Integer, Object> fieldNumberOfAppealByIdResponseMap = new HashMap<>();

            for (int numOfColumn = 0; numOfColumn < NUMBER_OF_RETURN_FIELDS_OF_GET_APPEAL_BY_ID_FUNCTION; numOfColumn++) {
                fieldNumberOfAppealByIdResponseMap.put(numOfColumn, tableRow[numOfColumn]);
            }
            appealByIDResponses.add(AppealByIDResponse.build(fieldNumberOfAppealByIdResponseMap));
        }
        return appealByIDResponses;
    }
}
