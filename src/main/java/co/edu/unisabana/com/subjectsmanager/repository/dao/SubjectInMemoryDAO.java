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
    public void deleteSubject(SubjectDTO subject) {
        subjectDB.remove(subject);
    }

    @Override
    public SubjectDTO updateSubject(SubjectDTO subject) {
        ArrayList<SubjectDTO> currentSubject = this.readSubject(subject.getName());
        int indexCurrentSubject = subjectDB.indexOf(currentSubject.get(0));
        subjectDB.set(indexCurrentSubject, subject);
        return subjectDB.get(indexCurrentSubject);
    }

    @Override
    public ArrayList<SubjectDTO> readSubject(String name) {
        return this.subjectDB.stream().filter(subject -> subject.getName().equals(name))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public ArrayList<SubjectDTO> filterByMatchSubject(String name) {
        return this.subjectDB.stream().filter(subject -> subject.getName().contains(name))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public ArrayList<SubjectDTO> filterByParams(String name, int credits, String professor) {
        if(credits != 0){
            return this.subjectDB.stream().filter(subject -> subject.getName().contains(name) && subject.getCredits() == credits && subject.getProfessor().contains(professor))
                .collect(Collectors.toCollection(ArrayList::new));
        }
        return this.subjectDB.stream().filter(subject -> subject.getName().contains(name) && subject.getCredits() >= credits && subject.getProfessor().contains(professor))
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
