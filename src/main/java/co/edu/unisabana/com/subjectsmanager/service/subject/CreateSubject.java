package co.edu.unisabana.com.subjectsmanager.service.subject;

import java.util.ArrayList;

import co.edu.unisabana.com.subjectsmanager.repository.SubjectRepository;
import co.edu.unisabana.com.subjectsmanager.repository.dto.SubjectDTO;

public class CreateSubject {
    private SubjectRepository subjectRepository;

    public CreateSubject(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public SubjectDTO run(SubjectDTO subject) throws Exception {
        ArrayList<SubjectDTO> subjectExists = subjectRepository.getSubjectByName(subject.getName());
        if (subjectExists != null)
            throw new Exception("Ya existe");
        return subjectRepository.addSubject(subject);
    }
}
