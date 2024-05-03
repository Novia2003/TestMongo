package org.example.model.entity.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "educations")
@Getter
@Setter
public class JpaEducation {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private JpaStudent student;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private JpaCourse course;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private JpaGroup group;
}
