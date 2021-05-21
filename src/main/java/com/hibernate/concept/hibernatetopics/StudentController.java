package com.hibernate.concept.hibernatetopics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{name}")
    public Student getStudentByName(@PathVariable String name) {
        return studentService.getStudent(name);
    }

    @GetMapping
    public List<Student> getStudentBetweenMarks() {
        return studentService.getStudentByMarksUsingBetween();
    }

    @GetMapping("/nullStudent")
    public Student getNullStudent() {
        return studentService.getNullStudent();
    }


    }
