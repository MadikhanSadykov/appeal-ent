package kz.testcenter.app.appealent.dao.impl;

import kz.testcenter.app.appealent.dao.AppealDAO;
import kz.testcenter.app.appealent.model.functions.request.appeal.AppealByIDRequest;
import kz.testcenter.app.appealent.model.functions.request.appeal.AppealListRequest;
import kz.testcenter.app.appealent.model.functions.request.appeal.AppealResultDescriptionFileRequest;
import kz.testcenter.app.appealent.model.functions.request.appeal.AppealResultDescriptionListByQuestionIDRequest;
import kz.testcenter.app.appealent.model.functions.request.appeal.AppealStatisticByQuestionIDRequest;
import kz.testcenter.app.appealent.model.functions.request.appeal.AppealStatisticByQuestionRequest;
import kz.testcenter.app.appealent.model.functions.request.appeal.AppealUploadFileRequest;
import kz.testcenter.app.appealent.model.functions.response.appeal.AppealByIDResponse;
import kz.testcenter.app.appealent.model.functions.response.appeal.AppealListResponse;
import kz.testcenter.app.appealent.model.functions.response.appeal.AppealResultDescriptionFileByIDResponse;
import kz.testcenter.app.appealent.model.functions.response.appeal.AppealResultDescriptionFileResponse;
import kz.testcenter.app.appealent.model.functions.response.appeal.AppealResultDescriptionListByQuestionIDResponse;
import kz.testcenter.app.appealent.model.functions.response.appeal.AppealStatisticByQuestionIDResponse;
import kz.testcenter.app.appealent.model.functions.response.appeal.AppealStatisticByQuestionResponse;
import kz.testcenter.app.appealent.model.functions.response.appeal.AppealUploadFileResponse;
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

