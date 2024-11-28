package com.example.notemanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = NoteServiceException.class)
    public String handleNoteServiceException(NoteServiceException exception, Model model) {
        model.addAttribute("message", exception.getMessage());
        return "note/error";
    }

    @ExceptionHandler(value = Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(Throwable exception, Model model) {
        model.addAttribute("message", "Internal Server Error: " + exception.getMessage());
        return "note/error";
    }

}
