package org.twinmotion.controller;

import org.twinmotion.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/upload")
    public String uploadPhotos(MultipartFile photo1, MultipartFile photo2, Model model) {
        try {
            String blendedImagePath = photoService.blendPhotos(photo1, photo2);
            model.addAttribute("blendedImagePath", blendedImagePath);
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
        return "result";
    }
}
