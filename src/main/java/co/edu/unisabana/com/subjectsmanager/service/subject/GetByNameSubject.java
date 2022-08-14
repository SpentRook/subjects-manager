package co.edu.unisabana.com.subjectsmanager.service.subject;

import co.edu.unisabana.com.subjectsmanager.repository.SubjectRepository;
import co.edu.unisabana.com.subjectsmanager.repository.dto.SubjectDTO;

public class GetByNameSubject {
    private SubjectRepository subjectRepository;

    public GetByNameSubject(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public SubjectDTO run(String name) {
        return null;
    }
}
