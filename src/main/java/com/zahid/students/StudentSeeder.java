package com.zahid.students;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StudentSeeder implements CommandLineRunner {
    
    private final Logger logger = LoggerFactory.getLogger(StudentSeeder.class);

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        loadSeedData();
    }

    public void loadSeedData() {
        if(studentRepository.count() == 0) {
            Student student1 = new Student("Alex", "Lee", "alex.lee@gmail.com", new Date(2000, 11, 27).toString(), "Badda, Dhaka");
            Student student2 = new Student("Lee", "Cooper", "lee.cooper@gmail.com", new Date(2000, 11, 27).toString(), "Gulshan, Dhaka");
            Student student3 = new Student("John", "Doe", "john.doe@gmail.com", new Date(2000, 11, 27).toString(), "Dhanmondi, Dhaka");
            Student student4 = new Student("Zahid", "Jewel", "zahid.jewel@gmail.com", new Date(2000, 11, 27).toString(), "Uttara, Dhaka");
            Student student5 = new Student("Asif", "Hasan", "asif.hasan@gmail.com", new Date(2000, 11, 27).toString(), "Demra, Dhaka");

            studentRepository.save(student1);
            studentRepository.save(student2);
            studentRepository.save(student3);
            studentRepository.save(student4);
            studentRepository.save(student5);
        }

        logger.info("Number of student items: {}", studentRepository.count());
    }
    
}
