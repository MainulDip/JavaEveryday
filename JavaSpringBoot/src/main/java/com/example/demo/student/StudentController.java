package com.example.demo.student;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    public final StudentService studentService;

//    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudent(@PathVariable Long id){
        return studentService.getStudent(id);
    }

    @PostMapping
    public Optional<Student> addStudents(@RequestBody Student student){
        return studentService.addStudents(student);
    }

    @PatchMapping
    public List<Student> updateStudents(){
        return studentService.getStudents();
    }

    @DeleteMapping
    public List<Student> deleteStudents(){
        return studentService.getStudents();
    }
}
