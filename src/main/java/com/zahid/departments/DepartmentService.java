package com.zahid.departments;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        List<Department> departmentList = new ArrayList<>();
        departmentRepository.findAll().forEach(departmentList::add);
        return departmentList;
    }

    public Department getDepartment(Long id) {
        return departmentRepository.findById(id).get();
    }

    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Department department) {
        Department t = departmentRepository.findById(department.getId()).get();
        t = department;
        return departmentRepository.save(t);
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
