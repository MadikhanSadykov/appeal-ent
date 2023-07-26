package kz.testcenter.app.appealent.service;

import kz.testcenter.app.appealent.model.functions.request.SubjectListRequest;
import kz.testcenter.app.appealent.model.functions.response.SubjectListResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubjectService {

    List<SubjectListResponse> getSubjectList(SubjectListRequest subjectListRequest);

}
