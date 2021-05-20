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

    public Employee getEmployee(Long id) throws InterruptedException{
        Session session = sessionFactory.openSession();
        Employee employee1 = session.get(Employee.class, id);
        System.out.println(employee1);
        Employee employee2 = session.get(Employee.class, id);
        System.out.println(employee2);
        Employee employee3 = session.get(Employee.class, id);
        System.out.println(employee3);
        Boolean contains = session.contains(employee2);
        System.out.println(contains);
        session.close();
        return employee1;
    }

}
