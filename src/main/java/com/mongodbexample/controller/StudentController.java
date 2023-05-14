package com.mongodbexample.controller;

import com.mongodbexample.documents.Student;
import com.mongodbexample.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent(){
        return ResponseEntity.ok(studentRepository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Integer id){
        return ResponseEntity.ok(studentRepository.findById(id).get());
    }
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        return ResponseEntity.ok(studentRepository.save(student));
    }
    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        return ResponseEntity.ok(studentRepository.save(student));
    }
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Integer id){
        studentRepository.deleteById(id);
        return "Student deleted";
    }
}
