package kz.testcenter.app.appealent.service;

import kz.testcenter.app.appealent.model.functions.request.AuthUserRequest;
import kz.testcenter.app.appealent.model.functions.request.UserChangePasswordRequest;
import kz.testcenter.app.appealent.model.functions.response.AuthUserResponse;
import kz.testcenter.app.appealent.model.functions.response.UserRestrictListResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<UserRestrictListResponse> getUserRestrictList(Integer userId, Short testTypeId, Short orgTypeId);

    AuthUserResponse authUser(AuthUserRequest authUserRequest);

    Short userChangePassword(UserChangePasswordRequest userChangePasswordRequest);

}
