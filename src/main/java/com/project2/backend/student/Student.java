package com.project2.backend.student;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table
public class Student {
    @Id
    private Long id;
    private String name;
    private Boolean female;
    private LocalDate dob;
    private String clazz;
    private String email;
    private Double cpa;

    public Student() {
    }

    public Student(Long id, String name, Boolean female, LocalDate dob, String clazz, String email, Double cpa) {
        this.id = id;
        this.name = name;
        this.female = female;
        this.dob = dob;
        this.clazz = clazz;
        this.email = email;
        this.cpa = cpa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getFemale() {
        return female;
    }

    public void setFemale(Boolean female) {
        this.female = female;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getCpa() {
        return cpa;
    }

    public void setCpa(Double cpa) {
        this.cpa = cpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", female=" + female +
                ", dob=" + dob +
                ", clazz='" + clazz + '\'' +
                ", email='" + email + '\'' +
                ", cpa=" + cpa +
                '}';
    }
}
