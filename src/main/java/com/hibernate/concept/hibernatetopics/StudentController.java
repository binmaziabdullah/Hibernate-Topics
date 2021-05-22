package com.hibernate.concept.hibernatetopics;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/{id}")
    public String addStudent(@PathVariable Long id){
        studentService.addStudent(id);
        return "added";
    }

    @GetMapping
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id){
        return studentService.getStudent(id);
    }
    @PutMapping
    public String updateStudent(@RequestBody Student student){
        int i = studentService.updateStudent(student);
        return i+" "+"Student updated";
    }
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id){
        int i = studentService.deleteStudent(id);
        return i+" "+"Student Deleted";
    }
}
