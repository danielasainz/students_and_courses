
package com.sainz.students_and_courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {


    @Autowired
    CourseRepository courseRepo;

    public String showIndex(){
        return "index";
    }

    @GetMapping("/add")
    public String addCourse(Model model) {
        model.addAttribute("aCourse", new Course());
        return "addCourse";
    }

    @PostMapping("/save")
    public String saveCourse(@ModelAttribute("aCourse") Course courseToSave, Model model){
        courseRepo.save(courseToSave);
        return "redirect:/list";
    }
    @GetMapping("/list")
    public String listCourse(Model model){
        model.addAttribute("courseslist", courseRepo.findAll());
        return "listCourse";
    }
    @RequestMapping("/changestatus/{id}")
    public String changeStatus(@PathVariable("id") long id) {
        Course thisCourse = courseRepo.findById(id).get();
        if (thisCourse.isInSession()==true) {
            thisCourse.setInSession(false);
        }else{
            thisCourse.setInSession(true);
        }
        courseRepo.save(thisCourse);
        return "redirect:/list";
    }
    @RequestMapping("/update/{id}")
    public String updateCourse(@PathVariable("id") long id, Model model){
        model.addAttribute("aCourse", courseRepo.findById(id).get());
        return "addCourse";
    }

}
