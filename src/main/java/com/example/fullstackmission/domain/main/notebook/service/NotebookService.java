package com.example.fullstackmission.domain.main.notebook.service;
import com.example.fullstackmission.domain.main.notebook.entity.Notebook;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.fullstackmission.domain.main.notebook.repository.NotebookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotebookService {
    private final NotebookRepository notebookRepository;

    public Notebook writeDefault() {
        Notebook notebook = Notebook.builder()
                .name("new notebook..")
                .build();

        return notebookRepository.save(notebook);
    }

    public long count() {
        return notebookRepository.count();
    }

    public List<Notebook> getList() {
        return notebookRepository.findAll();
    }
}
