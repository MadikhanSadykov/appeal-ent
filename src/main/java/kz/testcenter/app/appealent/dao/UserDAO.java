package kz.testcenter.app.appealent.dao;

import kz.testcenter.app.appealent.model.functions.response.UserRestrictListResponse;

import java.util.List;

public interface UserDAO {

    List<UserRestrictListResponse> getUserRestrictListResponse(Integer userId, Short testTypeId, Short orgTypeId);

}
