package com.zahid.university;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/university")
public class UniversityController {
    private final Logger logger = LoggerFactory.getLogger(UniversityController.class);

    @Autowired
    private UniversityService universityService; // better idea

    @GetMapping
    public ModelAndView getAllUniversity() {
        logger.debug("request to GET index");
        ModelAndView modelAndView = new ModelAndView("university-home");

        modelAndView.addObject("university", universityService.getAllUniversitys());

        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView getOneUniversity(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("university-edit-form");

        modelAndView.addObject("university", universityService.getUniversity(id));

        return modelAndView;
    }

    @GetMapping("/api/{id}")
    public University getOneUniversityWithCourse(@PathVariable("id") Long id) {
        // modelAndView.addObject("university", universityService.getUniversity(id));

        return universityService.getUniversity(id);
    }

    @PostMapping("/{id}")
    public String updateUniversity(@ModelAttribute University university, @PathVariable("id") Long id, Model model) {

        logger.info("New university = {}", university);

        universityService.updateUniversity(university);

        return "university-edit-done";
    }

    @GetMapping("/add")
    public ModelAndView createUniversityForm(Model model) {
        ModelAndView modelAndView = new ModelAndView("university-create-form");
        University university = new University();
        modelAndView.addObject("university", university);

        return modelAndView;
    }

    @PostMapping("/add")
    public String createUniversity(@ModelAttribute University university) {

        logger.info("University = {}", university);

        universityService.addUniversity(university);

        return "university-create-done";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deletePrompt(@PathVariable("id") Long id) {
        logger.info("University Id = {}", id);
        ModelAndView modelAndView = new ModelAndView("university-delete-confirm");
        modelAndView.addObject("university", universityService.getUniversity(id));

        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    public String deleteUniversity(@PathVariable("id") Long id) {
        logger.info("University Id = {}", id);

        universityService.deleteUniversity(id);

        return "university-delete-done";
    }

}