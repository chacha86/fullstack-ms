package com.example.fullstackmission.domain.main.notebook.controller;

import com.example.fullstackmission.domain.main.util.UrlManager;
import com.example.fullstackmission.domain.main.notebook.note.entity.Note;
import com.example.fullstackmission.domain.main.notebook.coordinator.NoteAndBookCoordinator;
import com.example.fullstackmission.domain.main.notebook.entity.Notebook;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/books")
public class NotebookController {
    private final NoteAndBookCoordinator noteAndBookCoordinator;

    @PostConstruct
    public void init() {
        noteAndBookCoordinator.init();
    }

    @GetMapping("")
    public String defaultMain() {

        Notebook firstNotebook = noteAndBookCoordinator.getFirstNotebook();
        Note firstNote = noteAndBookCoordinator.getFirstNote(firstNotebook.getId());

        return UrlManager.redirectMain(firstNotebook.getId(), firstNote.getId());
    }

    @GetMapping("/{bookId}/notes")
    public String noteList(@PathVariable long bookId) {

        Notebook notebook = noteAndBookCoordinator.getNotebookById(bookId);
        List<Note> noteList = notebook.getNoteList();

        return UrlManager.redirectMain(bookId, noteList.getFirst().getId());
    }

    @GetMapping("/{bookId}/notes/{noteId}")
    public String main(@PathVariable long bookId, @PathVariable long noteId, Model model) {

        List<Notebook> notebookList = noteAndBookCoordinator.getNotebookList();
        Notebook selectedNotebook = noteAndBookCoordinator.getNotebookById(bookId);
        List<Note> noteList = selectedNotebook.getNoteList();
        Note selectedNote = noteAndBookCoordinator.getNoteById(noteId);

        model.addAttribute("selectedNote", selectedNote);
        model.addAttribute("noteList", noteList);
        model.addAttribute("selectedNotebook", selectedNotebook);
        model.addAttribute("notebookList", notebookList);

        return "main";
    }

    @PostMapping("/write")
    public String writeBook() {
        Notebook notebook = noteAndBookCoordinator.writeDefaultNotebook();
        Note note = notebook.getNoteList().getFirst();
        return UrlManager.redirectMain(notebook.getId(), note.getId());
    }

    @PostMapping("/{bookId}/notes/write")
    public String writeNote(@PathVariable long bookId) {
        Note note = noteAndBookCoordinator.writeDefaultNote(bookId);
        return UrlManager.redirectMain(bookId, note.getId());
    }

    @PostMapping("/{bookId}/notes/update")
    public String updateNote(@PathVariable long bookId) {
        Note note = noteAndBookCoordinator.writeDefaultNote(bookId);
        return UrlManager.redirectMain(bookId, note.getId());
    }

}
