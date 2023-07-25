package kz.testcenter.app.appealent.dao;

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

}
