package com.example.fullstackmission.domain.note.repository;

import com.example.fullstackmission.domain.note.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
