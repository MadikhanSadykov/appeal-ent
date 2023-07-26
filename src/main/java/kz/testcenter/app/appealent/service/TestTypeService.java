package kz.testcenter.app.appealent.service;

import kz.testcenter.app.appealent.model.functions.response.TestTypeListForAppealResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TestTypeService {

    List<TestTypeListForAppealResponse> getTestTypeListForAppeal();

}
