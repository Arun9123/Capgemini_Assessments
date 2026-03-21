package com.lms.app.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateEmailException.class)
    @ResponseStatus(HttpStatus.CONFLICT) // 409
    public String handleDuplicateEmail(DuplicateEmailException ex) { return ex.getMessage(); }

    @ExceptionHandler(DuplicateUsernameException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST) // 400
    public String handleDuplicateUsername(DuplicateUsernameException ex) { return ex.getMessage(); }

    @ExceptionHandler(WeakPasswordException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE) // 406
    public String handleWeakPassword(WeakPasswordException ex) { return ex.getMessage(); }

    @ExceptionHandler(InvalidCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED) // 401
    public String handleInvalidCredentials(InvalidCredentialsException ex) { return ex.getMessage(); }
}