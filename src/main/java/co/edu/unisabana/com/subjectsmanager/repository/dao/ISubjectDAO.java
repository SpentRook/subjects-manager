package co.edu.unisabana.com.subjectsmanager.repository.dao;

import java.util.ArrayList;

import co.edu.unisabana.com.subjectsmanager.repository.dto.SubjectDTO;

public interface ISubjectDAO {
    SubjectDTO createSubject(SubjectDTO subject);

    void deleteSubject(SubjectDTO subject);

    SubjectDTO updateSubject(SubjectDTO subject);

    ArrayList<SubjectDTO> readSubject(String name);

    ArrayList<SubjectDTO> filterByMatchSubject(String name);

    ArrayList<SubjectDTO> filterByParams(String name, int credits, String proffesor);
}
