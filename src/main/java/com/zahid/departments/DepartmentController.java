package com.zahid.departments;

import java.time.Instant;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zahid.courses.Course;
import com.zahid.courses.CourseService;

@Controller
@RequestMapping("/departments")
public class DepartmentController {
    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService; // better idea

    @GetMapping
    public ModelAndView getAllDepartment() {
        logger.debug("request to GET index");
        ModelAndView modelAndView = new ModelAndView("department-home");

        modelAndView.addObject("departments", departmentService.getAllDepartments());

        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView getOneDepartment(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("department-edit-form");

        modelAndView.addObject("department", departmentService.getDepartment(id));

        return modelAndView;
    }

    @GetMapping("/api/{id}")
    public Department getOneDepartmentWithCourse(@PathVariable("id") Long id) {
        // modelAndView.addObject("department", departmentService.getDepartment(id));

        return departmentService.getDepartment(id);
    }

    @PostMapping("/{id}")
    public String updateDepartment(@ModelAttribute Department department, @PathVariable("id") Long id, Model model) {

        logger.info("New department = {}", department);

        departmentService.updateDepartment(department);

        return "department-edit-done";
    }

    @GetMapping("/add")
    public ModelAndView createDepartmentForm(Model model) {
        ModelAndView modelAndView = new ModelAndView("department-create-form");
        Department department = new Department();
        modelAndView.addObject("department", department);

        return modelAndView;
    }

    @PostMapping("/add")
    public String createDepartment(@ModelAttribute Department department) {

        logger.info("Department = {}", department);

        departmentService.addDepartment(department);

        return "department-create-done";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deletePrompt(@PathVariable("id") Long id) {
        logger.info("Department Id = {}", id);
        ModelAndView modelAndView = new ModelAndView("department-delete-confirm");
        modelAndView.addObject("department", departmentService.getDepartment(id));

        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable("id") Long id) {
        logger.info("Department Id = {}", id);

        departmentService.deleteDepartment(id);

        return "department-delete-done";
    }

}