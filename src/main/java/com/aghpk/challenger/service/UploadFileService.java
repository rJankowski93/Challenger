package com.aghpk.challenger.service;


import com.aghpk.challenger.exeption.ApplicationException;
import com.aghpk.challenger.exeption.ErrorType;
import org.apache.commons.io.FilenameUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@Component
@ConfigurationProperties(prefix = "uploadFile")
public class UploadFileService {

    private static String uploadedFolder;

    public void uploadImage(Long userId, MultipartFile file) throws ApplicationException {
        if (!file.isEmpty()) {
            try {
                String extension = FilenameUtils.getExtension(file.getOriginalFilename());
                if (!checkImageType(file)) {
                    throw new ApplicationException(ErrorType.WRONG_TYPE_FILE, file.getName());
                }
                byte[] bytes = file.getBytes();
                File uploadDirectory = new File(uploadedFolder);
                if (!uploadDirectory.exists()) {
                    uploadDirectory.mkdirs();
                }
                File serverFile = new File(uploadDirectory.getAbsolutePath() + File.separator + userId + "." + extension);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
            } catch (Exception e) {
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

    public String getUploadedFolder() {
        return uploadedFolder;
    }

    public void setUploadedFolder(String uploadedFolder) {
        this.uploadedFolder = uploadedFolder;
    }
}
