package co.edu.unisabana.com.subjectsmanager.repository.dto;

import java.util.ArrayList;

import lombok.*;

public class SubjectDTO {
    String name;
    int credits;
    String professor;

    SubjectDTO(String name, int credits, String professor) {
        this.name = name;
        this.credits = credits;
        this.professor = professor;
    }

    public String getName() {
        return this.name;
    }

    public String getProfessor() {
        return this.professor;
    }

    public int getCredits() {
        return this.credits;
    }

    void setName(String name) {
        this.name = name;
    }

    void setProfessor(String professor) {
        this.professor = professor;
    }

    void setCredits(int credits) {
        this.credits = credits;
    }
}
