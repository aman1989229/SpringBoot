package com.example.springboot.controller;

import com.example.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
//To add stud as base url for all use @RequestMapping
@RequestMapping("stud")
public class UrlController {

    @GetMapping  //url will be http://localhost:8080/stud
    public List<Student> getStuds() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(2, "blah1", "blah"));
        students.add(new Student(3, "blah2", "blah"));
        return students;
    }

    //Spring Boot REST API with PathVariable passed in URL
    @GetMapping("{id}") //url will be http://localhost:8080/stud/1
    public Student studPathVariable(@PathVariable int id) {
        return (new Student(id, "Ramesh", "PathVariable"));
    }

}