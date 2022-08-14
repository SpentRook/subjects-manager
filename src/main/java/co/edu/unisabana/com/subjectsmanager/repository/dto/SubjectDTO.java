package co.edu.unisabana.com.subjectsmanager.repository.dto;

import java.util.ArrayList;

import lombok.*;

@Data
@AllArgsConstructor
public class SubjectDTO {
    String name;
    int credits;
    ArrayList<SubjectDateDTO> dates;
    String professor;
}