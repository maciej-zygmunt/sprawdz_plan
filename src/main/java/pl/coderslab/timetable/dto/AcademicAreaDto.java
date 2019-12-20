package pl.coderslab.timetable.dto;

import lombok.Data;
import pl.coderslab.timetable.model.AcademicArea;

import java.util.List;

@Data
public class AcademicAreaDto {
    private final AcademicArea academicArea;
    private final List<AcademicLevelDto> academicLevelDtoList;
}
