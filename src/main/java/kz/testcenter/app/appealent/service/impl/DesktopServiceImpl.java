package kz.testcenter.app.appealent.service.impl;

import kz.testcenter.app.appealent.dao.DesktopDAO;
import kz.testcenter.app.appealent.service.DesktopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DesktopServiceImpl implements DesktopService {

    private final DesktopDAO desktopDAO;

    @Override
    public Short compareAppVersion(Short orgTypeId, String appVersion, String paramValue) {
        return desktopDAO.compareAppVersion(orgTypeId, appVersion, paramValue);
    }

}
