package com.example.StudentSpringDataJpa.dao;

import com.example.StudentSpringDataJpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Transactional
    @Modifying
    @Query(value = "insert into Student values(:name,:age,:phone,:address,:job)", nativeQuery = true)
    public void saveStudent(@Param("name") String name, @Param("age") int age, @Param("phone") String phone, @Param("address") String address, @Param("job") String job);

    @Query(value = "select * from Student u where u.id=:id", nativeQuery = true)
    public Student findStudentById(@Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "update Student set name=:name, age=:age, phone=:phone, address=:address, job=:job where id=:id", nativeQuery = true)
    public void updateStudent(@Param("id") int id, @Param("name") String name, @Param("age") int age, @Param("phone") String phone, @Param("address") String address, @Param("job") String job);

    @Transactional
    @Modifying
    @Query(value = "delete from Student where id=:id", nativeQuery = true)
    public void deleteStudent(@Param("id") int id);
}
