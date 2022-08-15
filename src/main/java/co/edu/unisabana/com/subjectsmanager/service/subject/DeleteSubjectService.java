package co.edu.unisabana.com.subjectsmanager.service.subject;

import java.util.ArrayList;

import co.edu.unisabana.com.subjectsmanager.exception.NoContentException;
import co.edu.unisabana.com.subjectsmanager.repository.SubjectRepository;
import co.edu.unisabana.com.subjectsmanager.repository.dto.SubjectDTO;

public class DeleteSubjectService {
    private SubjectRepository subjectRepository;

    public DeleteSubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public void run(String name) throws NoContentException {
        ArrayList<SubjectDTO> subjectExist = this.subjectRepository.getSubjectByName(name);
        if (subjectExist.isEmpty())
            throw new NoContentException("The subject with name " + name + " was not found");
        this.subjectRepository.deleteSubject(subjectExist.get(0));
    }
}
