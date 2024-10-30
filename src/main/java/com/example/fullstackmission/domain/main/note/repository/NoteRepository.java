package com.example.fullstackmission.domain.main.note.repository;

import com.example.fullstackmission.domain.main.note.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
