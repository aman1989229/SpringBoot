package com.example.springboot.controller;

import com.example.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent(){
        Student student= new Student(
                1,
                "Aman",
                "Shrivas"
        );
        //student.setId(1);
        //student.setFirstname("Aman");
        //student.setLastname("Shrivas");
        return student;

    }
    @GetMapping("students")
    public List<Student> getStudents(){
        List<Student>students= new ArrayList<>();
        students.add(new Student(2,"blah1","blah"));
        students.add(new Student(3,"blah2","blah"));
        return students;
    }

    //Spring Boot REST API with PathVariable passed in URL
    @GetMapping("students/{id}")
    public Student studentPathVariable(@PathVariable int id){
        return (new Student(id,"Ramesh","PathVariable"));
    }
    @GetMapping("students1/{id}")
    public Student studentPathVariable1(@PathVariable("id") int stid){
        return (new Student(stid,"Ramesh","PathVariable"));
    }
    @GetMapping("students2/{id}/{first-name}/{last-name}")
    public Student studentPathVariable2(@PathVariable("id") int stid,@PathVariable("first-name") String firstname, @PathVariable("last-name") String lastname){
        return (new Student(stid,firstname,lastname));
    }

    //Spring Boot REST API with Request Param
    //http://localhost:8080/students/query?id=1

    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id){
        return (new Student(id,"Ramesh","PathVariable"));
    }
    //http://localhost:8080/students/query1?id=1&firstname=Aman&lastname=Shrivas
    @GetMapping("students/query1")
    public Student studentRequestVariable1(@RequestParam int id,@RequestParam String firstname,@RequestParam String lastname){
        return (new Student(id,firstname,lastname));
    }

    //Spring Boot REST API which handle Post Request and the request Body
    //http://localhost:8080/students/create
    //@PostMapping @RequestBody

    @PostMapping("students/create")
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstname());
        System.out.println(student.getLastname());
        return student;
    }
    @PostMapping("students/create1")
    @ResponseStatus(HttpStatus.CREATED) //it sends status as creted which is 201
    public Student createStudent1(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstname());
        System.out.println(student.getLastname());
        return student;
    }

    //Spring Boot REST API which handle Put Request and the request Body with Request Param
    //http://localhost:8080/students/1/update
    //@PutMapping @ResponseBody

    @PutMapping("students/{id}/update")
    @ResponseStatus(HttpStatus.ACCEPTED) //it sends status as creted which is 201
    public Student createStudent1(@PathVariable int id,@RequestBody Student student){
        student.setId(id);
        System.out.println(student.getId());
        System.out.println(student.getFirstname());
        System.out.println(student.getLastname());
        return student;
    }

    //Spring Boot REST API which handle Delete Request  with Request Param
    //http://localhost:8080/students/1/delete
    //@DeleteMapping @PathVariable

    @DeleteMapping("students/{id}/delete")
    public String deleteStudent(@PathVariable int id){
        System.out.println(id);
        return "User Deleted Successfully";
    }

    //RequestEntity
    @GetMapping("/reqstudent")
    public ResponseEntity<Student> reqStudent(){
        Student student= new Student(
                1,
                "Aman",
                "Shrivas"
        );
        return ResponseEntity.ok().header("custom-header","ramesh").body(student);

    }
    @PostMapping("students/reqcreate")
    public ResponseEntity<Student> reqCreateStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstname());
        System.out.println(student.getLastname());
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }
}
