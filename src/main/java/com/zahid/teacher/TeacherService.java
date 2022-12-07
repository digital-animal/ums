package com.zahid.teacher;

import com.zahid.courses.Course;
import com.zahid.courses.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    private CourseService courseService;

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

    public Teacher enrollTeacherToCourse(Long teacherId, Long courseId) {
        System.out.println(teacherId);
        System.out.println(courseId);

        Teacher teacher = teacherRepository.findById(teacherId).get();
        Course course = courseService.getCourseById(courseId);
        Set<Course> enrolledCourseList = teacher.getEnrolledCourseList();
        enrolledCourseList.add(course);
        return teacherRepository.save(teacher);
    }
}
