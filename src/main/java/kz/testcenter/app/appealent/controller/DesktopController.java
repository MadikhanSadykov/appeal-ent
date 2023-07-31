package kz.testcenter.app.appealent.controller;

import io.swagger.v3.oas.annotations.Operation;
import kz.testcenter.app.appealent.service.DesktopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/desktop")
@RequiredArgsConstructor
public class DesktopController {

    private final DesktopService desktopService;

    @Operation(summary = "Сравнить версии ПО", description = "fn_compare_app_version")
    @GetMapping("/version/{orgTypeId}/{appVersion}/{paramValue}")
    public ResponseEntity<Short> compareAppVersion(
            @PathVariable(name = "orgTypeId") Short orgTypeId,
            @PathVariable(name = "appVersion") String appVersion,
            @PathVariable(name = "paramValue") String paramValue,
            @RequestParam(name = "log") Short log) {
        return ResponseEntity
                .ok()
                .body(desktopService.compareAppVersion(orgTypeId, appVersion, paramValue));
    }

}
