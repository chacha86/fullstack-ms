package com.example.fullstackmission.domain.main.notebook.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.fullstackmission.domain.main.notebook.service.NotebookService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/notebooks")
public class NotebookController {
    private final NotebookService NotebookService;
}
