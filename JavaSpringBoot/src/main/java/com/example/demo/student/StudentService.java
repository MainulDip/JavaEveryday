package com.example.demo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
// @Component will also work but @Service makes more sense in the case
public class StudentService {
    public List<Student> getStudents(){
        return List.of(
                new Student(1L, "Mariam", "mariam@gmail.com", LocalDate.of(2000, Month.JANUARY, 5), 21)
        );
    }
}
