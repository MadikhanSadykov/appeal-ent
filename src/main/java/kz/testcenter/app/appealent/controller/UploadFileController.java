package kz.testcenter.app.appealent.controller;

import io.swagger.v3.oas.annotations.Operation;
import kz.testcenter.app.appealent.service.UploadFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/uploadFile")
public class UploadFileController {

    private final UploadFileService uploadFileService;

    // TODO: define the extension for the file
    @Operation(summary = "Получить загруженый файл по id", description = "fn_get_upload_file_data_by_id")
    @GetMapping("/by/{fileId}/{testServerId}")
    public ResponseEntity<Resource> getUploadFileDataById(
            @PathVariable(name = "fileId") Integer fileId,
            @PathVariable(name = "testServerId") Short testServerId) {
        ByteArrayResource resource = new ByteArrayResource(
                uploadFileService.getUploadFileDataById(fileId, testServerId)
        );
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(resource.contentLength())
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        ContentDisposition.attachment()
                                .filename("fileData.pdf")
                                .build().toString())
                .body(resource);
    }

}
