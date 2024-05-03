package org.example.converter;

import org.example.model.entity.jpa.JpaCourse;
import org.example.model.entity.jpa.JpaEducation;
import org.example.model.entity.jpa.JpaGroup;
import org.example.model.entity.jpa.JpaStudent;
import org.example.model.entity.mongo.Course;
import org.example.model.entity.mongo.Education;
import org.example.model.entity.mongo.Group;
import org.example.model.entity.mongo.Student;
import org.springframework.stereotype.Component;

@Component
public class MongoToJpaConverter {

    public JpaCourse convertCourse(Course course) {
        JpaCourse result = new JpaCourse();

        result.setId(course.getId().toString());
        result.setName(course.getName());
        result.setDescription(course.getDescription());
        result.setDuration(course.getDuration());
        result.setLanguage(course.getLanguage());

        return result;
    }

    public JpaStudent convertStudent(Student student) {
        JpaStudent result = new JpaStudent();

        result.setId(student.getId().toString());
        result.setEmail(student.getEmail());
        result.setFirstName(student.getFirstName());
        result.setLastName(student.getLastName());

        return result;
    }

    public JpaGroup convertGroup(Group group) {
        JpaGroup result = new JpaGroup();

        result.setId(group.getId().toString());
        result.setName(group.getName());

        return result;
    }

    public JpaEducation convertEducation(Education education) {
        JpaEducation result = new JpaEducation();

        result.setId(education.getId().toString());
        result.setStudent(convertStudent(education.getStudent()));
        result.setCourse(convertCourse(education.getCourse()));
        result.setGroup(convertGroup(education.getGroup()));

        return result;
    }

}
