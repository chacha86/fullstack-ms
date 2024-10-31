package com.example.fullstackmission.domain.main.notebook.coordinator;

import com.example.fullstackmission.domain.main.notebook.note.entity.Note;
import com.example.fullstackmission.domain.main.notebook.note.service.NoteService;
import com.example.fullstackmission.domain.main.notebook.entity.Notebook;
import com.example.fullstackmission.domain.main.notebook.service.NotebookService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteAndBookCoordinator {
    private final NoteService noteService;
    private final NotebookService notebookService;

    @Transactional
    public void init() {

        if (notebookService.count() == 0) {
            writeDefaultNotebook();
        }
    }
    @Transactional
    public Notebook writeDefaultNotebook() {
        Notebook notebook = notebookService.writeDefault();
        Note note = writeDefaultNote(notebook.getId());
        notebook.addNote(note);

        return notebook;
    }

    public List<Notebook> getNotebookList() {
        return notebookService.getList();
    }

    public Notebook getNotebookById(long bookId) {
        return notebookService.getOne(bookId);
    }

    @Transactional
    public Note writeDefaultNote(long bookId) {
        Notebook notebook = notebookService.getOne(bookId);
        Note note = noteService.writeDefault();
        notebook.addNote(note);

        return note;
    }

    public void modifyNote(Long noteId, String title, String content) {
        noteService.modify(noteId, title, content);
    }

    public void deleteNote(long noteId) {
        noteService.delete(noteId);
    }

    public Note getNoteById(long noteId) {
        return noteService.getOne(noteId);
    }

    public List<Note> getNoteList() {
        return noteService.getList();
    }

    public Notebook getFirstNotebook() {
        return notebookService.getList().getFirst();
    }

    public Note getFirstNote(long bookId) {
        return notebookService.getOne(bookId).getNoteList().getFirst();
    }
}
