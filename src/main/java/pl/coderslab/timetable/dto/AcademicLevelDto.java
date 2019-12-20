package pl.coderslab.timetable.dto;

import lombok.Data;
import pl.coderslab.timetable.model.AcademicArea;
import pl.coderslab.timetable.model.AcademicLevel;
import pl.coderslab.timetable.model.AcademicSession;
import pl.coderslab.timetable.model.Major;

import java.util.ArrayList;
import java.util.List;

@Data
public class AcademicLevelDto {
    private final AcademicSession academicSession;
    private final AcademicArea academicArea;
    private final AcademicLevel academicLevel;
    public  List<String> getYears() {
        boolean isWinter=academicSession.getIsWinter();
        int numberOfSemesters=academicLevel.getNumberOfSemesters();
        boolean isWinterEntry=academicLevel.getIsWinterEntry();
        List<String> years= new ArrayList<>();
        int addYear=0;
        if(!isWinter && !isWinterEntry) {
            addYear=1;
        }
        for (int i = 0; i <numberOfSemesters/2 + addYear; i++) {
            String year= (i+1)+"";
            years.add(year);
        }
        return years;
    }
    public List<String> getSemesters() {
        boolean isWinter=academicSession.getIsWinter();
        int numberOfSemesters=academicLevel.getNumberOfSemesters();
        boolean isWinterEntry=academicLevel.getIsWinterEntry();
        List<String> semeters= new ArrayList<>();
        int start=1;
        if (! isWinter && isWinterEntry) {
            start=2;
        }
        for (int i = start; i <=numberOfSemesters ; i=+2) {
            semeters.add("s"+i);
        }
        return semeters;
    }

}
