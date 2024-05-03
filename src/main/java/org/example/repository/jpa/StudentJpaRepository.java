package org.example.repository.jpa;

import org.example.model.entity.jpa.JpaStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentJpaRepository extends JpaRepository<JpaStudent, Long> {
}
