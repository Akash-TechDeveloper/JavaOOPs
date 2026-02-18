package com.javaApp.App.Service;

import com.javaApp.App.Dto.StudentRequest;
import com.javaApp.App.Dto.StudentResponse;
import com.javaApp.App.Entity.Role;
import com.javaApp.App.Entity.Students;
import com.javaApp.App.Exception.StudentNotFoundException;
import com.javaApp.App.Exception.UserAlreadyExistsException;
import com.javaApp.App.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class StudentService {
    @Autowired
    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;
    public StudentService(StudentRepository studentRepository, PasswordEncoder passwordEncoder){
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public StudentResponse createNewStudent (StudentRequest student){
        if(studentRepository.existsByEmail(student.getEmail())){
            throw new UserAlreadyExistsException("User Already Found with is id : "+ student.getEmail() + " !!");
        }
        Students students = Students.builder()
                .username(student.getUsername())
                .email(student.getEmail())
                .password(passwordEncoder.encode(student.getPassword()))
                .role(Role.STUDENT)
                .universityId(student.getUniversityId() != null ? student.getUniversityId() : null)
                .build();
         return mapStudentToResponse(studentRepository.save(students));
    }
    public void deleteStudent (Long id){
       if(!studentRepository.existsById(id)){
           throw new StudentNotFoundException("User Not Found..");
       }
        studentRepository.deleteById(id);
    }
    public StudentResponse findStudentById(Long id){
         Students students = studentRepository.findById(id)
                .orElseThrow(()-> new StudentNotFoundException("No Student found with this Id"));
         return mapStudentToResponse(students);
    }

    public StudentResponse updateStudent (Long id,Students updatedStudent){
        Students students = studentRepository.findById(id)
                .orElseThrow(()-> new StudentNotFoundException("No Student found can't update"));
        if(updatedStudent.getUsername() != null){
            students.setUsername(updatedStudent.getUsername());
        }
        if(updatedStudent.getEmail() != null){
            students.setEmail(updatedStudent.getEmail());
        }
        if(updatedStudent.getPassword() != null && !updatedStudent.getPassword().isEmpty()) {
            students.setPassword(passwordEncoder.encode(updatedStudent.getPassword()));
        }

        return  mapStudentToResponse(studentRepository.save(students));
    }
    private StudentResponse mapStudentToResponse(Students students){
        return StudentResponse.builder()
                .id(students.getId())
                .email(students.getEmail())
                .username(students.getUsername())
                .build();
    }
}