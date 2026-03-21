package com.lms.app.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lms.app.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    // Custom query methods to check for existing credentials
    Optional<User> findByEmail(String email);
    
    Optional<User> findByUsername(String username);
}