package org.example;

import org.example.service.CourseService;
import org.example.service.MigrationService;
import org.example.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);

        CourseService courseService = context.getBean(CourseService.class);
        courseService.testFindCourses();

        StudentService studentService = context.getBean(StudentService.class);
        studentService.testFindStudents();

        MigrationService migrationService = context.getBean(MigrationService.class);
        migrationService.migrateCourse();
        migrationService.migrateStudent();
        migrationService.migrateGroup();
        migrationService.migrateEducation();

//        DataGenerator generator = context.getBean(DataGenerator.class);
//        generator.generateGroupsAndEducations();
    }
}
