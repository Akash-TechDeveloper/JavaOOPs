package com.javaApp.App.Repository;

import com.javaApp.App.Entity.Students;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<@NonNull Students,@NonNull Long> {
    boolean existsById(Long id);
    Optional<Students> findByEmail  (String email);
    boolean existsByEmail(String email);
}
