package com.holdings.taskscheduler.repository;

import com.holdings.taskscheduler.model.Role;
import com.holdings.taskscheduler.model.enumeration.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleEnum name);
}
