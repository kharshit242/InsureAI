package com.infosys.repository;

import com.infosys.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    
    // Spring automatically creates a query to find a user by their email address.
    Optional<User> findByEmail(String email);
}