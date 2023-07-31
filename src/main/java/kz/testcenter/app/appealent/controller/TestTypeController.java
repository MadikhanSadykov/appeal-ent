package kz.testcenter.app.appealent.controller;

import io.swagger.v3.oas.annotations.Operation;
import kz.testcenter.app.appealent.model.functions.response.TestTypeListForAppealResponse;
import kz.testcenter.app.appealent.service.TestTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/testType")
public class TestTypeController {

    private final TestTypeService testTypeService;

    @Operation(summary = "Получить список типов тестов для аппеляции", description = "fn_get_test_type_list_for_appeal")
    @GetMapping("/list/for/appeal")
    public ResponseEntity<List<TestTypeListForAppealResponse>> getTestTypeListForAppeal(
            @RequestParam(name = "log", defaultValue = "0") Short log) {
        return new ResponseEntity<>(
                testTypeService.getTestTypeListForAppeal(),
                HttpStatus.OK
        );
    }

}
