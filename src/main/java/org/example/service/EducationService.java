package org.example.service;

import org.bson.types.ObjectId;
import org.example.model.entity.Course;
import org.example.model.entity.Education;
import org.example.model.entity.Group;
import org.example.model.entity.Student;
import org.example.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationService {

    @Autowired
    private EducationRepository educationRepository;

    public List<Education> getAllEducations() {
        return educationRepository.findAll();
    }

    public Education getEducationById(ObjectId id) {
        Optional<Education> educationOptional = educationRepository.findById(id);
        return educationOptional.orElse(null);
    }

    public Education createEducation(Education education) {
        return educationRepository.save(education);
    }

    public Education updateEducation(ObjectId id, Education education) {
        Optional<Education> educationOptional = educationRepository.findById(id);
        if (educationOptional.isPresent()) {
            education.setId(id);
            return educationRepository.save(education);
        } else {
            return null;
        }
    }

    public void deleteEducation(ObjectId id) {
        educationRepository.deleteById(id);
    }
}
