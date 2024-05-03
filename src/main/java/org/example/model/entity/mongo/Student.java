package org.example.model.entity.mongo;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "students")
@Getter
@Setter
public class Student {

    @Id
    private ObjectId id;


    @Field(name = "first_name")
    private String firstName;

    @Field(name = "last_name")
    private String lastName;

    private String email;

    @Override
    public String toString() {
        return "JpaStudent{" +
                "id=" + id +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", email=" + email +
                '}';
    }
}