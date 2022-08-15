package co.edu.unisabana.com.subjectsmanager.service.subject;

import java.util.ArrayList;

import co.edu.unisabana.com.subjectsmanager.exception.NoContentException;
import co.edu.unisabana.com.subjectsmanager.repository.SubjectRepository;
import co.edu.unisabana.com.subjectsmanager.repository.dto.SubjectDTO;
import co.edu.unisabana.com.subjectsmanager.repository.dto.SubjectDateDTO;

public class UpdateSubjectService {
    private SubjectRepository subjectRepository;

    public UpdateSubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public SubjectDTO run(String name, SubjectDTO subject) {
        ArrayList<SubjectDTO> subjectExists = this.subjectRepository.getSubjectByName(name);
        int validCredits = subject.getCredits() == 0 ? subjectExists.get(0).getCredits() : subject.getCredits();
        String validProfessor = subject.getProfessor() == null ? subjectExists.get(0).getProfessor() : subject.getProfessor();
        ArrayList<SubjectDateDTO> validDates = subject.getDates() == null ? subjectExists.get(0).getDates() : subject.getDates();
        if (subjectExists.isEmpty())
            throw new NoContentException("The subject with name " + name + " was not found");
        SubjectDTO newSubject = new SubjectDTO(name, validCredits, validProfessor , validDates);
        return this.subjectRepository.updateByName(newSubject);
    }
}
