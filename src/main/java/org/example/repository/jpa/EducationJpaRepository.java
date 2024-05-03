package org.example.repository.jpa;

import org.example.model.entity.jpa.JpaEducation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationJpaRepository extends JpaRepository<JpaEducation, Long> {
}

