package com.example.fullstackmission.domain.note.service;

import com.example.fullstackmission.domain.note.entity.Note;
import com.example.fullstackmission.domain.note.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    public Note write(Note newNote) {
        return noteRepository.save(newNote);
    }

    public long count() {
        return noteRepository.count();
    }

    public List<Note> getList() {
        return noteRepository.findAll();
    }
}
