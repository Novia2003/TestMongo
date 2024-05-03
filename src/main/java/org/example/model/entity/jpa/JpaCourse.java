package org.example.model.entity.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;


@Getter
@Setter
@Entity
@Table(name = "courses")
public class JpaCourse {

    @Id
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String language;

    @Column(nullable = false)
    private int duration;

    @OneToMany(mappedBy = "course")
    @ToString.Exclude
    private Collection<JpaEducation> educations;

    @Override
    public String toString() {
        return "JpaCourse{" +
                "id=" + id +
                ", name=" + name +
                ", description=" + description +
                ", language=" + language +
                ", duration=" + duration +
                '}';
    }
}
