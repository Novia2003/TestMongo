package org.example.repository;

import org.bson.types.ObjectId;
import org.example.model.entity.Education;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends MongoRepository<Education, ObjectId> {
}
