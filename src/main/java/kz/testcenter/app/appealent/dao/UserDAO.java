package kz.testcenter.app.appealent.dao;

import kz.testcenter.app.appealent.model.functions.request.AuthUserRequest;
import kz.testcenter.app.appealent.model.functions.request.UserChangePasswordRequest;
import kz.testcenter.app.appealent.model.functions.response.AuthUserResponse;
import kz.testcenter.app.appealent.model.functions.response.UserRestrictListResponse;

import java.util.List;

public interface UserDAO {

    List<UserRestrictListResponse> getUserRestrictListResponse(Integer userId, Short testTypeId, Short orgTypeId);

    AuthUserResponse authUser(AuthUserRequest authUserRequest);

    String getRoleNameByUserId(Integer userId);

    Short userChangePassword(UserChangePasswordRequest userChangePasswordRequest);

}
