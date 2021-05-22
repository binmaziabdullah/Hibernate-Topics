package com.hibernate.concept.hibernatetopics;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Service
@Transactional
public class StudentService {

    private final SessionFactory sessionFactory;

    public StudentService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Student getStudent(String name){
        //getting Student by name
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Student.class);
        criteria.add(Restrictions.eq("name" ,name));
        Student student =(Student) criteria.uniqueResult();
        return student;
    }

    public List<Student> getStudentByMarksUsingBetween() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Student.class);
        criteria.add(Restrictions.between("marks", "50", "60"));
        List<Student> studentList = criteria.list();
        return studentList;
    }

    public Student getNullStudent() {

        //getting the records where marks property is null
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Student.class);
        criteria.add(Restrictions.isNull("marks"));
        Student student = (Student) criteria.uniqueResult();
        return student;
    }


}
