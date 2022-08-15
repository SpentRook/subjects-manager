package co.edu.unisabana.com.subjectsmanager.service.subject;

import java.util.ArrayList;

import co.edu.unisabana.com.subjectsmanager.repository.SubjectRepository;
import co.edu.unisabana.com.subjectsmanager.repository.dto.SubjectDTO;

public class GetAllSubjectsService {
    private SubjectRepository subjectRepository;

    public GetAllSubjectsService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public ArrayList<SubjectDTO> run() {
        return subjectRepository.getAllSubjects();
    }
}
