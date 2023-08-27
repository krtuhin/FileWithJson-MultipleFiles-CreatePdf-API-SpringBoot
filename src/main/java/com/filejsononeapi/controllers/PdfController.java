package com.filejsononeapi.controllers;

import com.filejsononeapi.services.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;

@RestController
@RequestMapping("/pdf")
public class PdfController {

    @Autowired
    private PdfService pdfService;

    //handler to create pdf
    @GetMapping("/create-pdf")
    public ResponseEntity<InputStreamResource> createPdf() {

        //read pdf data
        ByteArrayInputStream pdf = this.pdfService.createPdf();

        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.add("Content-Disposition", "inline;file = tuhin.pdf");

        return ResponseEntity.ok()
                .headers(httpHeaders)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(pdf));
    }
}
