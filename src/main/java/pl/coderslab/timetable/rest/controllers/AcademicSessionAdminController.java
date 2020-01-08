package pl.coderslab.timetable.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.timetable.dao.AcademicSessionDao;
import pl.coderslab.timetable.model.AcademicSession;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin( maxAge = 3600)
@RequestMapping(path="/admin/session")
public class AcademicSessionAdminController {
    @Autowired
    AcademicSessionDao academicSessionDao;
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public AcademicSession get(@PathVariable Long id) {
        AcademicSession academicSession=academicSessionDao.findById(id).get();
        return academicSession;
    }
    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public AcademicSession add(@RequestBody AcademicSession newAcademicSession) {
        AcademicSession academicSession=academicSessionDao.save(newAcademicSession);
        return academicSession;
    }
    @RequestMapping(method= RequestMethod.DELETE, path = "/del/{id}")
    public void delete(@PathVariable Long id) {
        academicSessionDao.deleteById(id);
    }
    @RequestMapping(method = RequestMethod.PUT, path = "/update/{id}")
    public AcademicSession replace(@RequestBody AcademicSession newAcademicSession, @PathVariable Long id) {
        Optional<AcademicSession> academicSessionOptional = academicSessionDao.findById(id);
        if(academicSessionOptional.isPresent()) {
            newAcademicSession.setId(id);
            academicSessionDao.save(newAcademicSession);
            return newAcademicSession;
        }
        return newAcademicSession;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/all")
    public List<AcademicSession> getAll() {
        return academicSessionDao.findAll();
    }
}
