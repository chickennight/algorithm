package com.personal.algorithm.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ErrorHandler {
    public ResponseEntity<String> errorMessage(Exception e) {
        return new ResponseEntity<>("에러 메세지: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
