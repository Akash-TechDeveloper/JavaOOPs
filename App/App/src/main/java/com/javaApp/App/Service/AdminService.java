package com.javaApp.App.Service;

import com.javaApp.App.Dto.AdminResponse;
import com.javaApp.App.Dto.StudentResponse;
import com.javaApp.App.Entity.Students;
import com.javaApp.App.Entity.Admin;
import com.javaApp.App.Exception.AdminNotFoundException;
import com.javaApp.App.Exception.StudentNotFoundException;
import com.javaApp.App.Repository.AdminRepository;
import com.javaApp.App.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {

    @Autowired
    private final AdminRepository adminRepository;
    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;
    public AdminService(AdminRepository adminRepository,
                        StudentRepository studentRepository,
                        PasswordEncoder passwordEncoder) {

        this.adminRepository = adminRepository;
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public List<AdminResponse> showAllUsers(){
        return adminRepository.findAll()
                .stream()
                .map(this::mapUserToResponse)
                .collect(Collectors.toList());

    }
    public List<StudentResponse> showAllStudents(){
        return studentRepository.findAll()
                .stream().map(this::mapStudentToResponse)
                .collect(Collectors.toList());
    }
    public StudentResponse getStudentByEmail(String email){
        Students students = studentRepository.findByEmail(email)
                .orElseThrow(()-> new StudentNotFoundException("No Student found in this id"));
        return mapStudentToResponse(students);
    }
    public AdminResponse updateUser (Long id, Admin updatedAdmin){
        Admin admin = adminRepository.findById(id)
                .orElseThrow(()-> new AdminNotFoundException("No User found can't update"));
        if(updatedAdmin.getUsername() != null){
            admin.setUsername(updatedAdmin.getUsername());
        }
        if(updatedAdmin.getEmail() != null){
            admin.setEmail(updatedAdmin.getEmail());
        }
        if(updatedAdmin.getPassword() != null && !updatedAdmin.getPassword().isEmpty()) {
            admin.setPassword(passwordEncoder.encode(updatedAdmin.getPassword()));
        }
        adminRepository.save(admin);

        return mapUserToResponse(admin);
    }
    public AdminResponse getUserByEmail(String email){
         Admin admin = adminRepository.findByEmail(email)
                .orElseThrow(()-> new AdminNotFoundException("No user found with this Email.."));
         return mapUserToResponse(admin);
    }

    private AdminResponse mapUserToResponse(Admin admin){
        return AdminResponse.builder()
                .id(admin.getId())
                .username(admin.getUsername())
                .email(admin.getEmail())
                .build();
    }
    private StudentResponse mapStudentToResponse(Students students){
        return StudentResponse.builder()
                .id(students.getId())
                .username(students.getUsername())
                .email(students.getEmail())
                .build();
    }
}
