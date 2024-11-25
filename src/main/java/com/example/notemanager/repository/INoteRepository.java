package com.example.notemanager.repository;

import com.example.notemanager.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INoteRepository extends JpaRepository<Note, Long> {}
