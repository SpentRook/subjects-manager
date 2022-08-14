package co.edu.unisabana.com.subjectsmanager.repository;

import co.edu.unisabana.com.subjectsmanager.repository.dto.SubjectDTO;
import co.edu.unisabana.com.subjectsmanager.repository.dao.ISubjectDAO;

public class SubjectRepository {
    private ISubjectDAO subjectDB;

    SubjectRepository(ISubjectDAO subjectDB) {
        this.subjectDB = subjectDB;
    }

    SubjectDTO getSubjectByName(String name) {
        return subjectDB.readSubject(name);
    }

    void deleteByName(String name) {
        subjectDB.deleteSubject(name);
    }

    SubjectDTO updateByName(String name, SubjectDTO subject) {
        return null;
    }

    SubjectDTO addSUbject(SubjectDTO subject) {
        return subjectDB.createSubject(subject);
    }
}
