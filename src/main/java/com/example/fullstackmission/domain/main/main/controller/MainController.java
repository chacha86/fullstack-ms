package com.example.fullstackmission.domain.main.main.controller;

import com.example.fullstackmission.domain.main.main.service.MainService;
import com.example.fullstackmission.domain.main.note.entity.Note;
import com.example.fullstackmission.domain.main.notebook.entity.Notebook;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final MainService mainService;

    @PostConstruct
    public void init() {
        mainService.init();
    }

    @GetMapping("/")
    public String main(Model model) {

        List<Notebook> notebookList = mainService.getNotebookList();
        assert !notebookList.isEmpty();

        Notebook firstBook = notebookList.getFirst();
        List<Note> noteList = firstBook.getNoteList();
        assert !notebookList.isEmpty();

        Note firstNote = noteList.getFirst();
        return "redirect:/books/%d/notes/%d".formatted(firstBook.getId(), firstNote.getId());
    }
}
