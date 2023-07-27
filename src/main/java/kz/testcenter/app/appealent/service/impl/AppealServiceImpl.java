package kz.testcenter.app.appealent.service.impl;

import kz.testcenter.app.appealent.dao.AppealDAO;
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
import kz.testcenter.app.appealent.model.functions.response.AppealStudentResponse;
import kz.testcenter.app.appealent.model.functions.response.AppealStudentUploadFileResponse;
import kz.testcenter.app.appealent.model.functions.response.AppealUploadFileResponse;
import kz.testcenter.app.appealent.service.AppealService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppealServiceImpl implements AppealService {

    private final AppealDAO appealDAO;

    @Override
    public List<AppealListResponse> getAppealList(AppealListRequest appealListRequest) {
        return appealDAO.getAppealListFun(appealListRequest);
    }

    @Override
    public List<AppealByIDResponse> getAppealById(AppealByIDRequest appealByIDRequest) {
        return appealDAO.getAppealByIdFun(appealByIDRequest);
    }

    @Override
    public List<AppealResultDescriptionFileResponse> getAppealResultDescriptionFile(
            AppealResultDescriptionFileRequest resultDescriptionFileRequest) {
        return appealDAO.getAppealResultDescriptionFileFun(resultDescriptionFileRequest);
    }

    @Override
    public AppealResultDescriptionFileByIDResponse getAppealResultDescriptionFileById(Integer id) {
        return appealDAO.getAppealResultDescriptionFileByIdFun(id);
    }

    @Override
    public List<AppealResultDescriptionListByQuestionIDResponse> getAppealResultDescriptionListByQuestionId(
            AppealResultDescriptionListByQuestionIDRequest resultDescriptionListByQuestionIDRequest) {
        return appealDAO.getAppealResultDescriptionListByQuestionIdFun(resultDescriptionListByQuestionIDRequest);
    }

    @Override
    public List<AppealStatisticByQuestionResponse> getAppealStatisticByQuestion(
            AppealStatisticByQuestionRequest appealStatisticByQuestionRequest) {
        return appealDAO.getAppealStatisticByQuestionFun(appealStatisticByQuestionRequest);
    }

    @Override
    public List<AppealStatisticByQuestionIDResponse> getAppealStatisticByQuestionID(
            AppealStatisticByQuestionIDRequest appealStatisticByQuestionIDRequest) {
        return appealDAO.getAppealStatisticByQuestionIdFun(appealStatisticByQuestionIDRequest);
    }

    @Override
    public List<AppealUploadFileResponse> getAppealUploadFile(AppealUploadFileRequest appealUploadFileRequest) {
        return appealDAO.getAppealUploadFileResponseFun(appealUploadFileRequest);
    }

    @Override
    public String getHtmlAppealResultDescription(Integer appealId, Short appealTypeId, Short testServerId) {
        return appealDAO.getHtmlAppealResultDescription(appealId, appealTypeId, testServerId);
    }

    @Override
    public List<AppealStudentResponse> getAppealStudent(Integer studentTestId) {
        return appealDAO.getStudentAppeal(studentTestId);
    }

    @Override
    public List<AppealStudentUploadFileResponse> getAppealStudentUploadFile(
            Integer studentTestId, Short appealTypeId, Short testServerId) {
        return appealDAO.getAppealStudentUploadFile(studentTestId, appealTypeId, testServerId);
    }

}
