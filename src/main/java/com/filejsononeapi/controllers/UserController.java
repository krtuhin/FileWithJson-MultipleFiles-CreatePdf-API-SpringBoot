package com.filejsononeapi.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.filejsononeapi.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private ObjectMapper objectMapper;

    //handler to upload JSON and multipart file together
    @PostMapping
    public ResponseEntity<?> addUser(@RequestParam("file") MultipartFile file,
                                     @RequestParam("userData") String userData) {

        //converting string to user object
        User user = null;
        try {
            user = this.objectMapper.readValue(userData, User.class);

        } catch (JsonProcessingException e) {

            return ResponseEntity.badRequest().body("Invalid request..!");
        }

        this.logger.info("This is add user handler..!");

        this.logger.info(file.getOriginalFilename());

        this.logger.info(user.toString());

        return ResponseEntity.ok(user);
    }
}
