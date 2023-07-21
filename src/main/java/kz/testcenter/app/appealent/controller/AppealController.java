package kz.testcenter.app.appealent.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import kz.testcenter.app.appealent.model.functions.request.AppealByIDRequest;
import kz.testcenter.app.appealent.model.functions.request.AppealListRequest;
import kz.testcenter.app.appealent.model.functions.response.AppealByIDResponse;
import kz.testcenter.app.appealent.model.functions.response.AppealListResponse;
import kz.testcenter.app.appealent.service.AppealService;
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
@RequestMapping("/api/v1/appeal")
public class AppealController {

    private final AppealService appealService;

    @Operation(summary = "Получить список Аппеляций", description = "Обязательные поля: 'test_type_id', " +
                    "'start_date', 'end_date'.\n" +
                    "! Если остальные поля не назначены, то передать в них - null !\n" +
                    "Возвращает лист аппеляций\n")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Удачно получено"),
            @ApiResponse(responseCode = "404", description = "Не найдено"),
            @ApiResponse(responseCode = "500", description = "Не валидные введеные данные / не верный формат данных")
    })
    @GetMapping("/list")
    public ResponseEntity<List<AppealListResponse>> getAppealList(@RequestBody AppealListRequest appealListRequest) {
        return new ResponseEntity<>(appealService.getAppealList(appealListRequest), HttpStatus.OK);
    }

    @Operation(summary = "Получить вопрос аппеляции по id", description = "Обязательные поля: 'appeal_id', " +
                    "'appeal_type_id', 'end_date'.\n" +
                    "! Если остальные поля не назначены, то передать в них - null !\n" +
                    "Возвращает таблицу вопросов аппеляции\n")
    @GetMapping("/by/id")
    public ResponseEntity<List<AppealByIDResponse>> getAppealById(@RequestBody AppealByIDRequest appealByIDRequest) {
        return new ResponseEntity<>(appealService.getAppealById(appealByIDRequest),  HttpStatus.OK);
    }

}
