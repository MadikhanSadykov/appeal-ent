package kz.testcenter.app.appealent.service.impl;

import kz.testcenter.app.appealent.dao.UploadFileDAO;
import kz.testcenter.app.appealent.service.UploadFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UploadFileServiceImpl implements UploadFileService {

    private final UploadFileDAO uploadFileDAO;

    @Override
    public byte[] getUploadFileDataById(Integer fileId, Short testServerId) {
        return uploadFileDAO.getUploadFileDataById(fileId, testServerId);
    }

}
