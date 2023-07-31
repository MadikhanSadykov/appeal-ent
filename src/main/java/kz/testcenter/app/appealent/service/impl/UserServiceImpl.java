package kz.testcenter.app.appealent.service.impl;

import kz.testcenter.app.appealent.dao.UserDAO;
import kz.testcenter.app.appealent.model.functions.request.AuthUserRequest;
import kz.testcenter.app.appealent.model.functions.response.AuthUserResponse;
import kz.testcenter.app.appealent.model.functions.response.UserRestrictListResponse;
import kz.testcenter.app.appealent.model.publics.User;
import kz.testcenter.app.appealent.repository.UserRepository;
import kz.testcenter.app.appealent.security.JwtService;
import kz.testcenter.app.appealent.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    @Override
    public List<UserRestrictListResponse> getUserRestrictList(Integer userId, Short testTypeId, Short orgTypeId) {
        return userDAO.getUserRestrictListResponse(userId, testTypeId, orgTypeId);
    }

    @Override
    public AuthUserResponse authUser(AuthUserRequest authUserRequest) {
        Optional<User> optionalUser = userRepository.findUserByLogin(authUserRequest.getLogin());
        if (!optionalUser.isPresent()) {
            throw new UsernameNotFoundException("Логин не найден");
        }
        User user = optionalUser.get();

        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("userId", user.getId());
        extraClaims.put("userStatusId", user.getUserStatusTypeId());
        extraClaims.put("createdAt", user.getCreatedAt());

        String jwtToken = jwtService.generateToken(user);
        return AuthUserResponse.builder()
                .userId(user.getId())
                .username(user.getUsername())
                .userStatusId(user.getUserStatusTypeId())
                .resultLogin(5)
                .token(jwtToken)
                .build();
    }
}
