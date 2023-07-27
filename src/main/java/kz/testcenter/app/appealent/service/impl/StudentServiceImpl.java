package kz.testcenter.app.appealent.service.impl;

import kz.testcenter.app.appealent.dao.StudentDAO;
import kz.testcenter.app.appealent.model.functions.response.StudentInfoResponse;
import kz.testcenter.app.appealent.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO;

    @Override
    public List<StudentInfoResponse> getStudentInfo(Short testTypeId, String iin) {
        return studentDAO.getStudentInfoFun(testTypeId, iin);
    }

}
