package com.example.cache;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> findAll() {
        List<Student> allStudents = service.findAllStudents();

        return ResponseEntity.ok(allStudents);
    }

//    @GetMapping("/students/clean-cache")
//    public ResponseEntity<List<Student>> clean() {
//        service.cleanCache();
//        return ResponseEntity.ok(Collections.emptyList());
//    }

}
