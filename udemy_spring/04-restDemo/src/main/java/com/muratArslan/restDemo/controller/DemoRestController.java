package com.muratArslan.restDemo.controller;

import com.muratArslan.restDemo.entity.Student;
import com.muratArslan.restDemo.errors.StudentErrorResponse;
import com.muratArslan.restDemo.errors.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class DemoRestController {

    private List<Student> students;

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @PostConstruct
    public void loadData(){
        students=new ArrayList<>();
        students.add(new Student("Murat","Arslan"));
        students.add(new Student("Kılıcalp","Arslan"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    @GetMapping("/student/{studentId}")
    public Student getstudent(@PathVariable int studentId){
        if(studentId>students.size() || studentId<0){
            throw new StudentNotFoundException("Student id not found: "+studentId );
        }
        return students.get(studentId);
    }

}
