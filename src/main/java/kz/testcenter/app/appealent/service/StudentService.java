package kz.testcenter.app.appealent.service;

import kz.testcenter.app.appealent.model.functions.response.StudentInfoResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    List<StudentInfoResponse> getStudentInfo(Short testTypeId, String iin);

}
