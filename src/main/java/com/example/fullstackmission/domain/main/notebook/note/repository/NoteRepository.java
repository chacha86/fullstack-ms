package com.example.fullstackmission.domain.main.notebook.note.repository;

import com.example.fullstackmission.domain.main.notebook.note.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
