package kz.testcenter.app.appealent.dao.impl;

import kz.testcenter.app.appealent.dao.CommissionDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_TEST_TYPE_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_USER_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNameConstant.GET_COMMISSION_MEMBER_TYPE_ID_BY_USER_ID_FUNCTION;

@Component
@RequiredArgsConstructor
public class CommissionDAOImpl implements CommissionDAO {

    private final EntityManager entityManager;

    @Override
    @Transactional
    public Short getCommissionMemberTypeIdByUserId(Integer userId, Short testTypeId) {
        StoredProcedureQuery query = entityManager
                .createStoredProcedureQuery(GET_COMMISSION_MEMBER_TYPE_ID_BY_USER_ID_FUNCTION)
                .registerStoredProcedureParameter(IN_USER_ID_FIELD, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_TEST_TYPE_ID_FIELD, Short.class, ParameterMode.IN)

                .setParameter(IN_USER_ID_FIELD, userId)
                .setParameter(IN_TEST_TYPE_ID_FIELD, testTypeId);

        query.execute();
        Short queryResult = (Short) query.getSingleResult();

        return queryResult;
    }
}
