package kz.testcenter.app.appealent.service;

import kz.testcenter.app.appealent.model.functions.request.appeal.AppealByIDRequest;
import kz.testcenter.app.appealent.model.functions.request.appeal.AppealListRequest;
import kz.testcenter.app.appealent.model.functions.request.appeal.AppealResultDescriptionFileRequest;
import kz.testcenter.app.appealent.model.functions.request.appeal.AppealResultDescriptionListByQuestionIDRequest;
import kz.testcenter.app.appealent.model.functions.request.appeal.AppealStatisticByQuestionIDRequest;
import kz.testcenter.app.appealent.model.functions.request.appeal.AppealStatisticByQuestionRequest;
import kz.testcenter.app.appealent.model.functions.request.appeal.AppealUploadFileRequest;
import kz.testcenter.app.appealent.model.functions.response.appeal.AppealByIDResponse;
import kz.testcenter.app.appealent.model.functions.response.appeal.AppealListResponse;
import kz.testcenter.app.appealent.model.functions.response.appeal.AppealResultDescriptionFileByIDResponse;
import kz.testcenter.app.appealent.model.functions.response.appeal.AppealResultDescriptionFileResponse;
import kz.testcenter.app.appealent.model.functions.response.appeal.AppealResultDescriptionListByQuestionIDResponse;
import kz.testcenter.app.appealent.model.functions.response.appeal.AppealStatisticByQuestionIDResponse;
import kz.testcenter.app.appealent.model.functions.response.appeal.AppealStatisticByQuestionResponse;
import kz.testcenter.app.appealent.model.functions.response.appeal.AppealUploadFileResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppealService {

    List<AppealListResponse> getAppealList(AppealListRequest appealListRequest);

    List<AppealByIDResponse> getAppealById(AppealByIDRequest appealByIDRequest);

    List<AppealResultDescriptionFileResponse> getAppealResultDescriptionFile(
            AppealResultDescriptionFileRequest appealResultDescriptionFileRequest);

    AppealResultDescriptionFileByIDResponse getAppealResultDescriptionFileById(Integer id);

    List<AppealResultDescriptionListByQuestionIDResponse> getAppealResultDescriptionListByQuestionId(
            AppealResultDescriptionListByQuestionIDRequest resultDescriptionListByQuestionIDRequest);

    List<AppealStatisticByQuestionResponse> getAppealStatisticByQuestion(
            AppealStatisticByQuestionRequest appealStatisticByQuestionRequest);

    List<AppealStatisticByQuestionIDResponse> getAppealStatisticByQuestionID(
            AppealStatisticByQuestionIDRequest request);

    List<AppealUploadFileResponse> getAppealUploadFile(AppealUploadFileRequest appealUploadFileRequest);

}
