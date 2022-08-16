package co.edu.unisabana.com.subjectsmanager.repository.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class SubjectDateDTO {
    Days day;
    String classroom;
    String startHour;
    String endHour;

    SubjectDateDTO() {
    }
}

