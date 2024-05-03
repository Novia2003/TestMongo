package org.example.repository.mongo;

import org.bson.types.ObjectId;
import org.example.model.entity.mongo.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, ObjectId> {
}

