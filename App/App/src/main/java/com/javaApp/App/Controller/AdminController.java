package com.javaApp.App.Controller;

import com.javaApp.App.Dto.AdminResponse;
import com.javaApp.App.Dto.StudentResponse;
import com.javaApp.App.Entity.Admin;
import com.javaApp.App.Service.AdminService;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;
    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }
    @GetMapping("/users")
    public ResponseEntity<@NonNull List<AdminResponse>> displayAllUsers() {
        return ResponseEntity.ok(adminService.showAllUsers());
    }

    @GetMapping("/students")
    public ResponseEntity<@NonNull List<StudentResponse>> displayAllStudents(){
        return ResponseEntity.ok( adminService.showAllStudents());
    }
    @GetMapping("/student/email/{email}")
    public ResponseEntity<@NonNull StudentResponse> displayStudentByEmail(@PathVariable String email){
         return ResponseEntity.ok( adminService.getStudentByEmail(email));
    }
    @GetMapping("/users/email/{email}")
    public ResponseEntity<@NonNull AdminResponse> displayUserByEmail(@PathVariable String email){
        return ResponseEntity.ok(adminService.getUserByEmail(email));
    }
    @PutMapping("/users/{id}")
    public ResponseEntity<@NonNull AdminResponse> updateTheUser(@PathVariable Long id, @Valid @RequestBody Admin updateAdmins){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(adminService.updateUser(id,updateAdmins));
    }
}
