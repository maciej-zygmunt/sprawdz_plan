package pl.coderslab.timetable;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.coderslab.timetable.controllers.AcademicSessionController;
import pl.coderslab.timetable.dto.AcademicLevelDto;
import pl.coderslab.timetable.model.AcademicArea;
import pl.coderslab.timetable.model.AcademicLevel;
import pl.coderslab.timetable.model.AcademicSession;



import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import java.util.List;

@SpringBootTest
class TimetableApplicationTests {
    @Autowired
    AcademicSessionController academicSessionController;
    @Test
    void testAddClassifications() {
        AcademicSession academicSession= academicSessionController.createSimpleSession();
        AcademicArea academicArea=academicSession.getDeparements().get(0).getAcademicAreas().get(0);
        AcademicLevel st1=academicArea.getAcademicLevels().get(0);
        AcademicLevel st2=academicArea.getAcademicLevels().get(1);
        AcademicLevelDto academicLevelDto1 = new AcademicLevelDto(academicSession,academicArea,st1);
        List<String> years1 = academicLevelDto1.getYears();
        AcademicLevelDto academicLevelDto2 = new AcademicLevelDto(academicSession,academicArea,st2);
        List<String> years2 = academicLevelDto2.getYears();
        assertThat(years1.size(),is(4));
        assertThat(years2.size(),is(1));
    }

}
