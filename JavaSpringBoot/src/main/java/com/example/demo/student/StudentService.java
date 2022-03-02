package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

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

    @Nullable
    public Optional<Student> addStudents(Student student) {
//        check if email already exists
        Boolean newEmail = studentRepository.findFirstByEmail(student.getEmail()) != null;
        String emailRegex = "^(?=.{1,64}@)[\\p{L}0-9_-]+(\\.[\\p{L}0-9_-]+)*@"
                + "[^-][\\p{L}0-9-]+(\\.[\\p{L}0-9-]+)*(\\.[\\p{L}]{2,})$";
        Boolean isValidEmail = Pattern.matches(emailRegex, student.getEmail());
        System.out.println("Email already exists = " + newEmail);
        System.out.println(student.getEmail() + " is valid = " + isValidEmail);
        if (newEmail || !isValidEmail) {
//            return null;
            throw new  IllegalArgumentException("Invalid Request, Email Exists");
        }
//        mariam@gmail.com
        Long newStudentId = studentRepository.save(student).getId();
        return studentRepository.findById(newStudentId);
    }

    public Optional<Student> getStudent(Long id) {
        return studentRepository.findById(id);
    }
}
