package co.edu.unisabana.com.subjectsmanager.service.subject;

import java.util.ArrayList;

import co.edu.unisabana.com.subjectsmanager.exception.NoContentException;
import co.edu.unisabana.com.subjectsmanager.repository.SubjectRepository;
import co.edu.unisabana.com.subjectsmanager.repository.dto.SubjectDTO;

public class UpdateSubjectService {
    private SubjectRepository subjectRepository;

    public UpdateSubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public SubjectDTO run(String name, SubjectDTO subject) {
        ArrayList<SubjectDTO> subjectExists = this.subjectRepository.getSubjectByName(name);
        if (subjectExists.isEmpty())
            throw new NoContentException("The subject with name " + name + " was not found");
        SubjectDTO newSubject = new SubjectDTO(name, subject.getCredits(), subject.getProfessor(), subject.getDates());
        return this.subjectRepository.updateByName(newSubject);
    }
}
