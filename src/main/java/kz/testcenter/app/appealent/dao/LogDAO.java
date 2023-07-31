package kz.testcenter.app.appealent.dao;

import kz.testcenter.app.appealent.model.functions.request.WriteLogRequest;

public interface LogDAO {

    void writeLog(WriteLogRequest writeLogRequest);

}
