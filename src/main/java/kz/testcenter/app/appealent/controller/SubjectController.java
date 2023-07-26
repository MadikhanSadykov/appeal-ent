package kz.testcenter.app.appealent.controller;

import io.swagger.v3.oas.annotations.Operation;
import kz.testcenter.app.appealent.model.functions.request.SubjectListRequest;
import kz.testcenter.app.appealent.model.functions.response.SubjectListResponse;
import kz.testcenter.app.appealent.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/subject")
public class SubjectController {

    private final SubjectService subjectService;

    @Operation(summary = "Получить список предметов", description = "fn_get_subject_list")
    @GetMapping("/list")
    public ResponseEntity<List<SubjectListResponse>> getSubjectList(@RequestBody SubjectListRequest subjectListRequest) {
        return new ResponseEntity<>(
                subjectService.getSubjectList(subjectListRequest),
                HttpStatus.OK
        );
    }

}
