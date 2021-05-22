package com.hibernate.concept.hibernatetopics;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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


    public Integer addStudent(Long id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String sql = "insert into Student(name,rollNo, marks) select name, rollNo, marks from StudentBackup where id= :id";
        Query <Student> query = session.createQuery(sql);
        query.setParameter("id", id);
        int i =  query.executeUpdate();
        session.getTransaction().commit();
        return i;
    }


    public Student getStudent(Long id){
        Session session =  sessionFactory.openSession();
        Query<Student> query = session.createQuery("from Student s where s.id = :id");
        query.setParameter("id", id);
        Student student = (Student) query.uniqueResult();
        return student;
    }

    public List<Student> getAllStudent(){
        Session session =  sessionFactory.openSession();
        Query<Student> query = session.createQuery("from Student");
        List<Student>  students = query.list();
        return students;
    }

    public Integer updateStudent(Student student){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Student> query = session.createQuery("update Student s set name = :name, rollNo = :rollNo, marks = :marks" +
                " where s.id = :id");
        query.setParameter("id", student.getId());
        query.setParameter("name", student.getName());
        query.setParameter("rollNo", student.getRollNo());
        query.setParameter("marks", student.getMarks());

        int i = query.executeUpdate();
        session.getTransaction().commit();
        return i;
    }

    public Integer deleteStudent(Long id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Student> query = session.createQuery("delete from Student where id= :id");
        query.setParameter("id", id);
        int i =  query.executeUpdate();
        session.getTransaction().commit();
        return i;
    }
}
