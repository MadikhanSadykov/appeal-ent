package kz.testcenter.app.appealent.dao.impl;

import kz.testcenter.app.appealent.dao.TestTypeDAO;
import kz.testcenter.app.appealent.model.functions.response.TestTypeListForAppealResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static kz.testcenter.app.appealent.utils.constants.DBFunctionNameConstant.GET_TEST_TYPE_LIST_FOR_APPEAL_FUNCTION;
import static kz.testcenter.app.appealent.utils.constants.DBFunctionNumberOfFieldsConstant.NUMBER_OF_RETURN_FIELDS_OF_GET_TEST_TYPE_LIST_FOR_APPEAL_FUNCTION;

@Component
@RequiredArgsConstructor
public class TestTypeDAOImpl implements TestTypeDAO {

    private final EntityManager entityManager;

    @Override
    @Transactional
    public List<TestTypeListForAppealResponse> getTestTypeListForAppeal() {
        StoredProcedureQuery query = entityManager
                .createStoredProcedureQuery(GET_TEST_TYPE_LIST_FOR_APPEAL_FUNCTION);
        query.execute();
        List<Object[]> queryResultTable = query.getResultList();
        List<TestTypeListForAppealResponse> testTypeListForAppealResponses = new ArrayList<>();

        for (Object[] tableRow : queryResultTable) {
            Map<Integer, Object> fieldNumberOfTestTypeListForAppealResponseMap = new HashMap<>();
            for (int numOfColumn = 0;
                 numOfColumn < NUMBER_OF_RETURN_FIELDS_OF_GET_TEST_TYPE_LIST_FOR_APPEAL_FUNCTION; numOfColumn++) {
                fieldNumberOfTestTypeListForAppealResponseMap.put(numOfColumn + 1, tableRow[numOfColumn]);
            }
            testTypeListForAppealResponses
                    .add(TestTypeListForAppealResponse
                            .build(fieldNumberOfTestTypeListForAppealResponseMap));
        }
        return testTypeListForAppealResponses;
    }

}
