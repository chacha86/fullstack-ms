package com.example.fullstackmission.domain.main.main.service;

import com.example.fullstackmission.domain.main.note.entity.Note;
import com.example.fullstackmission.domain.main.note.service.NoteService;
import com.example.fullstackmission.domain.main.notebook.entity.Notebook;
import com.example.fullstackmission.domain.main.notebook.service.NotebookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainService {
    private final NoteService noteService;
    private final NotebookService notebookService;

    public void init() {

        if(notebookService.count() == 0) {
            writeDefaultNotebook();
        }
    }

    public Note writeDefaultNote() {
        return noteService.writeDefault();
    }

    public Notebook writeDefaultNotebook() {
        Notebook notebook = notebookService.writeDefault();
        Note note = noteService.writeDefault();

        notebook.addNote(note);
        return notebook;
    }

    public List<Note> getNoteList() {
        return noteService.getList();
    }

    public List<Notebook> getNotebookList() {
        return notebookService.getList();
    }
}
