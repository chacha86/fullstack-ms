package com.example.fullstackmission.domain.main.note.service;

import com.example.fullstackmission.domain.main.note.repository.NoteRepository;
import com.example.fullstackmission.domain.main.note.entity.Note;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    public Note writeDefault() {
        Note newNote = Note.builder()
                .title("new title..")
                .content("")
                .build();

        return noteRepository.save(newNote);
    }

    public long count() {
        return noteRepository.count();
    }

    public List<Note> getList() {
        return noteRepository.findAll();
    }

    public Note getOne(Long id) {
        return noteRepository.findById(id).orElseThrow();
    }

    @Transactional
    public void modify(Long id, String title, String content) {
        Note note = getOne(id);
        note.setTitle(title);
        note.setContent(content);
//        noteRepository.save(note);
    }

    public void delete(long id) {
        noteRepository.deleteById(id);
    }
}
