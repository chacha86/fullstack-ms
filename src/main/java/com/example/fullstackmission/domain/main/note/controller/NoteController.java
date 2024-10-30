package com.example.fullstackmission.domain.main.note.controller;

import com.example.fullstackmission.domain.main.note.entity.Note;
import com.example.fullstackmission.domain.main.note.service.NoteService;
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
@RequestMapping("/notes")
public class NoteController {
    private final NoteService noteService;

    @PostMapping("/write")
    public String write() {
        Note note = noteService.writeDefault();
        return "redirect:/notes/%d".formatted(note.getId());
    }

    @GetMapping("/{id}")
    public String info(@PathVariable Long id, Model model) {
        Note note = noteService.getOne(id);
        List<Note> noteList = noteService.getList();

        model.addAttribute("selectedNote", note);
        model.addAttribute("noteList", noteList);

        return "main";
    }

    @PostMapping("/modify/{id}")
    public String modify(@PathVariable Long id, String title, String content) {
        noteService.modify(id, title, content);
        return "redirect:/notes/%d".formatted(id);
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        noteService.delete(id);
        return "redirect:/";
    }
}
