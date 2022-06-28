package com.cohort15adv.muzick.repositories;

import com.cohort15adv.muzick.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findAllByListener_id(Long listener_id);
}
