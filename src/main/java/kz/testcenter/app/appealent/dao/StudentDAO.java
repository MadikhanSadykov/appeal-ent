package kz.testcenter.app.appealent.dao;

import kz.testcenter.app.appealent.model.functions.response.student.StudentInfoResponse;

import java.util.List;

public interface StudentDAO {

    List<StudentInfoResponse> getStudentInfoFun(Short testTypeId, String iin);

}
