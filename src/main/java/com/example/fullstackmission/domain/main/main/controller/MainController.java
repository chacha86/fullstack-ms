package com.example.fullstackmission.domain.main.main.controller;

import com.example.fullstackmission.domain.main.main.service.MainService;
import com.example.fullstackmission.domain.main.note.entity.Note;
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

        List<Note> noteList = mainService.getNoteList();
        assert !noteList.isEmpty();

        Note first = noteList.getFirst();
        return "redirect:/notes/%d".formatted(first.getId());
    }
}
