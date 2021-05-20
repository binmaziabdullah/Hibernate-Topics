package com.hibernate.concept.hibernatetopics;

import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.Cacheable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@cache = caching strategy used to persist or access data from cache with different strategy
//here we are using Reed_Write because we might frequently updating are Entity in future
//@Cacheable - used to enabling second level cache for Entity, in our case it is Employee Entity

@Data
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String Department;
    private Integer age;

}
