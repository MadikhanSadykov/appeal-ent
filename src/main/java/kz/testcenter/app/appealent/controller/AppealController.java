package kz.testcenter.app.appealent.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import kz.testcenter.app.appealent.model.functions.request.AppealByIDRequest;
import kz.testcenter.app.appealent.model.functions.request.AppealListRequest;
import kz.testcenter.app.appealent.model.functions.request.AppealResultDescriptionFileRequest;
import kz.testcenter.app.appealent.model.functions.request.AppealResultDescriptionListByQuestionIDRequest;
import kz.testcenter.app.appealent.model.functions.request.AppealSetToExpertRequest;
import kz.testcenter.app.appealent.model.functions.request.AppealStatisticByQuestionIDRequest;
import kz.testcenter.app.appealent.model.functions.request.AppealStatisticByQuestionRequest;
import kz.testcenter.app.appealent.model.functions.request.AppealUploadFileRequest;
import kz.testcenter.app.appealent.model.functions.request.SetAppealResultDescriptionFileRequest;
import kz.testcenter.app.appealent.model.functions.request.SetAppealResultDescriptionRequest;
import kz.testcenter.app.appealent.model.functions.response.AppealByIDResponse;
import kz.testcenter.app.appealent.model.functions.response.AppealListResponse;
import kz.testcenter.app.appealent.model.functions.response.AppealResultDescriptionFileByIDResponse;
import kz.testcenter.app.appealent.model.functions.response.AppealResultDescriptionFileResponse;
import kz.testcenter.app.appealent.model.functions.response.AppealResultDescriptionListByQuestionIDResponse;
import kz.testcenter.app.appealent.model.functions.response.AppealStatisticByQuestionIDResponse;
import kz.testcenter.app.appealent.model.functions.response.AppealStatisticByQuestionResponse;
import kz.testcenter.app.appealent.model.functions.response.AppealStudentResponse;
import kz.testcenter.app.appealent.model.functions.response.AppealStudentUploadFileResponse;
import kz.testcenter.app.appealent.model.functions.response.AppealUploadFileResponse;
import kz.testcenter.app.appealent.service.AppealService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/api/v1/appeal")
public class AppealController {

    private final AppealService appealService;

