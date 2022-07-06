package com.cohort15adv.muzick.models;

import com.cohort15adv.muzick.payloads.ApiResponse.Article;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Listener {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // UUID
    private Long id;
    private String name;
    private Integer age;
    // later we will add genre and user


    @OneToMany(mappedBy = "listener", fetch = FetchType.LAZY) // match the variable name in the Entity class
    @JsonIgnore
    private Set<Note> notes;

    public Listener() {
    }

    public Listener(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

//    public Set<Note> getNotes() {
//        return notes;
//    }
//
//    public void setNotes(Set<Note> notes) {
//        this.notes = notes;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
