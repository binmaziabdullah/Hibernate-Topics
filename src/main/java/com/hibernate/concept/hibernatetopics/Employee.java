package com.hibernate.concept.hibernatetopics;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Data
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name must not be empty")
    @Size(max = 10, message = "Name should have 10 characters only")
    private String name;

    private String Department;

    @PastOrPresent(message = "Date Should be in Past/Present")
    @Temporal(TemporalType.DATE)
    private Date dob;

    @Email(message = "Please enter a valid email address")
    private String email;

}
