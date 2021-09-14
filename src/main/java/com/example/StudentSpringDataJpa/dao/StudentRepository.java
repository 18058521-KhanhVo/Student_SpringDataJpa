package com.example.StudentSpringDataJpa.dao;

import com.example.StudentSpringDataJpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Modifying
    @Query(value = "insert into Student values(name,age,phone,address,job)", nativeQuery = true)
    public Student saveStudent(@Param("name") String name, @Param("age") int age, @Param("phone") String phone, @Param("address") String address, @Param("job") String job);

    @Query(value = "select * from Student u where u.id=id", nativeQuery = true)
    public Student findStudentById(@Param("id") int id);

    @Modifying
    @Query(value = "update Student u set u.name=name, u.age=age, u.phone=phone, u.address=address, u.job=job where u.id=id", nativeQuery = true)
    public void updateStudent(@Param("id") int id, @Param("name") String name, @Param("age") int age, @Param("phone") String phone, @Param("address") String address, @Param("job") String job);

    @Modifying
    @Query(value = "delete from Student u where u.id=id", nativeQuery = true)
    public void deleteStudent(@Param("id") int id);
}
