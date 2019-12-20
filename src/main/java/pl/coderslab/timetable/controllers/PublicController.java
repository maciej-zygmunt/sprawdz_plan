package pl.coderslab.timetable.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.coderslab.timetable.dao.DepartmentDao;
import pl.coderslab.timetable.model.Department;

import java.util.List;

@Controller
public class PublicController {
    @Autowired
    DepartmentDao departmentDao;
    @GetMapping(path = "/public/{page}")
    public String index(Model model, @PathVariable String page) {
        List<Department> departments = departmentDao.findAllByActiveSesion();
        model.addAttribute("departments",departments);
        return page;
    }
    @GetMapping(path="/")
    public String redirect() {
        return "redirect:public/home";
    }
}
