package kz.testcenter.app.appealent.controller;

import io.swagger.v3.oas.annotations.Operation;
import kz.testcenter.app.appealent.service.CommissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/commission")
public class CommissionController {

    private final CommissionService commissionService;

    @Operation(summary = "Получить id аппеляционной коммиссии по user id и test type id",
            description = "Обязательны все поля")
    @GetMapping("/memberTypeId/by/{userId}/and/{testTypeId}")
    public ResponseEntity<Short> getCommissionMemberTypeIdByUserId(
            @PathVariable(name = "userId") Integer userId,
            @PathVariable(name = "testTypeId") Short testTypeId,
            @RequestParam(name = "log", defaultValue = "0") Short log) {
        return new ResponseEntity<>(
          commissionService.getCommissionMemberTypeIdByUserIdAndTestTypeId(userId, testTypeId),
          HttpStatus.OK
        );
    }
}
