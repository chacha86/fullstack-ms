package com.example.fullstackmission;

import com.example.fullstackmission.domain.note.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final NoteService noteService;

    @RequestMapping("/")
    public String main() {
        return "main";
    }
}
