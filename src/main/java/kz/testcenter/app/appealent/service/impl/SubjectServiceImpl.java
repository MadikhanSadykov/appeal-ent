package kz.testcenter.app.appealent.service.impl;

import kz.testcenter.app.appealent.dao.SubjectDAO;
import kz.testcenter.app.appealent.model.functions.request.SubjectListRequest;
import kz.testcenter.app.appealent.model.functions.response.SubjectListResponse;
import kz.testcenter.app.appealent.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectDAO subjectDAO;

    @Override
    public List<SubjectListResponse> getSubjectList(SubjectListRequest subjectListRequest) {
        return subjectDAO.getSubjectList(subjectListRequest);
    }
}
