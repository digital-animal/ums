package com.zahid.teacher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TeacherSeeder implements CommandLineRunner {
    
    private final Logger logger = LoggerFactory.getLogger(TeacherSeeder.class);

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public void run(String... args) throws Exception {
        loadSeedData();
    }

    public void loadSeedData() {
        if(teacherRepository.count() == 0) {
            Teacher teacher1 = new Teacher("Alex", "Lee", "alex.lee@gmail.com", new Date(2000, 11, 27).toString(), "Badda, Dhaka");
            Teacher teacher2 = new Teacher("Lee", "Cooper", "lee.cooper@gmail.com", new Date(2000, 11, 27).toString(), "Gulshan, Dhaka");
            Teacher teacher3 = new Teacher("John", "Doe", "john.doe@gmail.com", new Date(2000, 11, 27).toString(), "Dhanmondi, Dhaka");
            Teacher teacher4 = new Teacher("Zahid", "Jewel", "zahid.jewel@gmail.com", new Date(2000, 11, 27).toString(), "Uttara, Dhaka");
            Teacher teacher5 = new Teacher("Asif", "Hasan", "asif.hasan@gmail.com", new Date(2000, 11, 27).toString(), "Demra, Dhaka");

            teacherRepository.save(teacher1);
            teacherRepository.save(teacher2);
            teacherRepository.save(teacher3);
            teacherRepository.save(teacher4);
            teacherRepository.save(teacher5);
        }

        logger.info("Number of teacher items: {}", teacherRepository.count());
    }
    
}
