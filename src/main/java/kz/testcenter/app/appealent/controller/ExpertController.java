package kz.testcenter.app.appealent.controller;

import io.swagger.v3.oas.annotations.Operation;
import kz.testcenter.app.appealent.model.functions.request.SetExpertPrevResultRequest;
import kz.testcenter.app.appealent.model.functions.response.ExpertSubjectListResponse;
import kz.testcenter.app.appealent.service.ExpertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/expert")
public class ExpertController {

    private final ExpertService expertService;

    @Operation(summary = "Получить список предметов эксперта по 'user_id' и 'test_type_id'",
            description = "Обязательны все поля")
    @GetMapping("/subjects/by/{userId}/and/{testTypeId}")
    public ResponseEntity<List<ExpertSubjectListResponse>> getExpertSubjectList(
            @PathVariable(name = "userId") Integer userId,
            @PathVariable(name = "testTypeId") Short testTypeId,
            @RequestParam(name = "log", defaultValue = "0") Short log) {
        return new ResponseEntity<>(
                expertService.getExpertSubjectList(userId, testTypeId),
                HttpStatus.OK
        );
    }

    @Operation(summary = "Сохранение предварительного решения",
            description = "fn_set_expert_prev_result")
    @PutMapping("/prev/result")
    public ResponseEntity<Short> setExpertPrevResult(
            @RequestBody SetExpertPrevResultRequest request,
            @RequestParam(name = "log") Short log) {
        return ResponseEntity
                .ok()
                .body(expertService.setExpertPrevResult(request));
    }

}
