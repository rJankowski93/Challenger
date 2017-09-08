package com.aghpk.challenger.service;


import com.aghpk.challenger.exceptions.ApplicationException;
import com.aghpk.challenger.exceptions.ErrorType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
@ConfigurationProperties(prefix = "uploadFile")
@Getter
@Setter
public class UploadFileService {

    private static String resourceServerFolder =System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "webapp";

    private static String uploadedFolder;

    private static String defaultExtension;

    public void uploadImage(Long userId, MultipartFile file) throws ApplicationException {
        if (!file.isEmpty()) {
            try {
                if (!checkImageType(file)) {
                    throw new ApplicationException(ErrorType.WRONG_TYPE_FILE, file.getName());
                }
                byte[] bytes = file.getBytes();
                File uploadDirectory = new File(resourceServerFolder +uploadedFolder);
                if (!uploadDirectory.exists()) {
                    uploadDirectory.mkdirs();
                }
                File serverFile = new File( uploadDirectory.getAbsolutePath() + File.separator + userId + "." + defaultExtension);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
            } catch (IOException e) {
                throw new ApplicationException(ErrorType.FAILED_UPLOAD, e.getMessage());
            }
        } else {
            throw new ApplicationException(ErrorType.EMPTY_FILE, file.getName());
        }
    }

    private boolean checkImageType(MultipartFile file) {
        String contentFile = file.getContentType();
        if (contentFile != null && contentFile.split("/")[0].equals("image")) {
            return true;
        } else {
            return false;
        }
    }

}
