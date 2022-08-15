package co.edu.unisabana.com.subjectsmanager.repository.dto;

import java.util.ArrayList;

import lombok.*;

@Data
@AllArgsConstructor
public class SubjectDTO {
    String name;
    int credits;
    String professor;
    ArrayList<SubjectDateDTO> dates;

    SubjectDTO() {
    }
}