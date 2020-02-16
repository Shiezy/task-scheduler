package com.holdings.taskscheduler.repository;

import com.holdings.taskscheduler.model.Role;
import com.holdings.taskscheduler.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByPhone(String username);

//    User findByRole(Role role);

    Boolean existsByPhone(String username);

    Boolean existsByEmail(String email);
}
