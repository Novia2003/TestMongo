package org.example.util;

import org.example.model.entity.Course;
import org.example.model.entity.Education;
import org.example.model.entity.Group;
import org.example.model.entity.Student;
import org.example.repository.CourseRepository;
import org.example.repository.EducationRepository;
import org.example.repository.GroupRepository;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataGenerator {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private EducationRepository educationRepository;

    public void generateGroupsAndEducations() {
        List<Student> students = studentRepository.findAll();
        List<Course> courses = courseRepository.findAll();

        int groupSize = 50;
        for (int i = 0; i < students.size(); i += groupSize) {
            List<Student> groupStudents = new ArrayList<>();
            for (int j = i; j < i + groupSize && j < students.size(); j++) {
                groupStudents.add(students.get(j));
            }

            Group group = new Group();
            group.setName("Group " + (i / groupSize + 1));
            groupRepository.save(group);

            Random random = new Random();
            int courseIndex = random.nextInt(courses.size());

            for (Student student : groupStudents) {
                Education education = new Education();
                education.setStudent(student);
                education.setCourse(courses.get(courseIndex));
                education.setGroup(group);
                educationRepository.save(education);
            }
        }
    }
}

