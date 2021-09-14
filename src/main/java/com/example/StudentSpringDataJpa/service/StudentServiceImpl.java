package com.example.StudentSpringDataJpa.service;

import com.example.StudentSpringDataJpa.dao.StudentRepository;
import com.example.StudentSpringDataJpa.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void saveStudent(Student student) {
        studentRepository.saveStudent(student.getName(), student.getAge(), student.getPhone(), student.getAddress(), student.getJob());
//        return student;
    }

    @Override
    public Student getStudent(int id) {
        Student student = studentRepository.findStudentById(id);
        return student;
    }

    @Override
    public void update(Student student) {
        studentRepository.updateStudent(student.getId(), student.getName(), student.getAge(), student.getPhone(), student.getAddress(), student.getJob());
    }

    @Override
    public void delete(Student student) {
        studentRepository.deleteStudent(student.getId());
    }
}
