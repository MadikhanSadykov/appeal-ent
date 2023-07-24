package kz.testcenter.app.appealent.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import kz.testcenter.app.appealent.model.functions.request.AppealByIDRequest;
import kz.testcenter.app.appealent.model.functions.request.AppealListRequest;
import kz.testcenter.app.appealent.model.functions.request.AppealResultDescriptionFileRequest;
import kz.testcenter.app.appealent.model.functions.request.AppealResultDescriptionListByQuestionIDRequest;
import kz.testcenter.app.appealent.model.functions.request.AppealStatisticByQuestionIDRequest;
import kz.testcenter.app.appealent.model.functions.request.AppealStatisticByQuestionRequest;
import kz.testcenter.app.appealent.model.functions.response.AppealByIDResponse;
import kz.testcenter.app.appealent.model.functions.response.AppealListResponse;
import kz.testcenter.app.appealent.model.functions.response.AppealResultDescriptionFileByIDResponse;
import kz.testcenter.app.appealent.model.functions.response.AppealResultDescriptionFileResponse;
import kz.testcenter.app.appealent.model.functions.response.AppealResultDescriptionListByQuestionIDResponse;
import kz.testcenter.app.appealent.model.functions.response.AppealStatisticByQuestionIDResponse;
import kz.testcenter.app.appealent.model.functions.response.AppealStatisticByQuestionResponse;
import kz.testcenter.app.appealent.service.AppealService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        return new ResponseEntity<>(
                appealService.getAppealList(appealListRequest),
                HttpStatus.OK);
    }

    @Operation(summary = "Получить вопрос аппеляции по id", description = "Обязательные поля: 'appeal_id', " +
                    "'appeal_type_id', 'end_date'.\n" +
                    "! Если остальные поля не назначены, то передать в них - null !\n" +
                    "Возвращает таблицу вопросов аппеляции\n")
    @GetMapping("/by/id")
    public ResponseEntity<List<AppealByIDResponse>> getAppealById(@RequestBody AppealByIDRequest appealByIDRequest) {
        return new ResponseEntity<>(
                appealService.getAppealById(appealByIDRequest),
                HttpStatus.OK);
    }

    @Operation(summary = "Получить файл описывающий результат аппеляции", description = "Обязательные поля: 'appeal_id', " +
            "'appeal_type_id', 'test_server_id', 'expert_id'.\n" +
            "Обязательны все поля")
    @GetMapping("/result/desc/file")
    public ResponseEntity<List<AppealResultDescriptionFileResponse>> getAppealResultDescriptionFile(
            @RequestBody AppealResultDescriptionFileRequest resultDescriptionFileRequest) {
        return new ResponseEntity<>(
                appealService.getAppealResultDescriptionFile(resultDescriptionFileRequest),
                HttpStatus.OK);
    }

    @Operation(summary = "Получить файл описывающий результат аппеляции по ID", description = "Обязательные поля: 'file_id'." +
            "Обязательны все поля")
    @GetMapping("/result/desc/file/{id}")
    public ResponseEntity<AppealResultDescriptionFileByIDResponse> getAppealResultDescriptionFileById(
            @Schema(name = "File ID", example = "1", required = true)
            @PathVariable("id") Integer id) {
        return new ResponseEntity<>(
                appealService.getAppealResultDescriptionFileById(id),
                HttpStatus.OK
        );
    }

    @Operation(summary = "Получить список описывающий результат аппеляции по question ID",
            description = "Обязательны все поля")
    @GetMapping("/result/desc/list/by/question/id")
    public ResponseEntity<List<AppealResultDescriptionListByQuestionIDResponse>> getAppealResultDescriptionListByQuestionId(
            @RequestBody AppealResultDescriptionListByQuestionIDRequest resultDescriptionListByQuestionIDRequest) {
        return new ResponseEntity<>(
                appealService.getAppealResultDescriptionListByQuestionId(resultDescriptionListByQuestionIDRequest),
                HttpStatus.OK
        );
    }

    @Operation(summary = "Получить статистику аппеляций по вопросам",
            description = "Обязательны все поля")
    @GetMapping("/statistic/by/question")
    public ResponseEntity<List<AppealStatisticByQuestionResponse>> getAppealStatisticByQuestion(
            @RequestBody AppealStatisticByQuestionRequest appealStatisticByQuestionRequest) {
        return new ResponseEntity<>(
                appealService.getAppealStatisticByQuestion(appealStatisticByQuestionRequest),
                HttpStatus.OK
        );
    }

    @Operation(summary = "Получить статистику аппеляций по ID вопросов",
            description = "Обязательны все поля")
    @GetMapping("/statistic/by/question/id")
    public ResponseEntity<List<AppealStatisticByQuestionIDResponse>> getAppealStatisticByQuestionId(
            @RequestBody AppealStatisticByQuestionIDRequest appealStatisticByQuestionIDRequest) {
        return new ResponseEntity<>(
                appealService.getAppealStatisticByQuestionID(appealStatisticByQuestionIDRequest),
                HttpStatus.OK
        );
    }

}
