package com.zahid.courses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseSeeder implements CommandLineRunner {
    
    private final Logger logger = LoggerFactory.getLogger(CourseSeeder.class);

    @Autowired
    CourseRepository courseRepository;

    @Override
    public void run(String... args) throws Exception {
        loadSeedData();
    }

    public void loadSeedData() {
        if(courseRepository.count() == 0) {
            Course course1 = new Course("bangla", "3");
            Course course2 = new Course("english", "3");
            Course course3 = new Course("math", "3");
            Course course4 = new Course("higher math", "3");

            courseRepository.save(course1);
            courseRepository.save(course2);
            courseRepository.save(course3);
            courseRepository.save(course4);
        }

        logger.info("Number of course(s): {}", courseRepository.count());
    }
    
}
