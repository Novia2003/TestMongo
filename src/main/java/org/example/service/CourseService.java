package org.example.service;

import org.bson.types.ObjectId;
import org.example.model.entity.Course;
import org.example.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public void testFindCourses() {
        List<Course> courses = courseRepository.findAll();
        courses.forEach(System.out::println);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(ObjectId id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        return courseOptional.orElse(null);
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(ObjectId id, Course course) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if (courseOptional.isPresent()) {
            course.setId(id);
            return courseRepository.save(course);
        } else {
            return null;
        }
    }

    public void deleteCourse(ObjectId id) {
        courseRepository.deleteById(id);
    }

    public List<Course> searchCoursesByName(String searchTerm) {
        TextCriteria textCriteria = TextCriteria.forDefaultLanguage().matchingAny(searchTerm);
        TextQuery textQuery = TextQuery.queryText(textCriteria);
        Sort sort = Sort.by(Sort.Direction.DESC, "score");
        return mongoTemplate.find(textQuery.with(sort), Course.class);
    }
}
