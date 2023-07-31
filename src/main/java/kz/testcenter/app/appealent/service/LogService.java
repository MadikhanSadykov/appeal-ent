package kz.testcenter.app.appealent.service;

import kz.testcenter.app.appealent.model.functions.request.WriteLogRequest;
import org.springframework.stereotype.Service;

@Service
public interface LogService {

    void writeLog(WriteLogRequest writeLogRequest);

}
