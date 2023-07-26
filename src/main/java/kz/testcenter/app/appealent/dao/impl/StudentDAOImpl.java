package kz.testcenter.app.appealent.dao.impl;

import kz.testcenter.app.appealent.dao.StudentDAO;
import kz.testcenter.app.appealent.model.functions.response.student.StudentInfoResponse;
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

import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_IIN_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionFieldsNameConstant.IN_TEST_TYPE_ID_FIELD;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNameConstant.GET_STUDENT_INFO_FUNCTION;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNumberOfFieldsConstant.NUMBER_OF_RETURN_FIELDS_OF_GET_STUDENT_INFO_FUNCTION;

@Component
@RequiredArgsConstructor
public class StudentDAOImpl implements StudentDAO {

    private final EntityManager entityManager;

    @Override
    @Transactional
    public List<StudentInfoResponse> getStudentInfoFun(Short testTypeId, String iin) {
        StoredProcedureQuery query = entityManager
                .createStoredProcedureQuery(GET_STUDENT_INFO_FUNCTION)
                .registerStoredProcedureParameter(IN_TEST_TYPE_ID_FIELD, Short.class, ParameterMode.IN)
                .registerStoredProcedureParameter(IN_IIN_FIELD, String.class, ParameterMode.IN)

                .setParameter(IN_TEST_TYPE_ID_FIELD, testTypeId)
                .setParameter(IN_IIN_FIELD, iin);

        query.execute();
        List<Object[]> queryResultTable = query.getResultList();
        List<StudentInfoResponse> studentInfoResponses = new ArrayList<>();

        for (Object[] tableRow : queryResultTable) {
            Map<Integer, Object> fieldNumberOfStudentInfoResponseMap = new HashMap<>();
            for (int numOfColumn = 0; numOfColumn < NUMBER_OF_RETURN_FIELDS_OF_GET_STUDENT_INFO_FUNCTION; numOfColumn++) {
                fieldNumberOfStudentInfoResponseMap.put(numOfColumn + 1, tableRow[numOfColumn]);
            }
            studentInfoResponses.add(StudentInfoResponse.build(fieldNumberOfStudentInfoResponseMap));
        }
        return studentInfoResponses;
    }

}
