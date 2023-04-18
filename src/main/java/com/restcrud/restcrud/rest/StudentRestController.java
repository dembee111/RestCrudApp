package com.restcrud.restcrud.rest;

import com.restcrud.restcrud.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    //define @PostConstruct to load the student data .... only once
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Dembee", "Munkhuu"));
        theStudents.add(new Student("Ijilee", "Tumee"));
        theStudents.add(new Student("Gegee", "Dembee"));
    }
    //define endpoint for "/students" return a list of students
    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> theStudents = new ArrayList<>();
        theStudents.add(new Student("Dembee", "Munkhuu"));
        theStudents.add(new Student("Ijilee", "Tumee"));
        theStudents.add(new Student("Gegee", "Dembee"));
        return theStudents;
    }

    //define endpoint or "/students/{studentId}" - return student
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        if((studentId >= theStudents.size()) || (studentId < 0)){
            throw new StudentNotFoundExpection("Student id not found - " + studentId);
        }
        return theStudents.get(studentId);

    }
}
