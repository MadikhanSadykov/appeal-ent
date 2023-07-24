package kz.testcenter.app.appealent.service;

import kz.testcenter.app.appealent.model.functions.request.AppealByIDRequest;
import kz.testcenter.app.appealent.model.functions.request.AppealListRequest;
import kz.testcenter.app.appealent.model.functions.request.AppealResultDescriptionFileRequest;
import kz.testcenter.app.appealent.model.functions.request.AppealResultDescriptionListByQuestionIDRequest;
import kz.testcenter.app.appealent.model.functions.request.AppealStatisticByQuestionIDRequest;
import kz.testcenter.app.appealent.model.functions.request.AppealStatisticByQuestionRequest;
import kz.testcenter.app.appealent.model.functions.request.AppealUploadFileRequest;
import kz.testcenter.app.appealent.model.functions.response.AppealByIDResponse;
import kz.testcenter.app.appealent.model.functions.response.AppealListResponse;
import kz.testcenter.app.appealent.model.functions.response.AppealResultDescriptionFileByIDResponse;
import kz.testcenter.app.appealent.model.functions.response.AppealResultDescriptionFileResponse;
import kz.testcenter.app.appealent.model.functions.response.AppealResultDescriptionListByQuestionIDResponse;
import kz.testcenter.app.appealent.model.functions.response.AppealStatisticByQuestionIDResponse;
import kz.testcenter.app.appealent.model.functions.response.AppealStatisticByQuestionResponse;
import kz.testcenter.app.appealent.model.functions.response.AppealUploadFileResponse;
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
