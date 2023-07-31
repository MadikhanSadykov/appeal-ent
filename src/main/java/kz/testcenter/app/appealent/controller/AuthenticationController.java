package kz.testcenter.app.appealent.controller;

import io.swagger.v3.oas.annotations.Operation;
import kz.testcenter.app.appealent.model.functions.request.AuthUserRequest;
import kz.testcenter.app.appealent.model.functions.response.AuthUserResponse;
import kz.testcenter.app.appealent.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserService userService;

    @Operation(summary = "Аутентифицировать пользователя", description = "fn_auth_user")
    @PostMapping()
    public ResponseEntity<AuthUserResponse> authenticateUser(
            @RequestBody AuthUserRequest authUserRequest,
            @RequestParam(name = "log", defaultValue = "0") Short log) {
        AuthUserResponse authUserResponse = userService.authUser(authUserRequest);
        return ResponseEntity
                .ok()
                .header("token", authUserResponse.getToken())
                .body(authUserResponse);
    }

}
