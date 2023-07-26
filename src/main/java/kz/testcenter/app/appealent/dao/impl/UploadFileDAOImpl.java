package kz.testcenter.app.appealent.dao.impl;

import kz.testcenter.app.appealent.dao.UploadFileDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_FILE_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_TEST_SERVER_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNameConstant.GET_UPLOAD_FILE_DATA_BY_ID_FUNCTION;

@Component
@RequiredArgsConstructor
public class UploadFileDAOImpl implements UploadFileDAO {

    private final EntityManager entityManager;

    @Override
    @Transactional
    public byte[] getUploadFileDataById(Integer fileId, Short testServerId) {
        StoredProcedureQuery query = entityManager
                .createStoredProcedureQuery(GET_UPLOAD_FILE_DATA_BY_ID_FUNCTION)
                .registerStoredProcedureParameter(IN_FILE_ID_FIELD, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_TEST_SERVER_ID_FIELD, Short.class, ParameterMode.IN)

                .setParameter(IN_FILE_ID_FIELD, fileId)
                .setParameter(IN_TEST_SERVER_ID_FIELD, testServerId);

        query.execute();
        return (byte[]) query.getSingleResult();
    }

}
