package com.victor.student_management_api.repository;

import com.victor.student_management_api.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT DISTINCT s FROM Student s JOIN s.subjects sub WHERE sub.grade > 8")
    List<Student> findStudentsWithGradesAboveEight();
}
