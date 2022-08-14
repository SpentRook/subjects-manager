package co.edu.unisabana.com.subjectsmanager.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unisabana.com.subjectsmanager.repository.SubjectRepository;
import co.edu.unisabana.com.subjectsmanager.repository.dao.SubjectInMemoryDAO;
import co.edu.unisabana.com.subjectsmanager.repository.dto.SubjectDTO;
import co.edu.unisabana.com.subjectsmanager.repository.dto.SubjectDateDTO;
import co.edu.unisabana.com.subjectsmanager.service.subject.CreateSubject;
import co.edu.unisabana.com.subjectsmanager.service.subject.GetByNameSubject;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @GetMapping
    public String listSubjects() {
        return "HOLA";
    }

    @PostMapping
    public SubjectDTO createSubject(@RequestBody SubjectDTO subject) {
        return subject;
        // CreateSubject createSubjectService = new CreateSubject(new
        // SubjectRepository(new SubjectInMemoryDAO()));
        // try {
        // return createSubjectService.run(subject);
        // } catch (Exception e) {
        // System.out.println("Se arrojo un error" + e.getStackTrace());
        // return null;
        // }
    }

    // @GetMapping("/subject/{name}")
    // public SubjectDTO getSubjectByName(@PathVariable String name) {
    // return GetByNameSubject()
    // }

    /*
     * @PutMapping("/{name}")
     * public SubjectDTO updateSubject(@PathVariable String name, @RequestBody
     * SubjectDTO subject) {
     * GetByNameSubject getByNameSubjectService = new GetByNameSubject();
     * SubjectDTO currentSubject = GetByNameSubject.run(name);
     * return null;
     * }
     */
}
