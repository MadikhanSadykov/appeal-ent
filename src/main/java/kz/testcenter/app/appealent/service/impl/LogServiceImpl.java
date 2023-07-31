package kz.testcenter.app.appealent.service.impl;

import kz.testcenter.app.appealent.dao.LogDAO;
import kz.testcenter.app.appealent.model.functions.request.WriteLogRequest;
import kz.testcenter.app.appealent.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogServiceImpl implements LogService  {

    private final LogDAO logDAO;

    @Override
    public void writeLog(WriteLogRequest writeLogRequest) {
        logDAO.writeLog(writeLogRequest);
    }
}
