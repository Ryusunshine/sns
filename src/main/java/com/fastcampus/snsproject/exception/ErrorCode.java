package com.fastcampus.snsproject.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User not founded"),
    POST_NOT_FOUND(HttpStatus.NOT_FOUND, "Post not founded"),
    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, "Invalid password"),
    DUPLICATED_USER_NAME(HttpStatus.CONFLICT, "Duplicated user name");
    private HttpStatus status;
    private String message;
}
