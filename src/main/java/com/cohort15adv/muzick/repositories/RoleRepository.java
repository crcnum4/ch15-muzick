package com.cohort15adv.muzick.repositories;

import com.cohort15adv.muzick.models.ERole;
import com.cohort15adv.muzick.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
