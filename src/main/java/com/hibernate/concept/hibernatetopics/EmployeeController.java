package com.hibernate.concept.hibernatetopics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id){
        Employee employee = employeeService.getEmployee(id);
        return ResponseEntity.ok(employee);
    }
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee>  employees = employeeService.getAllEmployee();
        return ResponseEntity.ok(employees);
    }


}
