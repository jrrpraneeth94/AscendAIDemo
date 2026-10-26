package com.example.demo.controller;

import com.example.demo.dto.UserProfileRequest;
import com.example.demo.dto.UserProfileResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserProfileResponse> processUserProfile(@RequestBody UserProfileRequest request) {
        UserProfileResponse response = new UserProfileResponse(
                "SUCCESS",
                request.getId(),
                request.getName() != null ? request.getName() : "Anonymous",
                request.isActive()
        );
        return ResponseEntity.ok(response);
    }
}