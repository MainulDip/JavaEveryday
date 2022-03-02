package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

//  SELECT * FROM student WHERE email = 'mariam@gmail.com';
//    @Query("SELECT s FROM Student s WHERE s.email = :email")
//    Student findFirstByEmail(@Param("email") String email);
//    @Query(value = "SELECT TOP 1 s FROM Student s WHERE s.email = ?1", nativeQuery=true)
    @Nullable
    @Query(value = "SELECT s FROM Student s WHERE s.email = ?1")
    Student findFirstByEmail(String email);
}
//asdf