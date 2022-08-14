package co.edu.unisabana.com.subjectsmanager.repository.dao;

import java.util.ArrayList;

import co.edu.unisabana.com.subjectsmanager.repository.dto.SubjectDTO;

public class SubjectInMemoryDAO implements ISubjectDAO {
    private ArrayList<SubjectDTO> subjectDB;

    @Override
    public SubjectDTO createSubject(SubjectDTO subject) {
        return null;
    }

    @Override
    public void deleteSubject(String name) {

    }

    @Override
    public SubjectDTO updateSubject(SubjectDTO subject) {
        return null;
    }

    @Override
    public SubjectDTO readSubject(String name) {
        return null;
    }

}
