package co.edu.unisabana.com.subjectsmanager.service.subject;

import java.util.ArrayList;

import co.edu.unisabana.com.subjectsmanager.exception.AlreadyExistsException;
import co.edu.unisabana.com.subjectsmanager.exception.ConflictWithExistingSubject;
import co.edu.unisabana.com.subjectsmanager.repository.SubjectRepository;
import co.edu.unisabana.com.subjectsmanager.repository.dto.Days;
import co.edu.unisabana.com.subjectsmanager.repository.dto.SubjectDTO;
import co.edu.unisabana.com.subjectsmanager.repository.dto.SubjectDateDTO;

public class CreateSubjectService {
    private SubjectRepository subjectRepository;

    public CreateSubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    private boolean interferesWithDates(ArrayList<SubjectDTO> allSubjects, SubjectDTO subject){
        
        for(SubjectDateDTO date: subject.getDates()){
            Days currentDay = date.getDay();
            String currentClassroom = date.getClassroom();
            int currentStartHour = Integer.parseInt(date.getStartHour().split(":")[0]);
            for(SubjectDTO dbSubject: allSubjects){
                for(SubjectDateDTO dbDate: dbSubject.getDates()){
                    Days dbDay = dbDate.getDay();
                    String dbClassroom = dbDate.getClassroom();
                    int dbStartHour = Integer.parseInt(dbDate.getStartHour().split(":")[0]);
                    int dbEndHour = Integer.parseInt(dbDate.getEndHour().split(":")[0]);
                    if(dbDay.equals(currentDay) && dbClassroom.equals(currentClassroom) && ( currentStartHour >= dbStartHour && currentStartHour < dbEndHour)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public SubjectDTO run(SubjectDTO subject) throws AlreadyExistsException {
        ArrayList<SubjectDTO> subjectExists = subjectRepository.getSubjectByName(subject.getName());
        ArrayList<SubjectDTO> allSubjects = subjectRepository.getAllSubjects();
        if (!subjectExists.isEmpty())
            throw new AlreadyExistsException("The subject with name " + subject.getName() + " already exists");
        if(interferesWithDates(allSubjects, subject))
            throw new ConflictWithExistingSubject("The subject with name " + subject.getName() + " interferes with another existing subject");
        return subjectRepository.addSubject(subject);
    }
}
