package kz.testcenter.app.appealent.service.impl;

import kz.testcenter.app.appealent.dao.AppealDAO;
import kz.testcenter.app.appealent.model.functions.request.AppealByIDRequest;
import kz.testcenter.app.appealent.model.functions.request.AppealListRequest;
import kz.testcenter.app.appealent.model.functions.request.AppealResultDescriptionFileRequest;
import kz.testcenter.app.appealent.model.functions.request.AppealResultDescriptionListByQuestionIDRequest;
import kz.testcenter.app.appealent.model.functions.response.AppealByIDResponse;
import kz.testcenter.app.appealent.model.functions.response.AppealListResponse;
import kz.testcenter.app.appealent.model.functions.response.AppealResultDescriptionFileByIDResponse;
import kz.testcenter.app.appealent.model.functions.response.AppealResultDescriptionFileResponse;
import kz.testcenter.app.appealent.model.functions.response.AppealResultDescriptionListByQuestionIDResponse;
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
}
