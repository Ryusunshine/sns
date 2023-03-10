package com.fastcampus.snsproject.exception;

import com.fastcampus.snsproject.controller.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(SimpleSnsApplicationException.class)
    public ResponseEntity<?> errorHandler(SimpleSnsApplicationException e) {
        log.error("Error occurs {}", e.toString());
        return ResponseEntity.status(e.getErrorCode().getStatus())
                .body(Response.error(e.getErrorCode().name()));
    }

    @ExceptionHandler(SimpleSnsApplicationException.class)
    public ResponseEntity<?> errorHandler(RuntimeException e) {
        log.error("Error occurs {}", e.toString());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Response.error("INTERNAL_SERVER_ERROR"));
    }

//    @ExceptionHandler(IllegalArgumentException.class)
//    public ResponseEntity<?> databaseErrorHandler(IllegalArgumentException e) {
//        log.error("Error occurs {}", e.toString());
//        return ResponseEntity.status(DATABASE_ERROR.getStatus())
//                .body(Response.error(DATABASE_ERROR.name()));
//    }
}