    @Operation(summary = "Получить список Аппеляций", description = "fn_get_appeal_list.\n" +
                    "Обязательные поля: 'test_type_id', " +
                    "'start_date', 'end_date'.\n" +
                    "! Если остальные поля не назначены, то передать в них - null !\n" +
                    "Возвращает лист аппеляций\n")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Удачно получено"),
            @ApiResponse(responseCode = "404", description = "Не найдено"),
            @ApiResponse(responseCode = "500", description = "Не валидные введеные данные / не верный формат данных")
    })
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @GetMapping("/list")
    public ResponseEntity<List<AppealListResponse>> getAppealList(
            @RequestBody AppealListRequest appealListRequest,
            @RequestParam(name = "log", defaultValue = "0") Short log) {
        return new ResponseEntity<>(
                appealService.getAppealList(appealListRequest),
                HttpStatus.OK);
    }

    @Operation(summary = "Получить вопрос аппеляции по id", description = "Обязательные поля: 'appeal_id', " +
                    "'appeal_type_id', 'end_date'.\n" +
                    "! Если остальные поля не назначены, то передать в них - null !\n" +
                    "Возвращает таблицу вопросов аппеляции\n")
    @GetMapping("/by/id")
    public ResponseEntity<List<AppealByIDResponse>> getAppealById(
            @RequestBody AppealByIDRequest appealByIDRequest,
            @RequestParam(name = "log", defaultValue = "0") Short log) {
        return new ResponseEntity<>(
                appealService.getAppealById(appealByIDRequest),
                HttpStatus.OK);
    }

    @Operation(summary = "Получить файл описывающий результат аппеляции", description = "Обязательные поля: 'appeal_id', " +
            "'appeal_type_id', 'test_server_id', 'expert_id'.\n" +
            "Обязательны все поля")
    @GetMapping("/result/desc/file")
    public ResponseEntity<List<AppealResultDescriptionFileResponse>> getAppealResultDescriptionFile(
            @RequestBody AppealResultDescriptionFileRequest resultDescriptionFileRequest,
            @RequestParam(name = "log", defaultValue = "0") Short log) {
        return new ResponseEntity<>(
                appealService.getAppealResultDescriptionFile(resultDescriptionFileRequest),
                HttpStatus.OK);
    }

    @Operation(summary = "Получить файл описывающий результат аппеляции по ID", description = "Обязательные поля: 'file_id'." +
            "Обязательны все поля")
    @GetMapping("/result/desc/file/{id}")
    public ResponseEntity<AppealResultDescriptionFileByIDResponse> getAppealResultDescriptionFileById(
            @Schema(name = "File ID", example = "1", required = true)
            @PathVariable("id") Integer id,
            @RequestParam(name = "log", defaultValue = "0") Short log) {
        return new ResponseEntity<>(
                appealService.getAppealResultDescriptionFileById(id),
                HttpStatus.OK
        );
    }

    @Operation(summary = "Получить список описывающий результат аппеляции по question ID",
            description = "Обязательны все поля")
    @GetMapping("/result/desc/list/by/question/id")
    public ResponseEntity<List<AppealResultDescriptionListByQuestionIDResponse>> getAppealResultDescriptionListByQuestionId(
            @RequestBody AppealResultDescriptionListByQuestionIDRequest resultDescriptionListByQuestionIDRequest,
            @RequestParam(name = "log", defaultValue = "0") Short log) {
        return new ResponseEntity<>(
                appealService.getAppealResultDescriptionListByQuestionId(resultDescriptionListByQuestionIDRequest),
                HttpStatus.OK
        );
    }

    @Operation(summary = "Получить статистику аппеляций по вопросам",
            description = "Обязательны все поля")
    @GetMapping("/statistic/by/question")
    public ResponseEntity<List<AppealStatisticByQuestionResponse>> getAppealStatisticByQuestion(
            @RequestBody AppealStatisticByQuestionRequest appealStatisticByQuestionRequest,
            @RequestParam(name = "log", defaultValue = "0") Short log) {
        return new ResponseEntity<>(
                appealService.getAppealStatisticByQuestion(appealStatisticByQuestionRequest),
                HttpStatus.OK
        );
    }

    @Operation(summary = "Получить статистику аппеляций по ID вопросов",
            description = "Обязательны все поля")
    @GetMapping("/statistic/by/question/id")
    public ResponseEntity<List<AppealStatisticByQuestionIDResponse>> getAppealStatisticByQuestionId(
            @RequestBody AppealStatisticByQuestionIDRequest appealStatisticByQuestionIDRequest,
            @RequestParam(name = "log", defaultValue = "0") Short log) {
        return new ResponseEntity<>(
                appealService.getAppealStatisticByQuestionID(appealStatisticByQuestionIDRequest),
                HttpStatus.OK
        );
    }

    @Operation(summary = "Получить загруженные файлы",
            description = "Обязательны все поля")
    @GetMapping("/upload/file")
    public ResponseEntity<List<AppealUploadFileResponse>> getAppealUploadFile(
            @RequestBody AppealUploadFileRequest appealUploadFileRequest,
            @RequestParam(name = "log", defaultValue = "0") Short log) {
        return new ResponseEntity<>(
                appealService.getAppealUploadFile(appealUploadFileRequest),
                HttpStatus.OK
        );
    }

    @Operation(summary = "Получить HTML результат аппеляции",
            description = "Все поля обязательны")
    @GetMapping("/result/desc/html/by/{appealId}/{appealTypeId}/{testServerId}")
    public ResponseEntity<String> getHtmlAppealResultDescription(
            @PathVariable(name = "appealId") Integer appealId,
            @PathVariable(name = "appealTypeId") Short appealTypeId,
            @PathVariable(name = "testServerId") Short testServerId,
            @RequestParam(name = "log", defaultValue = "0") Short log) {
        return new ResponseEntity<>(
                appealService.getHtmlAppealResultDescription(appealId, appealTypeId, testServerId),
                HttpStatus.OK
        );
    }

    @Operation(summary = "Получить аппеляцию студента по его student_test_id",
            description = "Обязательны все поля")
    @GetMapping("/student/by/{studentTestId}")
    public ResponseEntity<List<AppealStudentResponse>> getStudentAppeal(
            @PathVariable(name = "studentTestId") Integer studentTestId,
            @RequestParam(name = "log", defaultValue = "0") Short log) {
        return new ResponseEntity<>(
                appealService.getAppealStudent(studentTestId),
                HttpStatus.OK
        );
    }

    @Operation(summary = "Получить загруженый файл аппеляции студента",
            description = "fn_get_student_appeal_upload_file")
    @GetMapping("/student/uploadFile/by/{studentTestId}/{appealTypeId}/{testServerId}")
    public ResponseEntity<List<AppealStudentUploadFileResponse>> getAppealStudentUploadFile(
            @PathVariable(name = "studentTestId") Integer studentTestId,
            @PathVariable(name = "appealTypeId") Short appealTypeId,
            @PathVariable(name = "testServerId") Short testServerId,
            @RequestParam(name = "log", defaultValue = "0") Short log) {
        return new ResponseEntity<>(
                appealService.getAppealStudentUploadFile(studentTestId, appealTypeId, testServerId),
                HttpStatus.OK
        );
    }

    @Operation(summary = "Вернуть аппеляцию эксперту со статусом - В работе",
            description = "fn_appeal_return_to_expert_from_all_status")
    @PutMapping("/return/to/expert/by/{appealId}/{appealTypeId}/{testServerId}/{ignoreWarning}")
    public ResponseEntity<Short> returnAppealToExpertFromAllStatus(
            @PathVariable(name = "appealId") Integer appealId,
            @PathVariable(name = "appealTypeId") Short appealTypeId,
            @PathVariable(name = "testServerId") Short testServerId,
            @PathVariable(name = "ignoreWarning") Short ignoreWarning,
            @RequestParam(name = "log", defaultValue = "0") Short log) {
        return new ResponseEntity<>(
                appealService.returnToExpertFromAllStatus(appealId, appealTypeId, testServerId, ignoreWarning),
                HttpStatus.OK
        );
    }

    @Operation(summary = "Назначить аппеляцию на эксперта", description = "fn_appeal_set_to_expert")
    @PutMapping("/set/to/expert")
    public ResponseEntity<Short> setToExpert(
            @RequestBody AppealSetToExpertRequest appealSetToExpertRequest,
            @RequestParam(name = "log", defaultValue = "0") Short log) {
        return new ResponseEntity<>(
                appealService.setToExpert(appealSetToExpertRequest),
                HttpStatus.OK
        );
    }

    @Operation(summary = "Цифровое обозначение ответа в букву", description = "fn_numeric_answer_to_letter")
    @GetMapping("/numericAnswer/to/letter/{answerOrder}")
    public ResponseEntity<String> numericAnswerToLetter(
            @PathVariable(name = "answerOrder") Short answerOrder,
            @RequestParam(name = "log", defaultValue = "0") Short log) {
        return new ResponseEntity<>(
                appealService.numericAnswerToLetter(answerOrder),
                HttpStatus.OK
        );
    }

    @Operation(summary = "Сохранение содержания  пояснения в html формате",
            description = "fn_set_appeal_result_description")
    @PutMapping("/result/desc")
    public ResponseEntity<Short> setAppealResultDescription(
            @RequestBody SetAppealResultDescriptionRequest request,
            @RequestParam(name = "log") Short log) {
        return ResponseEntity
                .ok()
                .body(appealService.setAppealResultDescription(request));
    }

    @Operation(summary = "Сохранение  файла (*.docx) пояснения к решению",
            description = "fn_set_appeal_result_description_file")
    @PutMapping("/result/desc/file")
    public ResponseEntity<Short> setAppealResultDescriptionFile(
            @RequestBody SetAppealResultDescriptionFileRequest request,
            @RequestParam(name = "log") Short log) {
        return ResponseEntity
                .ok()
                .body(appealService.setAppealResultDescriptionFile(request));
    }

}
