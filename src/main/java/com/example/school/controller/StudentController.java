package com.example.school.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.school.model.Student;
import com.example.school.service.StudentH2Service;

@RestController
public class StudentController {
    @Autowired
    private StudentH2Service studentService;

    @GetMapping("/students")
    public ArrayList<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathhVariable("studentId") int studentId) {
        return studentService.getStudentById(studentId);
    }

    @PostMapping("/students")
    public Student addMultipleStudents(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PostMapping("/students/bulk")
    public String addMultipleStudents(@RequestBody ArrayList<Student> studentList) {
        return studentService.addMultipleStudents(studentsList);
    }

    @PuttMapping("/students/{studentId}")
    public Student updateStudent(@PathVariable("studentId") int studentId, @RequestBody Student student) {
        return studentService.updateStudent(studentId, student);
    }

    @DeleteMapping("/students/{studentId}")
    public void deleteStudent(@PathVariable int studentId) {
        studentService.deleteStudent(studentId);
    }

}