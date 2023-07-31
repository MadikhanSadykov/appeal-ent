package kz.testcenter.app.appealent.security;

import kz.testcenter.app.appealent.dao.UserDAO;
import kz.testcenter.app.appealent.model.User;
import kz.testcenter.app.appealent.model.functions.request.AuthUserRequest;
import kz.testcenter.app.appealent.model.functions.response.AuthUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UserDAO userDAO;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = String.valueOf(authentication.getName());
        String password = String.valueOf(authentication.getCredentials());

        if (login.isEmpty() || password.isEmpty()) {
            throw new BadCredentialsException("Неверный логин или пароль");
        }

        AuthUserResponse authUserResponse =
                userDAO.authUser(AuthUserRequest
                .builder()
                .login(login)
                .password(password)
                .build());

        User user = User.builder()
                .id(authUserResponse.getUserId())
                .username(authUserResponse.getUsername())
                .statusTypeId(authUserResponse.getUserStatusId())
                .build();

        if (user == null || user.getId() == null) {
            throw new BadCredentialsException("Неверный логин или пароль");
        }

        String role = userDAO.getRoleNameByUserId(user.getId());
        user.getRoles().add(role);


        if (!user.getStatusTypeId().equals(0)) {
            return new UsernamePasswordAuthenticationToken(
                    login, password, user.getAuthorities());
        } else {
            throw new BadCredentialsException("Неверный логин или пароль");
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
