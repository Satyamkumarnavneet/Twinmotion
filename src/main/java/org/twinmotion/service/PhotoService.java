package org.twinmotion.service;

import org.twinmotion.util.ImageUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class PhotoService {

    private final String uploadDir = "src/main/resources/static/uploads/";

    public String blendPhotos(MultipartFile photo1, MultipartFile photo2) throws IOException {
        // Ensure upload directory exists
        File uploadDirFile = new File(uploadDir);
        if (!uploadDirFile.exists()) {
            uploadDirFile.mkdirs();
        }

        // Save uploaded photos to disk
        String photo1Path = saveUploadedFile(photo1);
        String photo2Path = saveUploadedFile(photo2);

        // Blend the images
        String blendedImagePath = uploadDir + "blended.jpg";
        ImageUtil.blendImages(photo1Path, photo2Path, blendedImagePath);

        return "/uploads/blended.jpg";
    }

    private String saveUploadedFile(MultipartFile file) throws IOException {
        String filePath = uploadDir + file.getOriginalFilename();
        Path path = Paths.get(filePath);
        Files.write(path, file.getBytes());
        return filePath;
    }
}
