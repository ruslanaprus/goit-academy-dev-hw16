package com.example.notemanager.controller;

import com.example.notemanager.exception.ExceptionMessages;
import com.example.notemanager.exception.NoteServiceException;
import com.example.notemanager.model.Note;
import com.example.notemanager.service.NoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

    @GetMapping("/list")
    public ModelAndView listAll() {
        ModelAndView allNotes = new ModelAndView("note/list");
        allNotes.addObject("notes", noteService.listAll());
        return allNotes;
    }

    @PostMapping("/delete")
    public ModelAndView delete(@RequestParam("id") Long id) {
        if (id == null || id <= 0) {
            ModelAndView errorPage = new ModelAndView("note/error");
            errorPage.addObject("message", ExceptionMessages.INVALID_NOTE_ID.getMessage());
            return errorPage;
        }
        noteService.delete(id);
        return new ModelAndView("redirect:/note/list");
    }

    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam Long id) {
        if (id == null || id <= 0) {
            ModelAndView errorPage = new ModelAndView("note/error");
            errorPage.addObject("message", ExceptionMessages.INVALID_NOTE_ID.getMessage());
            return errorPage;
        }
        ModelAndView editNote = new ModelAndView("note/edit");
        editNote.addObject("note", noteService.getById(id));
        return editNote;
    }

    @PostMapping("/edit")
    public ModelAndView editById(@Valid @ModelAttribute Note note, BindingResult result) {
        if(result.hasErrors()) {
            throw new NoteServiceException(ExceptionMessages.INVALID_NOTE_DATA.getMessage());
        }
        noteService.update(note);
        return new ModelAndView("redirect:/note/list");
    }

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("note/create");
    }

    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute Note note, BindingResult result) {
        if(result.hasErrors()) {
            throw new NoteServiceException(ExceptionMessages.INVALID_NOTE_DATA.getMessage());
        }
        noteService.create(note);
        return new ModelAndView("redirect:/note/list");
    }
}
