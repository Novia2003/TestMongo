package org.example.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "educations")
@Getter
@Setter
public class Education {

    @Id
    private ObjectId id;

    @DBRef
    private Student student;

    @DBRef
    private Course course;

    @DBRef
    private Group group;
}
