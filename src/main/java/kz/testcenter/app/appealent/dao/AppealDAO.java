package kz.testcenter.app.appealent.dao;

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
import kz.testcenter.app.appealent.model.functions.request.SetExpertPrevResultRequest;
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

import java.util.List;

public interface AppealDAO {

    List<AppealListResponse> getAppealListFun(AppealListRequest appealListRequest);

    List<AppealByIDResponse> getAppealByIdFun(AppealByIDRequest appealByIDRequest);

    List<AppealResultDescriptionFileResponse> getAppealResultDescriptionFileFun(AppealResultDescriptionFileRequest request);

    AppealResultDescriptionFileByIDResponse getAppealResultDescriptionFileByIdFun(Integer id);

    List<AppealResultDescriptionListByQuestionIDResponse> getAppealResultDescriptionListByQuestionIdFun(
            AppealResultDescriptionListByQuestionIDRequest request);

    List<AppealStatisticByQuestionResponse> getAppealStatisticByQuestionFun(
            AppealStatisticByQuestionRequest appealStatisticByQuestionRequest);

    List<AppealStatisticByQuestionIDResponse> getAppealStatisticByQuestionIdFun(
            AppealStatisticByQuestionIDRequest request);

    List<AppealUploadFileResponse> getAppealUploadFileResponseFun(AppealUploadFileRequest appealUploadFileRequest);

    String getHtmlAppealResultDescription(Integer appealId, Short appealTypeId, Short testServerId);

    List<AppealStudentResponse> getStudentAppeal(Integer studentTestId);

    List<AppealStudentUploadFileResponse> getAppealStudentUploadFile(
            Integer studentTestId, Short appealTypeId, Short testServerId);

    Short returnToExpertFromAllStatus(Integer appealId, Short appealTypeId, Short testServerId, Short ignoreWarning);

    Short setToExpert(AppealSetToExpertRequest appealSetToExpertRequest);

    String numericAnswerToLetter(Short answerOrder);

    Short setAppealResultDescription(SetAppealResultDescriptionRequest request);

    Short setAppealResultDescriptionFile(SetAppealResultDescriptionFileRequest request);

}
