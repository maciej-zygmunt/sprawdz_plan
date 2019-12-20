package pl.coderslab.timetable.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;
import pl.coderslab.timetable.model.AcademicArea;

@Repository
public interface AcademicAreaDao extends JpaRepositoryImplementation<AcademicArea, Long> {
    @Query("select  a from AcademicSession s " +
            "join s.deparements   d " +
            "join d.academicAreas a " +
            "where " +
            "s.isActive=true " +
            "and d.shortName=?1 " +
            "and a.shortName=?2 " )
    AcademicArea fndByShortNames( String deptShortName, String areaShortName);
}
