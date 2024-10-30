package com.example.fullstackmission.domain.main.note.controller;

import com.example.fullstackmission.domain.main.main.service.MainService;
import com.example.fullstackmission.domain.main.note.entity.Note;
import com.example.fullstackmission.domain.main.note.service.NoteService;
import com.example.fullstackmission.domain.main.notebook.entity.Notebook;
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
@RequestMapping("/books/{bookId}/notes")
public class NoteController {
//    private final NoteService noteService;
    private final MainService mainService;
    @PostMapping("/write")
    public String write(@PathVariable long bookId) {
        Note note = mainService.writeDefaultNote(bookId);
        return "redirect:/books/%d/notes/%d".formatted(bookId, note.getId());
    }

    @GetMapping("")
    public String list(@PathVariable long bookId) {
        Notebook notebook = mainService.getNotebookById(bookId);
        List<Note> noteList = notebook.getNoteList();
        assert !noteList.isEmpty();

        return "redirect:/books/%d/notes/%d".formatted(bookId, noteList.getFirst().getId());
    }

    @GetMapping("/{noteId}")
    public String base(@PathVariable long bookId, @PathVariable long noteId, Model model) {
        Notebook notebook = mainService.getNotebookById(bookId);
        List<Notebook> notebookList = mainService.getNotebookList();

        Note note = mainService.getNoteById(noteId);
        List<Note> noteList = notebook.getNoteList();

        model.addAttribute("selectedNote", note);
        model.addAttribute("noteList", noteList);
        model.addAttribute("selectedNotebook", notebook);
        model.addAttribute("notebookList", notebookList);

        return "main";
    }

    @PostMapping("/modify/{noteId}")
    public String modify(@PathVariable Long bookId, @PathVariable Long noteId, String title, String content) {
        mainService.modifyNote(noteId, title, content);
        return "redirect:/books/%d/notes/%d".formatted(bookId, noteId);
    }

    @PostMapping("/delete/{noteId}")
    public String delete(@PathVariable long bookId, @PathVariable long noteId) {
        mainService.deleteNote(noteId);
        return "redirect:/books/%d/notes".formatted(bookId);
    }
}
