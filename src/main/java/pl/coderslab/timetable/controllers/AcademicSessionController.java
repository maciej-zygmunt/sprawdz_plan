package pl.coderslab.timetable.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.timetable.dao.AcademicSessionDao;
import pl.coderslab.timetable.model.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(path="/admin")
public class AcademicSessionController {
    @Autowired
    AcademicSessionDao academicSessionDao;
    public AcademicSession createSimpleSession() {
        /*
        <major nazwa="EiP-E-2-COiK" specjalnosc="Ciepłownictwo, ogrzewnictwo i klimatyzacja" stopien="IIst" rodzaj="S" CzyRekrutacjaZimowa="1" ileSemestrow="3"/>
         */
        List<Major> majors1 = Arrays.asList(
                Major.builder().name("EiP-E-1").description("Energetyka").build()
        );
        List<Major> majors2 = Arrays.asList(
                Major.builder().name("EiP-E-2-COIK").description("Ciepłownictwo, ogrzewnictwo i klimatyzacja").build(),
                Major.builder().name("EiP-E-2-EJ").description("Energetyka jądrowa").build()
        );
        List<AcademicLevel> academicLevels=Arrays.asList(
                AcademicLevel.builder().level("Ist").isWinterEntry(false).numberOfSemesters((short) 7).majors(majors1).build(),
                AcademicLevel.builder().level("IIst").isWinterEntry(true).numberOfSemesters((short) 3).majors(majors2).build()
        );
        List<AcademicArea> academicAreas = Arrays.asList(
        AcademicArea.builder().name("Energetyka")
                .shortName("E").academicLevels(academicLevels).build()
        );
        List<Department> departments= Arrays.asList(
        Department.builder().name("Wydział Energetyki i Paliw").
                statutoryOrder((short)4).
                shortName("WEiP").utName("EiP").academicAreas(academicAreas).build()
        );
        AcademicSession academicSession=AcademicSession.builder().isActive(true).isWinter(false)
                .unitimeName("Semestr zimowy2019")
                .name("Semestr zimowy").build();
        academicSession.setDeparements(departments);
        return academicSession;
    }
    @GetMapping("/session/add")
    @ResponseBody
    public String add() {
        AcademicSession academicSession= createSimpleSession();
        academicSessionDao.save(academicSession);
        return academicSession.toString();
    }
    @GetMapping("/sessions")
    public String allSessions(Model model){
        List<AcademicSession> academicSessions= academicSessionDao.findAll();
        model.addAttribute("academicSessions",academicSessions);
        return "academicSessions";
    }
}
