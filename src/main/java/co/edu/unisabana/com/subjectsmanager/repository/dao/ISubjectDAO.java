package co.edu.unisabana.com.subjectsmanager.repository.dao;

import co.edu.unisabana.com.subjectsmanager.repository.dto.SubjectDTO;

public interface ISubjectDAO {
    SubjectDTO createSubject(SubjectDTO subject);

    void deleteSubject(String name);

    SubjectDTO updateSubject(SubjectDTO subject);

    SubjectDTO readSubject(String name);
}
