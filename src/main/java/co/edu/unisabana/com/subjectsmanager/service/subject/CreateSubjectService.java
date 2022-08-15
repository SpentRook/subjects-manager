package co.edu.unisabana.com.subjectsmanager.service.subject;

import java.util.ArrayList;

import co.edu.unisabana.com.subjectsmanager.exception.AlreadyExistsException;
import co.edu.unisabana.com.subjectsmanager.repository.SubjectRepository;
import co.edu.unisabana.com.subjectsmanager.repository.dto.SubjectDTO;

public class CreateSubjectService {
    private SubjectRepository subjectRepository;

    public CreateSubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public SubjectDTO run(SubjectDTO subject) throws AlreadyExistsException {
        ArrayList<SubjectDTO> subjectExists = subjectRepository.getSubjectByName(subject.getName());
        if (!subjectExists.isEmpty())
            throw new AlreadyExistsException("The subject with name " + subject.getName() + " already exists");
        return subjectRepository.addSubject(subject);
    }
}
