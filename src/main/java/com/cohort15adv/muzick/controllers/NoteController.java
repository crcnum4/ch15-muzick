package com.cohort15adv.muzick.controllers;

import com.cohort15adv.muzick.models.Listener;
import com.cohort15adv.muzick.models.Note;
import com.cohort15adv.muzick.repositories.ListenerRepository;
import com.cohort15adv.muzick.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private ListenerRepository listenerRepository;

    @GetMapping("/test")
    public ResponseEntity<?> testRoute() {
        return new ResponseEntity<>("note route", HttpStatus.OK);
    }

    @PostMapping("/{listenerId}")
    public ResponseEntity<?> createNote(@PathVariable Long listenerId, @RequestBody Note newNote) {
        // TODO get listener id from authentication token
        Listener listener = listenerRepository.findById(listenerId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );

        newNote.setListener(listener);

        Note note = noteRepository.save(newNote);
        return new ResponseEntity<>(note, HttpStatus.CREATED);

    }

    @GetMapping("/")
    public ResponseEntity<List<Note>> getAllNotes() {
        List<Note> notes = noteRepository.findAll();
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteByID(@PathVariable Long id) {
        Note note = noteRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @GetMapping("/listener/{listenerId}")
    public ResponseEntity<List<Note>> getNotesByListener(@PathVariable Long listenerId) {
        List<Note> notes = noteRepository.findAllByListener_id(listenerId);

        return new ResponseEntity<>(notes, HttpStatus.OK);
    }
}
