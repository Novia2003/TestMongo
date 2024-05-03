package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.converter.MongoToJpaConverter;
import org.example.model.entity.jpa.JpaCourse;
import org.example.model.entity.jpa.JpaEducation;
import org.example.model.entity.jpa.JpaGroup;
import org.example.model.entity.jpa.JpaStudent;
import org.example.model.entity.mongo.Course;
import org.example.model.entity.mongo.Education;
import org.example.model.entity.mongo.Group;
import org.example.model.entity.mongo.Student;
import org.example.repository.jpa.CourseJpaRepository;
import org.example.repository.jpa.EducationJpaRepository;
import org.example.repository.jpa.GroupJpaRepository;
import org.example.repository.jpa.StudentJpaRepository;
import org.example.repository.mongo.CourseRepository;
import org.example.repository.mongo.EducationRepository;
import org.example.repository.mongo.GroupRepository;
import org.example.repository.mongo.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MigrationService {

    private final CourseRepository courseRepository;

    private final StudentRepository studentRepository;

    private final GroupRepository groupRepository;

    private final CourseJpaRepository courseJpaRepository;

    private final EducationJpaRepository educationJpaRepository;

    private final StudentJpaRepository studentJpaRepository;

    private final GroupJpaRepository groupJpaRepository;

    private final MongoToJpaConverter mongoToJpaConverter;

    private final EducationRepository educationRepository;

    public void migrateCourse() {
        List<Course> mongoCoursesList = courseRepository.findAll();
        List<JpaCourse> jpaCoursesList = mongoCoursesList.stream()
                .map(mongoToJpaConverter::convertCourse)
                .toList();
        courseJpaRepository.saveAll(jpaCoursesList);
    }

    public void migrateStudent() {
        List<Student> mongoStudentList = studentRepository.findAll();

        List<JpaStudent> jpaStudentList = mongoStudentList.stream()
                .map(mongoToJpaConverter::convertStudent)
                .toList();

        studentJpaRepository.saveAll(jpaStudentList);
    }

    public void migrateGroup() {
        List<Group> mongoGroupList = groupRepository.findAll();

        List<JpaGroup> jpaGroupList = mongoGroupList.stream()
                .map(mongoToJpaConverter::convertGroup)
                .toList();

        groupJpaRepository.saveAll(jpaGroupList);
    }

    public void migrateEducation() {
        List<Education> mongoEducationList = educationRepository.findAll();

        List<JpaEducation> jpaEducationList = mongoEducationList.stream()
                .map(mongoToJpaConverter::convertEducation)
                .toList();

        educationJpaRepository.saveAll(jpaEducationList);
    }

}