import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_APPEAL_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_APPEAL_STATUS_TYPE_IDS_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_APPEAL_TYPE_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_COMMISSION_MEMBER_TYPE_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_CRYPT_KEY_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_END_DATE_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_EXPERT_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_FILE_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_FINISH_DATE_FILED;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_LANG_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_MID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_ORDER_LIST_FIELDS_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_ORIGINAL_QUESTION_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_START_DATE_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_SUBJECT_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_TEST_SERVER_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_TEST_TYPE_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_USER_ROLE_TYPE_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNameConstant.GET_APPEAL_BY_ID_FUNCTION;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNameConstant.GET_APPEAL_LIST_FUNCTION;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNameConstant.GET_APPEAL_RESULT_DESCRIPTION_FILE_BY_FILE_ID_FUNCTION;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNameConstant.GET_APPEAL_RESULT_DESCRIPTION_FILE_FUNCTION;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNameConstant.GET_APPEAL_RESULT_DESCRIPTION_LIST_BY_QUESTION_ID_FUNCTION;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNameConstant.GET_APPEAL_STATISTIC_BY_QUESTION_FUNCTION;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNameConstant.GET_APPEAL_STATISTIC_BY_QUESTION_ID_FUNCTION;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNameConstant.GET_APPEAL_UPLOAD_FILE_FUNCTION;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNameConstant.GET_HTML_APPEAL_RESULT_DESCRIPTION_FUNCTION;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNumberOfFieldsConstant.NUMBER_OF_RETURN_FIELDS_OF_GET_APPEAL_BY_ID_FUNCTION;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNumberOfFieldsConstant.NUMBER_OF_RETURN_FIELDS_OF_GET_APPEAL_LIST_FUNCTION;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNumberOfFieldsConstant.NUMBER_OF_RETURN_FIELDS_OF_GET_APPEAL_RESULT_DESCRIPTION_FILE_BY_FILE_ID_FUNCTION;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNumberOfFieldsConstant.NUMBER_OF_RETURN_FIELDS_OF_GET_APPEAL_RESULT_DESCRIPTION_FILE_FUNCTION;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNumberOfFieldsConstant.NUMBER_OF_RETURN_FIELDS_OF_GET_APPEAL_RESULT_DESCRIPTION_LIST_BY_QUESTION_ID_FUNCTION;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNumberOfFieldsConstant.NUMBER_OF_RETURN_FIELDS_OF_GET_APPEAL_STATISTIC_BY_QUESTION_FUNCTION;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNumberOfFieldsConstant.NUMBER_OF_RETURN_FIELDS_OF_GET_APPEAL_STATISTIC_BY_QUESTION_ID_FUNCTION;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNumberOfFieldsConstant.NUMBER_OF_RETURN_FIELDS_OF_GET_APPEAL_UPLOAD_FILE_FUNCTION;

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
                .registerStoredProcedureParameter(IN_START_DATE_FIELD, Date.class, ParameterMode.IN)
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
                .setParameter(IN_START_DATE_FIELD, appealListRequest.getStartDate())
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
            appealListResponses
                    .add(AppealListResponse
                            .build(fieldNumberOfAppealListResponseMap));
        }
        return appealListResponses;
    }

    @Override
    @Transactional
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
            appealByIDResponses
                    .add(AppealByIDResponse
                            .build(fieldNumberOfAppealByIdResponseMap));
        }
        return appealByIDResponses;
    }

    @Override
    @Transactional
    public List<AppealResultDescriptionFileResponse> getAppealResultDescriptionFileFun(AppealResultDescriptionFileRequest request) {
        StoredProcedureQuery query = entityManager
                .createStoredProcedureQuery(GET_APPEAL_RESULT_DESCRIPTION_FILE_FUNCTION)
                .registerStoredProcedureParameter(IN_APPEAL_ID_FIELD, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_APPEAL_TYPE_ID_FIELD, Short.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_TEST_SERVER_ID_FIELD, Short.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_EXPERT_ID_FIELD, Integer.class, ParameterMode.IN)

                .setParameter(IN_APPEAL_ID_FIELD, request.getAppealId())
                .setParameter(IN_APPEAL_TYPE_ID_FIELD, request.getAppealTypeId())
                .setParameter(IN_TEST_SERVER_ID_FIELD, request.getTestServerId())
                .setParameter(IN_EXPERT_ID_FIELD, request.getExpertId());

        query.execute();
        List<Object[]> queryResultTable = query.getResultList();

        List<AppealResultDescriptionFileResponse> resultDescriptionFileResponses = new ArrayList<>();
        for (Object[] tableRow : queryResultTable) {
            Map<Integer, Object> fieldNumberOfAppealResultDescriptionFileMap = new HashMap<>();
            for (int numOfColumn = 0;
                 numOfColumn < NUMBER_OF_RETURN_FIELDS_OF_GET_APPEAL_RESULT_DESCRIPTION_FILE_FUNCTION; numOfColumn++) {
                fieldNumberOfAppealResultDescriptionFileMap.put(numOfColumn, tableRow[numOfColumn]);
            }
            resultDescriptionFileResponses.add(
                    AppealResultDescriptionFileResponse
                            .build(fieldNumberOfAppealResultDescriptionFileMap));
        }
        return resultDescriptionFileResponses;
    }

    @Override
    @Transactional
    public AppealResultDescriptionFileByIDResponse getAppealResultDescriptionFileByIdFun(Integer id) {

        StoredProcedureQuery query = entityManager
                .createStoredProcedureQuery(GET_APPEAL_RESULT_DESCRIPTION_FILE_BY_FILE_ID_FUNCTION)
                .registerStoredProcedureParameter(IN_FILE_ID_FIELD, Integer.class, ParameterMode.IN)

                .setParameter(IN_FILE_ID_FIELD, id);

        query.execute();
        List<Object[]> queryResulTable = query.getResultList();

        Map<Integer, Object> fieldNumberOfAppealResultDescriptionFileByIDMap = new HashMap<>();
        for (int numOfColumn = 0;
             numOfColumn < NUMBER_OF_RETURN_FIELDS_OF_GET_APPEAL_RESULT_DESCRIPTION_FILE_BY_FILE_ID_FUNCTION;
             numOfColumn++) {
            fieldNumberOfAppealResultDescriptionFileByIDMap.put(numOfColumn, queryResulTable.get(0)[numOfColumn]);
        }
        return AppealResultDescriptionFileByIDResponse
                .build(fieldNumberOfAppealResultDescriptionFileByIDMap);
    }

    @Override
    @Transactional
    public List<AppealResultDescriptionListByQuestionIDResponse> getAppealResultDescriptionListByQuestionIdFun(
            AppealResultDescriptionListByQuestionIDRequest request) {
        StoredProcedureQuery query = entityManager
                .createStoredProcedureQuery(GET_APPEAL_RESULT_DESCRIPTION_LIST_BY_QUESTION_ID_FUNCTION)
                .registerStoredProcedureParameter(IN_APPEAL_TYPE_ID_FIELD, Short.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_TEST_SERVER_ID_FIELD, Short.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_EXPERT_ID_FIELD, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_ORIGINAL_QUESTION_ID_FIELD, Long.class, ParameterMode.IN)

                .setParameter(IN_APPEAL_TYPE_ID_FIELD, request.getAppealTypeId())
                .setParameter(IN_TEST_SERVER_ID_FIELD, request.getTestServerId())
                .setParameter(IN_EXPERT_ID_FIELD, request.getExpertId())
                .setParameter(IN_ORIGINAL_QUESTION_ID_FIELD, request.getOriginalQuestionId());

        query.execute();
        List<Object[]> queryResultTable = query.getResultList();
        List<AppealResultDescriptionListByQuestionIDResponse> appealResultDescriptionListByQuestionIDResponses =
                new ArrayList<>();

        for (Object[] tableRow : queryResultTable) {
            Map<Integer, Object> fieldNumberOfAppealResultDescriptionListByQuestionIDResponseMap = new HashMap<>();
            for (int numOfColumn = 0;
                 numOfColumn < NUMBER_OF_RETURN_FIELDS_OF_GET_APPEAL_RESULT_DESCRIPTION_LIST_BY_QUESTION_ID_FUNCTION;
                 numOfColumn++) {
                fieldNumberOfAppealResultDescriptionListByQuestionIDResponseMap.put(numOfColumn, tableRow[numOfColumn]);
            }
            appealResultDescriptionListByQuestionIDResponses
                    .add(AppealResultDescriptionListByQuestionIDResponse
                            .build(fieldNumberOfAppealResultDescriptionListByQuestionIDResponseMap));
        }
        return appealResultDescriptionListByQuestionIDResponses;
    }

    @Override
    @Transactional
    public List<AppealStatisticByQuestionResponse> getAppealStatisticByQuestionFun(
            AppealStatisticByQuestionRequest appealStatisticByQuestionRequest) {

        StoredProcedureQuery query = entityManager
                .createStoredProcedureQuery(GET_APPEAL_STATISTIC_BY_QUESTION_FUNCTION)
                .registerStoredProcedureParameter(IN_TEST_TYPE_ID_FIELD, Short.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_START_DATE_FIELD, Date.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_FINISH_DATE_FILED, Date.class, ParameterMode.IN)

                .setParameter(IN_TEST_TYPE_ID_FIELD, appealStatisticByQuestionRequest.getTestTypeId())
                .setParameter(IN_START_DATE_FIELD, appealStatisticByQuestionRequest.getStartDate())
                .setParameter(IN_FINISH_DATE_FILED, appealStatisticByQuestionRequest.getFinishDate());

        query.execute();
        List<Object[]> queryResultTable = query.getResultList();
        List<AppealStatisticByQuestionResponse> appealStatisticByQuestionResponses = new ArrayList<>();

        for (Object[] tableRow : queryResultTable) {
            Map<Integer, Object> fieldNumberOfAppealStatisticByQuestionResponseMap = new HashMap<>();
            for (int numOfColumn = 0;
                 numOfColumn < NUMBER_OF_RETURN_FIELDS_OF_GET_APPEAL_STATISTIC_BY_QUESTION_FUNCTION;
                 numOfColumn++) {
                fieldNumberOfAppealStatisticByQuestionResponseMap.put(numOfColumn + 1, tableRow[numOfColumn]);
            }
            appealStatisticByQuestionResponses
                    .add(AppealStatisticByQuestionResponse
                            .build(fieldNumberOfAppealStatisticByQuestionResponseMap));
        }
        return appealStatisticByQuestionResponses;
    }

    @Override
    @Transactional
    public List<AppealStatisticByQuestionIDResponse> getAppealStatisticByQuestionIdFun(
            AppealStatisticByQuestionIDRequest request) {

        StoredProcedureQuery query = entityManager
                .createStoredProcedureQuery(GET_APPEAL_STATISTIC_BY_QUESTION_ID_FUNCTION)
                .registerStoredProcedureParameter(IN_TEST_TYPE_ID_FIELD, Short.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_START_DATE_FIELD, Date.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_FINISH_DATE_FILED, Date.class, ParameterMode.IN)

                .setParameter(IN_TEST_TYPE_ID_FIELD, request.getTestTypeId())
                .setParameter(IN_START_DATE_FIELD, request.getStartDate())
                .setParameter(IN_FINISH_DATE_FILED, request.getFinishDate());

        query.execute();
        List<Object[]> queryResultTable = query.getResultList();
        List<AppealStatisticByQuestionIDResponse> appealStatisticByQuestionIDResponses = new ArrayList<>();

        for (Object[] tableRow : queryResultTable) {
            Map<Integer, Object> fieldNumberOfAppealStatisticByQuestionIDResponseMap = new HashMap<>();
            for (int numOfColumn = 0;
                 numOfColumn < NUMBER_OF_RETURN_FIELDS_OF_GET_APPEAL_STATISTIC_BY_QUESTION_ID_FUNCTION;
                 numOfColumn++) {
                fieldNumberOfAppealStatisticByQuestionIDResponseMap.put(numOfColumn + 1, tableRow[numOfColumn]);
            }
            appealStatisticByQuestionIDResponses
                    .add(AppealStatisticByQuestionIDResponse
                            .build(fieldNumberOfAppealStatisticByQuestionIDResponseMap));
        }
        return appealStatisticByQuestionIDResponses;
    }

    @Override
    @Transactional
    public List<AppealUploadFileResponse> getAppealUploadFileResponseFun(
            AppealUploadFileRequest appealUploadFileRequest) {

        StoredProcedureQuery query = entityManager
                .createStoredProcedureQuery(GET_APPEAL_UPLOAD_FILE_FUNCTION)
                .registerStoredProcedureParameter(IN_APPEAL_ID_FIELD, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_APPEAL_TYPE_ID_FIELD, Short.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_TEST_SERVER_ID_FIELD, Short.class, ParameterMode.IN)

                .setParameter(IN_APPEAL_ID_FIELD, appealUploadFileRequest.getAppealId())
                .setParameter(IN_APPEAL_TYPE_ID_FIELD, appealUploadFileRequest.getAppealTypeId())
                .setParameter(IN_TEST_SERVER_ID_FIELD, appealUploadFileRequest.getTestServerId());

        query.execute();
        List<Object[]> queryResultTable = query.getResultList();
        List<AppealUploadFileResponse> appealStatisticByQuestionIDResponses = new ArrayList<>();

        for (Object[] tableRow : queryResultTable) {
            Map<Integer, Object> fieldNumberOfAppealUploadFileResponseMap = new HashMap<>();
            for (int numOfColumn = 0;
                 numOfColumn < NUMBER_OF_RETURN_FIELDS_OF_GET_APPEAL_UPLOAD_FILE_FUNCTION;
                 numOfColumn++) {
                fieldNumberOfAppealUploadFileResponseMap.put(numOfColumn + 1, tableRow[numOfColumn]);
            }
            appealStatisticByQuestionIDResponses
                    .add(AppealUploadFileResponse
                            .build(fieldNumberOfAppealUploadFileResponseMap));
        }
        return appealStatisticByQuestionIDResponses;
    }

    @Override
    @Transactional
    public String getHtmlAppealResultDescription(Integer appealId, Short appealTypeId, Short testServerId) {
        StoredProcedureQuery query = entityManager
                .createStoredProcedureQuery(GET_HTML_APPEAL_RESULT_DESCRIPTION_FUNCTION)
                .registerStoredProcedureParameter(IN_APPEAL_ID_FIELD, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_APPEAL_TYPE_ID_FIELD, Short.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_TEST_SERVER_ID_FIELD, Short.class, ParameterMode.IN)

                .setParameter(IN_APPEAL_ID_FIELD, appealId)
                .setParameter(IN_APPEAL_TYPE_ID_FIELD, appealTypeId)
                .setParameter(IN_TEST_SERVER_ID_FIELD, testServerId);

        query.execute();
        return  (String) query.getSingleResult();
    }

}
