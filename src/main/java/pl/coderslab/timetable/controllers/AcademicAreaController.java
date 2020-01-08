package pl.coderslab.timetable.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.timetable.dao.AcademicAreaDao;
import pl.coderslab.timetable.dao.AcademicSessionDao;
import pl.coderslab.timetable.dao.DepartmentDao;
import pl.coderslab.timetable.dto.AcademicLevelDto;
import pl.coderslab.timetable.model.AcademicArea;
import pl.coderslab.timetable.model.AcademicLevel;
import pl.coderslab.timetable.model.AcademicSession;
import pl.coderslab.timetable.model.Department;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/public/timetable")
public class AcademicAreaController {
    @Autowired
    AcademicAreaDao academicAreaDao;
    @Autowired
    DepartmentDao departmentDao;
    @Autowired
    AcademicSessionDao academicSessionDao;
    @GetMapping(path = "/{deptShortName}/{areaShortName}")
    public String displayTimetable(@PathVariable String deptShortName,
                                  @PathVariable String areaShortName,
                                  Model model) {

        AcademicArea academicArea = academicAreaDao.fndByShortNames( deptShortName, areaShortName);
        Optional<AcademicSession> academicSession = academicSessionDao.getActiveAcademicSession();
        List<AcademicLevelDto> academicLevelDtoList =new ArrayList<>();
        List<AcademicLevel> academicLevelsSorted=academicArea.getAcademicLevels().stream().sorted(Comparator.comparing(AcademicLevel::getLevel)).collect(Collectors.toList());
        for (AcademicLevel academicLevel: academicLevelsSorted) {
            academicLevelDtoList.add(new AcademicLevelDto(academicSession.get(),academicArea,academicLevel));
        }
        model.addAttribute("academicLevelDtoList", academicLevelDtoList);

        List<Department> departments = departmentDao.findAllByActiveSesion();

        model.addAttribute("academicArea",academicArea);
        model.addAttribute("departments",departments);
        return "timetable";
    }
}
