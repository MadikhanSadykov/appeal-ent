package kz.testcenter.app.appealent.dao;

import kz.testcenter.app.appealent.model.functions.request.SubjectListRequest;
import kz.testcenter.app.appealent.model.functions.response.SubjectListResponse;

import java.util.List;

public interface SubjectDAO {

    List<SubjectListResponse> getSubjectList(SubjectListRequest subjectListRequest);

}
