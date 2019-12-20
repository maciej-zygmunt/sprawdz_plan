package pl.coderslab.timetable.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;
import pl.coderslab.timetable.model.Department;

import java.util.List;

@Repository
public interface DepartmentDao extends JpaRepositoryImplementation<Department,Long> {

    @Query("select  d from AcademicSession s " +
            "join s.deparements   d  where s.isActive = true")
    List<Department> findAllByActiveSesion();
}
