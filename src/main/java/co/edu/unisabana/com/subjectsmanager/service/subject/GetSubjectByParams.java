package co.edu.unisabana.com.subjectsmanager.service.subject;

import java.util.ArrayList;

import co.edu.unisabana.com.subjectsmanager.exception.NoContentException;
import co.edu.unisabana.com.subjectsmanager.repository.SubjectRepository;
import co.edu.unisabana.com.subjectsmanager.repository.dto.SubjectDTO;

public class GetSubjectByParams{
    private SubjectRepository subjectRepository;

    public GetSubjectByParams(SubjectRepository subjectRepository){
        this.subjectRepository = subjectRepository;
    }

    public ArrayList<SubjectDTO> run(String name, String credits, String professor) {
        String validName = name != null ? name : "";
        int validCredits = credits != null ? Integer.parseInt(credits) : 0;
        String validProfessor = professor != null ? professor : "";
        ArrayList<SubjectDTO> result = this.subjectRepository.getSubjectByParams(validName, validCredits, validProfessor);
        if (result.isEmpty())
            throw new NoContentException("The subject with the params introduced was not found");
        return result;
    }

}