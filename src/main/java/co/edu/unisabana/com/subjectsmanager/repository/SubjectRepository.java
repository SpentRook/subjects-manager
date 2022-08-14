package co.edu.unisabana.com.subjectsmanager.repository;

import co.edu.unisabana.com.subjectsmanager.repository.dto.SubjectDTO;

import java.util.ArrayList;

import co.edu.unisabana.com.subjectsmanager.repository.dao.ISubjectDAO;

public class SubjectRepository {
    private ISubjectDAO subjectDB;

    public SubjectRepository(ISubjectDAO subjectDB) {
        this.subjectDB = subjectDB;
    }

    public ArrayList<SubjectDTO> getSubjectByName(String name) {
        return subjectDB.readSubject(name);
    }

    public void deleteByName(String name) {
        subjectDB.deleteSubject(name);
    }

    public SubjectDTO updateByName(String name, SubjectDTO subject) {
        return null;
    }

    public SubjectDTO addSubject(SubjectDTO subject) {
        return subjectDB.createSubject(subject);
    }

    public ArrayList<SubjectDTO> getAllSubjects() {
        return subjectDB.readSubject("");
    }
}
