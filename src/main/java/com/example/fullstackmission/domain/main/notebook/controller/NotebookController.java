package com.example.fullstackmission.domain.main.notebook.controller;

import com.example.fullstackmission.domain.main.note.entity.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.fullstackmission.domain.main.notebook.service.NotebookService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/books")
public class NotebookController {
    private final NotebookService notebookService;

    @PostMapping("/write")
    public String write() {
        notebookService.writeDefault();
        return "redirect:/";
    }
}
