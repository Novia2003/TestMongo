package org.example.controller;

import org.bson.types.ObjectId;
import org.example.model.entity.Education;
import org.example.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/educations")
public class EducationController {

    @Autowired
    private EducationService educationService;

    @GetMapping
    public List<Education> getAllEducations() {
        return educationService.getAllEducations();
    }

    @GetMapping("/{id}")
    public Education getEducationById(@PathVariable ObjectId id) {
        return educationService.getEducationById(id);
    }

    @PostMapping
    public Education createEducation(@RequestBody Education education) {
        return educationService.createEducation(education);
    }

    @PutMapping("/{id}")
    public Education updateEducation(@PathVariable ObjectId id, @RequestBody Education education) {
        return educationService.updateEducation(id, education);
    }

    @DeleteMapping("/{id}")
    public void deleteEducation(@PathVariable ObjectId id) {
        educationService.deleteEducation(id);
    }
}
