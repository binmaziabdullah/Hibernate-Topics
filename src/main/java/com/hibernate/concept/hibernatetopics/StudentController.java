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

    @PostMapping
    public Integer addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping
    public List<Student> getStudent(){
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
