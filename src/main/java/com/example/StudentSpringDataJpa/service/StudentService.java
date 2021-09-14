package com.example.StudentSpringDataJpa.service;

import com.example.StudentSpringDataJpa.entity.Student;

public interface StudentService {
    public void saveStudent(Student student);
    public Student getStudent(int id);
    public void update(Student student);
    public void delete(Student student);
}
