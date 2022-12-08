package com.zahid.teachers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    // private TeacherRepository teacherRepository;

    // public TeacherService(TeacherRepository teacherRepository) {
    //     this.teacherRepository = teacherRepository;
    // }

    public List<Teacher> getAllTeachers() {
        List<Teacher> teacherList = new ArrayList<>();
        teacherRepository.findAll().forEach(teacherList::add);
        return teacherList;
    }

    public Teacher getTeacher(Long id) {
        return teacherRepository.findById(id).get();
    }

    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(Teacher teacher) {
        Teacher t = teacherRepository.findById(teacher.getId()).get();
        t = teacher;
        return teacherRepository.save(t);
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

}
