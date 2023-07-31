package kz.testcenter.app.appealent.service;

import org.springframework.stereotype.Service;

@Service
public interface DesktopService {

    Short compareAppVersion(Short orgTypeId, String appVersion, String paramValue);

}
