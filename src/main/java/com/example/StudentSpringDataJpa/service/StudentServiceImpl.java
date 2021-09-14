package com.example.StudentSpringDataJpa.service;

import com.example.StudentSpringDataJpa.dao.StudentRepository;
import com.example.StudentSpringDataJpa.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        student.setId(0);
        studentRepository.save(student);
        return  student;
    }

    @Override
    public Student getStudent(int id) {
        Optional<Student> student= studentRepository.findById(id);
        return student.get();
    }

    @Override
    public void update(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void delete(Student student) {
        studentRepository.delete(student);
    }
}
