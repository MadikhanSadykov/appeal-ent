package kz.testcenter.app.appealent.dao.impl;

import kz.testcenter.app.appealent.dao.DesktopDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_APP_VERSION_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_ORG_TYPE_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_PARAMVALUE_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNameConstant.COMPARE_APP_VERSION_FUNCTION;

@Component
@RequiredArgsConstructor
public class DesktopDAOImpl implements DesktopDAO {

    private final EntityManager entityManager;

    @Override
    @Transactional
    public Short compareAppVersion(Short orgTypeId, String appVersion, String paramValue) {
        StoredProcedureQuery query = entityManager
                .createStoredProcedureQuery(COMPARE_APP_VERSION_FUNCTION)
                .registerStoredProcedureParameter(IN_ORG_TYPE_ID_FIELD, Short.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_APP_VERSION_FIELD, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_PARAMVALUE_FIELD, String.class, ParameterMode.IN)

                .setParameter(IN_ORG_TYPE_ID_FIELD, orgTypeId)
                .setParameter(IN_APP_VERSION_FIELD, appVersion)
                .setParameter(IN_PARAMVALUE_FIELD, paramValue);

        query.execute();
        return (Short) query.getSingleResult();
    }

}
