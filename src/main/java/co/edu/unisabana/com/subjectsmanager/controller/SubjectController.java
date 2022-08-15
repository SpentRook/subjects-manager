package co.edu.unisabana.com.subjectsmanager.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unisabana.com.subjectsmanager.repository.SubjectRepository;
import co.edu.unisabana.com.subjectsmanager.repository.dao.SubjectInMemoryDAO;
import co.edu.unisabana.com.subjectsmanager.repository.dto.SubjectDTO;
import co.edu.unisabana.com.subjectsmanager.repository.dto.SubjectDateDTO;
import co.edu.unisabana.com.subjectsmanager.service.subject.CreateSubjectService;
import co.edu.unisabana.com.subjectsmanager.service.subject.DeleteSubjectService;
import co.edu.unisabana.com.subjectsmanager.service.subject.GetAllSubjectsService;
import co.edu.unisabana.com.subjectsmanager.service.subject.GetByNameSubjectService;
import co.edu.unisabana.com.subjectsmanager.service.subject.GetSubjectByParams;
import co.edu.unisabana.com.subjectsmanager.service.subject.UpdateSubjectService;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private SubjectRepository subjectRepository = new SubjectRepository(new SubjectInMemoryDAO());

    @GetMapping
    public ArrayList<SubjectDTO> getSubjectslistSubjects() {
        GetAllSubjectsService getAllSubjectsService = new GetAllSubjectsService(subjectRepository);
        return getAllSubjectsService.run();
    }
    
    @GetMapping("/{name}")
    public ArrayList<SubjectDTO> getSubjectByName(@PathVariable String name) {
        GetByNameSubjectService getByNameSubjectService = new GetByNameSubjectService(subjectRepository);
        return getByNameSubjectService.run(name);
    }

    @GetMapping("/filter")
    public ArrayList<SubjectDTO> filterSubjects(@RequestParam Map<String, String> filter ){
        GetSubjectByParams getSubjectByParams = new GetSubjectByParams(subjectRepository); 
        return getSubjectByParams.run(filter.get("name"), filter.get("credits"), filter.get("professor"));
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public SubjectDTO createSubject(@RequestBody SubjectDTO subject) {
        CreateSubjectService createSubjectService = new CreateSubjectService(subjectRepository);
        return createSubjectService.run(subject);

    }

    @DeleteMapping("/{name}")
    public void deleteSubject(@PathVariable String name) {
        DeleteSubjectService deleteSubjectService = new DeleteSubjectService(subjectRepository);
        deleteSubjectService.run(name);
    }
    

    @PutMapping("/{name}")
    public SubjectDTO updateSubject(@PathVariable String name, @RequestBody SubjectDTO subject) {
        UpdateSubjectService updateSubjectService = new UpdateSubjectService(subjectRepository);
        return updateSubjectService.run(name, subject);
    }
}
