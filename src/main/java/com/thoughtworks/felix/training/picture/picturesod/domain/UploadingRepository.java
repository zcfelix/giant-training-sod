package com.thoughtworks.felix.training.picture.picturesod.domain;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.thoughtworks.felix.training.picture.picturesod.domain.UploadingConstant.*;

@Repository
public class UploadingRepository {
    public void saveUploading(MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UploadingConstant.UPLOAD_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
