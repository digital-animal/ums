package com.zahid.university;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/university")
public class UniversityRestController {
    private final Logger logger = LoggerFactory.getLogger(UniversityController.class);

    @Autowired
    private UniversityService universityService; // better idea

    @PostMapping
    public University createUniversity(@RequestBody University university) {
        logger.info("New University = {}", university);
        return universityService.addUniversity(university);
    }

    @GetMapping("/{id}")
    public University getOneUniversity(@PathVariable("id") Long id) {
        logger.info("University", universityService.getUniversity(id));
        return universityService.getUniversity(id);
    }

    @GetMapping
    public List<University> getAllUniversity() {
        logger.info("Universitys:", universityService.getAllUniversitys());
        return universityService.getAllUniversitys();
    }

    @PostMapping("/{id}")
    public University updateUniversity(@RequestBody University university, @PathVariable("id") Long id) {
        logger.info("Updated University = {}", university);
        return universityService.updateUniversity(university);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUniversity(@PathVariable("id") Long id) {
        logger.info("University Id = {}", id);
        universityService.deleteUniversity(id);

        return ResponseEntity.ok( "University Deleted");
    }

}