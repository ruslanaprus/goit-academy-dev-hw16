package com.example.notemanager.service;

import com.example.notemanager.exception.ExceptionMessages;
import com.example.notemanager.exception.NoteServiceException;
import com.example.notemanager.model.Note;
import com.example.notemanager.repository.INoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final INoteRepository noteRepository;

    public Page<Note> listAll(PageRequest pageRequest) {
        return noteRepository.findAll(pageRequest);
    }

    public Note getById(long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new NoteServiceException(ExceptionMessages.NOTE_NOT_FOUND.getMessage()));
    }

    public Note create(Note note) {
        if(note.getTitle() == null || note.getTitle().isEmpty()) {
            throw new NoteServiceException(ExceptionMessages.INVALID_NOTE_DATA.getMessage());
        }
        return noteRepository.save(note);
    }

    public Note update(Note note) {
        if(!noteRepository.existsById(note.getId())) {
            throw new NoteServiceException(ExceptionMessages.NOTE_NOT_FOUND.getMessage());
        }
        noteRepository.save(note);
        return note;
    }

    public void delete(long id) {
        if(!noteRepository.existsById(id)) {
            throw new NoteServiceException(ExceptionMessages.NOTE_NOT_FOUND.getMessage());
        }
        noteRepository.deleteById(id);
    }
}
