package kz.testcenter.app.appealent.service.impl;

import kz.testcenter.app.appealent.dao.UserDAO;
import kz.testcenter.app.appealent.model.functions.response.UserRestrictListResponse;
import kz.testcenter.app.appealent.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Override
    public List<UserRestrictListResponse> getUserRestrictList(Integer userId, Short testTypeId, Short orgTypeId) {
        return userDAO.getUserRestrictListResponse(userId, testTypeId, orgTypeId);
    }

}
