package kz.testcenter.app.appealent.dao.impl;

import kz.testcenter.app.appealent.dao.LogDAO;
import kz.testcenter.app.appealent.model.functions.request.WriteLogRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_ACTION_TYPE_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_DESCR_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_IP_ADDRESS_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_OBJECT_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_ORG_TYPE_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_USER_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNameConstant.WRITE_LOG_FUNCTION;

@Component
@RequiredArgsConstructor
public class LogDAOImpl implements LogDAO {

    private final EntityManager entityManager;

    @Override
    @Transactional
    public void writeLog(WriteLogRequest writeLogRequest) {
        StoredProcedureQuery query = entityManager
                .createStoredProcedureQuery(WRITE_LOG_FUNCTION)
                .registerStoredProcedureParameter(IN_ORG_TYPE_ID_FIELD, Short.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_USER_ID_FIELD, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_ACTION_TYPE_ID_FIELD, Short.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_DESCR_FIELD, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_OBJECT_ID_FIELD, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_IP_ADDRESS_FIELD, String.class, ParameterMode.IN)

                .setParameter(IN_ORG_TYPE_ID_FIELD, writeLogRequest.getOrgTypeId())
                .setParameter(IN_USER_ID_FIELD, writeLogRequest.getUserId())
                .setParameter(IN_ACTION_TYPE_ID_FIELD, writeLogRequest.getActionTypeId())
                .setParameter(IN_DESCR_FIELD, writeLogRequest.getDescr())
                .setParameter(IN_OBJECT_ID_FIELD, writeLogRequest.getObjectId())
                .setParameter(IN_IP_ADDRESS_FIELD, writeLogRequest.getIpAddress());

        query.executeUpdate();
    }
}
