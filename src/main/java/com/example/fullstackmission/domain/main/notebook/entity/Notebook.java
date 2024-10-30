package com.example.fullstackmission.domain.main.notebook.entity;

import com.example.fullstackmission.domain.main.note.entity.Note;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notebook {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    private String name;

    @OneToMany(mappedBy = "parent")
    @Builder.Default
    private List<Note> noteList = new ArrayList<>();

    public void addNote(Note note) {
        noteList.add(note);
        note.setParent(this);
    }
}
