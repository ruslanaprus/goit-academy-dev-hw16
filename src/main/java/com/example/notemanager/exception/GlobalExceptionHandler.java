package com.example.notemanager.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = NoteServiceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleNoteServiceException(NoteServiceException exception, Model model) {
        log.error("A domain-specific issue was detected: {}", exception.getMessage(), exception);
        model.addAttribute("message", exception.getMessage());
        return "note/error";
    }

    @ExceptionHandler(value = Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(Throwable exception, Model model) {
        log.error("Unexpected error occurred: {}", exception.getMessage(), exception);
        model.addAttribute("message", "Internal Server Error: " + exception.getMessage());
        return "note/error";
    }

}
