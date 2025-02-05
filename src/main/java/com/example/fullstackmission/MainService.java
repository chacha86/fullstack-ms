package com.example.fullstackmission;

import com.example.fullstackmission.domain.note.entity.Note;
import com.example.fullstackmission.domain.note.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainService {
    private final NoteService noteService;

    public void init() {
        if (noteService.count() == 0) {
            writeDefaultNote();
        }
    }

    public Note writeDefaultNote() {
        return noteService.writeDefault();
    }
    public List<Note> getNoteList() {
        return noteService.getList();
    }
}
