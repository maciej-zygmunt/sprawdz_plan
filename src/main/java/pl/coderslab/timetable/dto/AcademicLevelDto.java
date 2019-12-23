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
    private List<String> years;
    private List<String> semesters;

    public AcademicLevelDto(AcademicSession academicSession, AcademicArea academicArea, AcademicLevel academicLevel) {
        this.academicSession = academicSession;
        this.academicArea = academicArea;
        this.academicLevel = academicLevel;
        years=initYears();
        semesters=initSemesters();
    }
    public String semester(Integer i) {
        if(i>=0 && i<semesters.size()) {
            return semesters.get(i);
        }
        return "s"+i;
    }
    private  List<String> initYears() {
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
    private List<String> initSemesters() {
        boolean isWinter=academicSession.getIsWinter();
        int numberOfSemesters=academicLevel.getNumberOfSemesters();
        boolean isWinterEntry=academicLevel.getIsWinterEntry();
        List<String> semeters= new ArrayList<>();
        int start=1;
        if (! isWinter && isWinterEntry) {
            start=2;
        }
        for (int i = start; i <=numberOfSemesters ; i+=2) {
            semeters.add("S"+i);
        }
        return semeters;
    }

}
