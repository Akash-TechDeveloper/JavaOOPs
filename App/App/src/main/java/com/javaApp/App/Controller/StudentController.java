package com.javaApp.App.Controller;

import com.javaApp.App.Dto.StudentRequest;
import com.javaApp.App.Dto.StudentResponse;
import com.javaApp.App.Entity.Students;
import com.javaApp.App.Service.StudentService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController

@RequestMapping ("/students")
public class StudentController {

    @Autowired
    private final StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @PostMapping
    public ResponseEntity<@NonNull StudentResponse> CreateStudent(@Valid @RequestBody StudentRequest students){
          return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(students));
    }

    @GetMapping("/{id}")
    public ResponseEntity<@NonNull StudentResponse> displayStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.findStudentById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<@NonNull StudentResponse> updateStudent(@PathVariable Long id, @RequestBody Students updatedStudent){
        return ResponseEntity.ok(studentService.updateStudent(id,updatedStudent));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<@NonNull Void> deleteStudent(@PathVariable Long id){
         studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
