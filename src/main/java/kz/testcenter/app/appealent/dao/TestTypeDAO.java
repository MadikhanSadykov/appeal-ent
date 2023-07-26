package kz.testcenter.app.appealent.dao;

import kz.testcenter.app.appealent.model.functions.response.TestTypeListForAppealResponse;

import java.util.List;

public interface TestTypeDAO {

    List<TestTypeListForAppealResponse> getTestTypeListForAppeal();

}
