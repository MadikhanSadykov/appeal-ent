package kz.testcenter.app.appealent.service.impl;

import kz.testcenter.app.appealent.dao.TestTypeDAO;
import kz.testcenter.app.appealent.model.functions.response.TestTypeListForAppealResponse;
import kz.testcenter.app.appealent.service.TestTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestTypeServiceImpl implements TestTypeService {

    private final TestTypeDAO testTypeDAO;

    @Override
    public List<TestTypeListForAppealResponse> getTestTypeListForAppeal() {
        return testTypeDAO.getTestTypeListForAppeal();
    }

}
