package com.example.fullstackmission.domain.main.notebook.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.fullstackmission.domain.main.notebook.repository.NotebookRepository;

@Service
@RequiredArgsConstructor
public class NotebookService {
    private final NotebookRepository NotebookRepository;
}
