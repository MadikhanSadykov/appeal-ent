package kz.testcenter.app.appealent.dao.impl;

import kz.testcenter.app.appealent.dao.DesktopDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
public class DesktopDAOImpl implements DesktopDAO {

    private final EntityManager entityManager;

    @Override
    @Transactional
    public Short compareAppVersion(Short orgTypeId, String appVersion, String paramValue) {
        return null;
    }

}
