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

    public void deleteSubject(SubjectDTO subject) {
        subjectDB.deleteSubject(subject);
    }

    public SubjectDTO updateByName(SubjectDTO subject) {
        return subjectDB.updateSubject(subject);
    }

    public SubjectDTO addSubject(SubjectDTO subject) {
        return subjectDB.createSubject(subject);
    }

    public ArrayList<SubjectDTO> getAllSubjects() {
        return subjectDB.filterByMatchSubject("");
    }
}
