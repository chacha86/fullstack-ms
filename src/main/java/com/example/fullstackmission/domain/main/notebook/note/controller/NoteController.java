package com.example.fullstackmission.domain.main.notebook.note.controller;

import com.example.fullstackmission.domain.main.notebook.note.entity.Note;
import com.example.fullstackmission.domain.main.notebook.note.service.NoteService;
import com.example.fullstackmission.domain.main.util.UrlManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;

    @PostMapping("/modify/{id}")
    public String modify(@PathVariable long id, String title, String content) {
        Note note = noteService.modify(id, title, content);
        return UrlManager.redirectMain(note.getParent().getId(), note.getId());
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        noteService.delete(id);
        return "redirect:/books";
    }




}
