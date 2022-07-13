package com.cohort15adv.muzick.repositories;

import com.cohort15adv.muzick.models.Listener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ListenerRepository extends JpaRepository<Listener, Long> {
    //generates query: "SELECT * FROM listener WHERE age = ?1"
    List<Listener> findAllByAge(Integer age);
    Optional<Listener> findByUser_Id(Long id);

//    @Query("Select * FROM listener WHERE name LIKE '%?1%'")
//    List<Listener> findAllByPartialName(String query);
}
