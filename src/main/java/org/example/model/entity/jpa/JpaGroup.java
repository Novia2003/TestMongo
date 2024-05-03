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

@Entity
@Table(name = "groups")
@Getter
@Setter
public class JpaGroup {

    @Id
    private String id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "group")
    @ToString.Exclude
    private Collection<JpaEducation> educations;
}
