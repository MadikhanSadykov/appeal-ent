package kz.testcenter.app.appealent.dao;

import kz.testcenter.app.appealent.model.functions.request.SetExpertPrevResultRequest;
import kz.testcenter.app.appealent.model.functions.response.ExpertSubjectListResponse;

import java.util.List;

public interface ExpertDAO {

    List<ExpertSubjectListResponse> getExpertSubjectListFun(Integer userId, Short testTypeId);

    Short setExpertPrevResult(SetExpertPrevResultRequest setExpertPrevResultRequest);

}
