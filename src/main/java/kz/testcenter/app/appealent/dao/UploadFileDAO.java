package kz.testcenter.app.appealent.dao;

public interface UploadFileDAO {

    byte[] getUploadFileDataById(Integer fileId, Short testServerId);

}
