package com.advpro.profiling.tutorial.repository;

import com.advpro.profiling.tutorial.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import java.util.List;

import java.util.Optional;

/**
 * @author muhammad.khadafi
 */

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "SELECT s FROM Student s ORDER BY s.gpa DESC")
    List<Student> findTopStudent(Pageable pageable);
    default Optional<Student> findTopByGpa() {
        return findTopStudent(PageRequest.of(0, 1)).stream().findFirst();
    }
}