package com.hibernate.concept.hibernatetopics;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class EmployeeService {

    @Autowired
    private SessionFactory sessionFactory;

    public Employee getEmployee(Long id){
        Session session = sessionFactory.openSession();
        Employee employee = session.get(Employee.class, id);
        return employee;
    }

}
