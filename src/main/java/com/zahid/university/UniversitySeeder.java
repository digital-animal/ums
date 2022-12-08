package com.zahid.university;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UniversitySeeder implements CommandLineRunner {
    
    private final Logger logger = LoggerFactory.getLogger(UniversitySeeder.class);

    @Autowired
    UniversityRepository universityRepository;

    @Override
    public void run(String... args) throws Exception {
        loadSeedData();
    }

    public void loadSeedData() {
        if(universityRepository.count() == 0) {
            University university1 = new University("MIT", "Jatrabari");
            University university2 = new University("IUT", "Gazipur");
            University university3 = new University("BUET", "Barishal");
            University university4 = new University("DU", "Uganda");

            universityRepository.save(university1);
            universityRepository.save(university2);
            universityRepository.save(university3);
            universityRepository.save(university4);
        }

        logger.info("Number of university(s): {}", universityRepository.count());
    }
    
}
