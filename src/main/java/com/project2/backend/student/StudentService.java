package com.project2.backend.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentById = studentRepository.findById(student.getId());
        if(studentById.isPresent()){
            throw new IllegalStateException("id " + student.getId() + " taken!");
        }
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()){
            throw new IllegalStateException("email " + student.getEmail() + " taken!");
        }

        studentRepository.save(student);
    }

    public void deleteStudent(Long studentID) {
        boolean exists = studentRepository.existsById(studentID);
        if(!exists){
            throw new IllegalStateException("Student with id " + studentID + " does not exists.");
        }

        studentRepository.deleteById(studentID);
    }

    @Transactional
    public void updateStudent(Long studentID, String name, Boolean female, LocalDate dob, String clazz, String email, Double cpa) {
        Student student = studentRepository.findById(studentID)
                .orElseThrow(() -> new IllegalStateException("Student with id " + studentID + " does not exists."));

        if(name != null && name.length() > 0 && !Objects.equals(name, student.getName())){
            student.setName(name);
        }

        if(female != null && !Objects.equals(student.getFemale(), female)){
            student.setFemale(female);
        }

        if(dob != null && !Objects.equals(student.getDob(), dob)){
            student.setDob(dob);
        }
        if(clazz != null && clazz.length() > 0 && !Objects.equals(student.getClazz(), clazz)){
            student.setClazz(clazz);
        }

        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email "+ email +" taken");
            }
            student.setEmail(email);
        }

        if(cpa != null && cpa != student.getCpa()){
            student.setCpa(cpa);
        }

    }
}
