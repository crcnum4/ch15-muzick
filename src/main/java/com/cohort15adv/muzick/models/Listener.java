package com.cohort15adv.muzick.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Listener {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // UUID
    private Long id;
    private String name;
    private Integer age;
    // later we will add genre and user


    public Listener() {
    }

    public Listener(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

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
