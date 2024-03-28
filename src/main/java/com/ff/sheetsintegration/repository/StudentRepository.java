package com.ff.sheetsintegration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ff.sheetsintegration.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
