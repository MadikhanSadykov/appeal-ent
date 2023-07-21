package kz.testcenter.app.appealent.service;

import kz.testcenter.app.appealent.model.functions.request.AppealByIDRequest;
import kz.testcenter.app.appealent.model.functions.request.AppealListRequest;
import kz.testcenter.app.appealent.model.functions.response.AppealByIDResponse;
import kz.testcenter.app.appealent.model.functions.response.AppealListResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppealService {

    List<AppealListResponse> getAppealList(AppealListRequest appealListRequest);

    List<AppealByIDResponse> getAppealById(AppealByIDRequest appealByIDRequest);

}