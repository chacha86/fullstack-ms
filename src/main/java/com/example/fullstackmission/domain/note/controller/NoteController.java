package com.example.fullstackmission.domain.note.controller;

import com.example.fullstackmission.domain.note.entity.Note;
import com.example.fullstackmission.domain.note.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/notes")
public class NoteController {
    private final NoteService noteService;

    @GetMapping("/{id}")
    public String info(@PathVariable Long id, Model model) {
        Note note = noteService.getOne(id);
        List<Note> noteList = noteService.getList();

        model.addAttribute("note", note);
        model.addAttribute("noteList", noteList);

        return "main";
    }

}
