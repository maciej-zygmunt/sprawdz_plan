package pl.coderslab.timetable.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;
import pl.coderslab.timetable.model.AcademicSession;

import javax.persistence.Entity;
import java.util.Optional;

@Repository
public interface AcademicSessionDao extends JpaRepositoryImplementation<AcademicSession,Long> {
    @Query("select a from AcademicSession as a where a.isActive=true")
    public Optional<AcademicSession> getActiveAcademicSession();
}
