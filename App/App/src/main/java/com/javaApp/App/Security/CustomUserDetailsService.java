package com.javaApp.App.Security;

import com.javaApp.App.Entity.Admin;
import com.javaApp.App.Entity.Students;
import com.javaApp.App.Repository.AdminRepository;
import com.javaApp.App.Repository.StudentRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AdminRepository adminRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public CustomUserDetailsService(AdminRepository adminRepository, StudentRepository studentRepository) {
        this.adminRepository = adminRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public UserDetails  loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<Admin> adminOpt = adminRepository.findByEmail(email);
        if (adminOpt.isPresent()) {
            Admin admin = adminOpt.get();

            return new CustomUserDetails(
                    admin.getEmail(),
                    admin.getPassword(),
                    admin.getRole().name()
            );
        }

        Optional<Students> studentOpt = studentRepository.findByEmail(email);
        if (studentOpt.isPresent()) {
            Students student = studentOpt.get();

            return new CustomUserDetails(
                    student.getEmail(),
                    student.getPassword(),
                    student.getRole().name()
            );
        }
        throw new UsernameNotFoundException("NO User Found with this Email -> "+email);
    }
}
