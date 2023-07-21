package kz.testcenter.app.appealent.service.impl;

import kz.testcenter.app.appealent.dao.AppealDAO;
import kz.testcenter.app.appealent.model.functions.request.AppealListRequest;
import kz.testcenter.app.appealent.model.functions.response.AppealListResponse;
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
}
