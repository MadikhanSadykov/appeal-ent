package kz.testcenter.app.appealent.service;

import kz.testcenter.app.appealent.model.functions.request.SetExpertPrevResultRequest;
import kz.testcenter.app.appealent.model.functions.response.ExpertSubjectListResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExpertService {

    List<ExpertSubjectListResponse> getExpertSubjectList(Integer userId, Short testTypeId);

    Short setExpertPrevResult(SetExpertPrevResultRequest setExpertPrevResultRequest);

}
