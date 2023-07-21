package kz.testcenter.app.appealent.dao;

import kz.testcenter.app.appealent.model.functions.request.AppealByIDRequest;
import kz.testcenter.app.appealent.model.functions.request.AppealListRequest;
import kz.testcenter.app.appealent.model.functions.response.AppealByIDResponse;
import kz.testcenter.app.appealent.model.functions.response.AppealListResponse;

import java.util.List;

public interface AppealDAO {

    List<AppealListResponse> getAppealListFun(AppealListRequest appealListRequest);

    List<AppealByIDResponse> getAppealByIdFun(AppealByIDRequest appealByIDRequest);

}
