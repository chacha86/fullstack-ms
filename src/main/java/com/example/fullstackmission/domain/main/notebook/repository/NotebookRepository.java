package com.example.fullstackmission.domain.main.notebook.repository;

import com.example.fullstackmission.domain.main.notebook.entity.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotebookRepository extends JpaRepository<Notebook, Long> {
}
