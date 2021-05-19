package com.hibernate.concept.hibernatetopics;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Employee {

    @Id
    private Long id;
    private String name;
    private String Department;
    private Integer age;

}
