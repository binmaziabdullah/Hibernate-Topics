package com.hibernate.concept.hibernatetopics;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Service
@Transactional
public class StudentService {

    @PersistenceContext
    private final EntityManager entityManager;

    public StudentService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public Integer addStudent(Student student){
        Session session = entityManager.unwrap(Session.class);
        String sql = "insert into Student(name,rollNo, marks) value(:name,:rollNo,:marks)";
        Query<Student> query = session.createQuery(sql);
        query.setParameter("name", student.getName());
        query.setParameter("rollNo", student.getRollNo());
        query.setParameter("marks", student.getMarks());
        return query.executeUpdate();
    }

    public Student getStudent(Long id){
        Session session =  entityManager.unwrap(Session.class);
        Query query = session.createQuery("from Student s where s.id = :id");
        query.setParameter("id", id);
        Student student = (Student) query.uniqueResult();
        return student;
    }

    public List<Student> getAllStudent(){
        Session session =  entityManager.unwrap(Session.class);
        Query query = session.createQuery("from Student");
        List<Student>  students = query.list();
        return students;
    }

    public Integer updateStudent(Student student){
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("update Student s set name = :name, rollNo = :rollNo, marks = :marks" +
                " where s.id = :id");
        query.setParameter("id", student.getId());
        query.setParameter("name", student.getName());
        query.setParameter("rollNo", student.getRollNo());
        query.setParameter("marks", student.getMarks());
        return query.executeUpdate();
    }

    public Integer deleteStudent(Long id){
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("delete from Student where id= :id");
        query.setParameter("id", id);
        return query.executeUpdate();
    }
}
