package com.zahid.students.repositories;

import org.springframework.data.repository.CrudRepository;

import com.zahid.students.models.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
    // pass
}
