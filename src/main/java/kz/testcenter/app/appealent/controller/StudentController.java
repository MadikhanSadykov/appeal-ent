package kz.testcenter.app.appealent.controller;

import io.swagger.v3.oas.annotations.Operation;
import kz.testcenter.app.appealent.model.functions.response.StudentInfoResponse;
import kz.testcenter.app.appealent.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Operation(summary = "Получить информацию о студенте по ИИН",
            description = "fn_get_student_info\n" +
                    "Все поля обязательны")
    @GetMapping("/info/by/{testTypeId}/{iin}")
    public ResponseEntity<List<StudentInfoResponse>> getStudentInfoByIIN(
            @PathVariable(name = "testTypeId") Short testTypeId,
            @PathVariable(name = "iin") String iin,
            @RequestParam(name = "log", defaultValue = "0") Short log) {
        return new ResponseEntity<>(
                studentService.getStudentInfo(testTypeId, iin),
                HttpStatus.OK
        );
    }

}
