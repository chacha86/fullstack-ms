package com.example.fullstackmission.domain.main.notebook.controller;

import com.example.fullstackmission.domain.main.main.service.MainService;
import com.example.fullstackmission.domain.main.note.entity.Note;
import com.example.fullstackmission.domain.main.notebook.entity.Notebook;
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
    private final MainService mainService;

    @PostMapping("/write")
    public String write() {
        Notebook notebook = mainService.writeDefaultNotebook();
        Note note = notebook.getNoteList().getFirst();
        return "redirect:/books/%d/notes/%d".formatted(notebook.getId(), note.getId());
    }

//    @GetMapping("/{id}")
//    public String base(@PathVariable Long id, Model model) {
//        Note note = notebookService.getOne(id);
//        List<Note> noteList = notebookService.getList();
//
//        model.addAttribute("selectedNote", note);
//        model.addAttribute("noteList", noteList);
//
//        return "main";
//    }
}
