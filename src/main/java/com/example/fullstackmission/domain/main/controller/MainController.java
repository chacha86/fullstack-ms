package com.example.fullstackmission.domain.main.controller;

import com.example.fullstackmission.domain.main.util.UrlManager;
import com.example.fullstackmission.domain.main.notebook.coordinator.NoteAndBookCoordinator;
import com.example.fullstackmission.domain.main.notebook.entity.Notebook;
import com.example.fullstackmission.domain.main.notebook.note.entity.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final NoteAndBookCoordinator noteAndBookCoordinator;
    @GetMapping("/")
    public String root() {

        Notebook firstBook = noteAndBookCoordinator.getFirstNotebook();
        Note firstNote = noteAndBookCoordinator.getFirstNote(firstBook.getId());
        return UrlManager.redirectMain(firstBook.getId(), firstNote.getId());

    }
}
