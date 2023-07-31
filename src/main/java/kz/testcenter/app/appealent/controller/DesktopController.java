package kz.testcenter.app.appealent.controller;

import kz.testcenter.app.appealent.service.DesktopService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/desktop")
@RequiredArgsConstructor
public class DesktopController {

    private final DesktopService desktopService;


}
