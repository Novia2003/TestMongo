package org.example.repository.jpa;

import org.example.model.entity.jpa.JpaGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupJpaRepository extends JpaRepository<JpaGroup, Long> {
}
