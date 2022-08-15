package co.edu.unisabana.com.subjectsmanager.service.subject;

import java.util.ArrayList;

import co.edu.unisabana.com.subjectsmanager.exception.NoContentException;
import co.edu.unisabana.com.subjectsmanager.repository.SubjectRepository;
import co.edu.unisabana.com.subjectsmanager.repository.dto.SubjectDTO;

public class GetByNameSubjectService {
    private SubjectRepository subjectRepository;

    public GetByNameSubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public ArrayList<SubjectDTO> run(String name) {
        ArrayList<SubjectDTO> result = this.subjectRepository.getSubjectByName(name);
        if (result.isEmpty())
            throw new NoContentException("The subject with name " + name + " was not found");
        return result;
    }
}
