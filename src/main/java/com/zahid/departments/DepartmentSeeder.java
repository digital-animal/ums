package com.zahid.departments;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DepartmentSeeder implements CommandLineRunner {
    
    private final Logger logger = LoggerFactory.getLogger(DepartmentSeeder.class);

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public void run(String... args) throws Exception {
        loadSeedData();
    }

    public void loadSeedData() {
        if(departmentRepository.count() == 0) {
            Department department1 = new Department("Computer Science and Engineering (CSE)");
            Department department2 = new Department("Electrical and Electronics Engineering (EEE)");
            Department department3 = new Department("Mechanical Engineering (ME)");
            Department department4 = new Department("Civil Engineering (CE)");
            Department department5 = new Department("Industrial Production Engineering (IPE)");
            Department department6 = new Department("Metallurgical and Materials Engineering (MME)");

            departmentRepository.save(department1);
            departmentRepository.save(department2);
            departmentRepository.save(department3);
            departmentRepository.save(department4);
            departmentRepository.save(department5);
            departmentRepository.save(department6);
        }

        logger.info("Number of department items: {}", departmentRepository.count());
    }
    
}
