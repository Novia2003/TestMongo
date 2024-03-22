package org.example.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "courses")
public class Course {

    @Id
    private ObjectId id;

    @TextIndexed
    private String name;

    private String description;
    private String language;
    private int duration;

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name=" + name +
                ", description=" + description +
                ", language=" + language +
                ", duration=" + duration +
                '}';
    }
}
