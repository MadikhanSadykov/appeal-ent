package kz.testcenter.app.appealent.controller;

import io.swagger.v3.oas.annotations.Operation;
import kz.testcenter.app.appealent.model.functions.request.UserChangePasswordRequest;
import kz.testcenter.app.appealent.model.functions.response.UserRestrictListResponse;
import kz.testcenter.app.appealent.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @Operation(summary = "Получить список ограничений пользователя",
            description = "fn_get_user_restrict_list")
    @GetMapping("/restrict/list/by/{userId}/{testTypeId}/{orgTypeId}")
    public ResponseEntity<List<UserRestrictListResponse>> getUserRestrictList(
            @PathVariable(name = "userId") Integer userId,
            @PathVariable(name = "testTypeId") Short testTypeId,
            @PathVariable(name = "orgTypeId") Short orgTypeId,
            @RequestParam(name = "log", defaultValue = "0") Short log) {
        return new ResponseEntity<>(
                userService.getUserRestrictList(userId, testTypeId, orgTypeId),
                HttpStatus.OK
        );
    }

    @Operation(summary = "Изменить пароль пользователя",
            description = "fn_user_change_password")
    @PutMapping("/change/password")
    public ResponseEntity<Short> userChangePassword(
            @RequestBody UserChangePasswordRequest request,
            @RequestParam(name = "log", defaultValue = "0") Short log) {
        return ResponseEntity
                .ok()
                .body(userService.userChangePassword(request));
    }

}
