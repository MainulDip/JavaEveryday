package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
// @Component will also work but @Service makes more sense in the case
public class StudentService {


    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Optional<Student> addStudents(Student student) {
        Long newStudentId = studentRepository.save(student).getId();
        return studentRepository.findById(newStudentId);
    }

    public Optional<Student> getStudent(Long id) {
        return studentRepository.findById(id);
    }
}
