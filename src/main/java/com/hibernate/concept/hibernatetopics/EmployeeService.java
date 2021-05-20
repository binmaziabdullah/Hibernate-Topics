package com.hibernate.concept.hibernatetopics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    public Employee getEmployee(Long id){
        Employee  employee = new Employee();
        employeeRepository.findById(employee.getId());
        return employee;
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

}
