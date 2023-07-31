package kz.testcenter.app.appealent.service.impl;

import kz.testcenter.app.appealent.dao.ExpertDAO;
import kz.testcenter.app.appealent.model.functions.request.SetExpertPrevResultRequest;
import kz.testcenter.app.appealent.model.functions.response.ExpertSubjectListResponse;
import kz.testcenter.app.appealent.service.ExpertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpertServiceImpl implements ExpertService {

    private final ExpertDAO expertDAO;

    @Override
    public List<ExpertSubjectListResponse> getExpertSubjectList(Integer userId, Short testTypeId) {
        return expertDAO.getExpertSubjectListFun(userId, testTypeId);
    }

    @Override
    public Short setExpertPrevResult(SetExpertPrevResultRequest setExpertPrevResultRequest) {
        return expertDAO.setExpertPrevResult(setExpertPrevResultRequest);
    }

}
