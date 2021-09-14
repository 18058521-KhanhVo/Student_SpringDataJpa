package com.example.StudentSpringDataJpa.rest;

import com.example.StudentSpringDataJpa.entity.Student;
import com.example.StudentSpringDataJpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id) {
        return studentService.getStudent(id);
    }

    @PutMapping("/student")
    public void updateStudent(@RequestBody Student student) {
        studentService.update(student);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable int id) {
        Student student = studentService.getStudent(id);
        studentService.delete(student);
    }
}
