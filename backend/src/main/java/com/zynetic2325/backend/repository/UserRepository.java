package com.zynetic2325.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zynetic2325.backend.modal.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);  // Finds a user by email
}
