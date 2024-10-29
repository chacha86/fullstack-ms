package com.example.fullstackmission;

import com.example.fullstackmission.domain.note.entity.Note;
import com.example.fullstackmission.domain.note.service.NoteService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final MainService mainService;

    @PostConstruct
    public void init() {
        mainService.init();
    }

    @PostMapping("/write")
    public String write() {
        mainService.writeDefaultNote();
        return "redirect:/";
    }
    @GetMapping("/")
    public String main(Model model) {
        List<Note> noteList = mainService.getNoteList();
        model.addAttribute("noteList", noteList);

        return "main";
    }
}
