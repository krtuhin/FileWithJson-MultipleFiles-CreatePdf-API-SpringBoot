package com.filejsononeapi.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {

    private Logger logger = LoggerFactory.getLogger(FileController.class);

    //handler to upload multiple files
    @PostMapping("/upload-files")
    public ResponseEntity<?> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {

        for (MultipartFile file : files) {

            this.logger.info(file.getOriginalFilename());
            this.logger.info(file.getContentType());
        }

        return ResponseEntity.ok("File Uploaded..!");
    }
}
