package com.maviron.spring.springdemo.ocr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName OcrController.java
 * @Description TODO
 * @createTime 2024年02月05日 15:00:00
 */
@RestController
@RequestMapping("/api/ocr")
public class OcrController {

    @Autowired
    private OcrService ocrService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            File convFile = new File(System.getProperty("java.io.tmpdir") + "/" + file.getOriginalFilename());
            file.transferTo(convFile);
            String result = ocrService.recognizeText(convFile);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("识别发生错误：" + e.getMessage());
        }
    }

    @GetMapping("/recognize-url")
    public ResponseEntity<String> recognizeFromUrl(@RequestParam("imageUrl") String imageUrl) {
        try {
            String result = ocrService.recognizeTextFromUrl(imageUrl);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("从URL识别发生错误：" + e.getMessage());
        }
    }
}
