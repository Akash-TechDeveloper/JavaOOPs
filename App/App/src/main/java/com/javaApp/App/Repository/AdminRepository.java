package com.javaApp.App.Repository;
import com.javaApp.App.Entity.Admin;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<@NonNull Admin,@NonNull Long> {
    Optional<Admin> findByEmail(String email);
}
