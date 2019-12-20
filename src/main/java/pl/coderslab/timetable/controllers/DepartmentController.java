package pl.coderslab.timetable.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.timetable.dao.DepartmentDao;

@Controller
@RequestMapping(path = "/dep")
public class DepartmentController {
    @Autowired
    DepartmentDao departmentDao;

}
