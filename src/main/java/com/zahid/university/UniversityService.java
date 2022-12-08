package com.zahid.university;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UniversityService {
    @Autowired
    private UniversityRepository universityRepository;

    public List<University> getAllUniversitys() {
        List<University> universityList = new ArrayList<>();
        universityRepository.findAll().forEach(universityList::add);
        return universityList;
    }

    public University getUniversity(Long id) {
        return universityRepository.findById(id).get();
    }

    public University addUniversity(University university) {
        return universityRepository.save(university);
    }

    public University updateUniversity(University university) {
        University t = universityRepository.findById(university.getId()).get();
        t = university;
        return universityRepository.save(t);
    }

    public void deleteUniversity(Long id) {
        universityRepository.deleteById(id);
    }
}
