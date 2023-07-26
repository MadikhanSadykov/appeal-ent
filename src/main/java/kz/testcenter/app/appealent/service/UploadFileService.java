package kz.testcenter.app.appealent.service;

import org.springframework.stereotype.Service;

@Service
public interface UploadFileService {

    byte[] getUploadFileDataById(Integer fileId, Short testServerId);

}
