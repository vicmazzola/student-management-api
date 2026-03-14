package com.victor.student_management_api.controller;

import com.victor.student_management_api.dto.StudentCreateRequest;
import com.victor.student_management_api.model.Student;
import com.victor.student_management_api.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student createStudent(@RequestBody StudentCreateRequest request) {
        return studentService.createStudent(request);
    }
}
