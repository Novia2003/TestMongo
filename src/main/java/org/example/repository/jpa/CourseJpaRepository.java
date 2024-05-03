package org.example.repository.jpa;

import org.example.model.entity.jpa.JpaCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseJpaRepository extends JpaRepository<JpaCourse, Long> {
//    List<JpaCourse> findAll(Specification<JpaCourse> spec, Sort sort);
}

