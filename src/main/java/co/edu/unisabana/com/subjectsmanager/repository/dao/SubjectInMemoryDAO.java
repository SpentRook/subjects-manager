package co.edu.unisabana.com.subjectsmanager.repository.dao;

import java.util.ArrayList;
import java.util.stream.Collectors;

import co.edu.unisabana.com.subjectsmanager.repository.dto.SubjectDTO;
import co.edu.unisabana.com.subjectsmanager.repository.dto.SubjectDateDTO;

public class SubjectInMemoryDAO implements ISubjectDAO {
    private ArrayList<SubjectDTO> subjectDB = new ArrayList<SubjectDTO>();

    @Override
    public SubjectDTO createSubject(SubjectDTO subject) {
        subjectDB.add(subject);
        return subjectDB.get(subjectDB.size() - 1);
    }

    @Override
    public void deleteSubject(String name) {

    }

    @Override
    public SubjectDTO updateSubject(SubjectDTO subject) {

        return null;
    }

    @Override
    public ArrayList<SubjectDTO> readSubject(String name) {
        return (ArrayList<SubjectDTO>) this.subjectDB.stream().filter(subject -> name.contains(subject.getName()))
                .collect(Collectors.toList());
    }

}
