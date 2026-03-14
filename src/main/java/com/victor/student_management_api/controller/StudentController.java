package com.victor.student_management_api.controller;

import com.victor.student_management_api.dto.StudentCreateRequest;
import com.victor.student_management_api.model.Student;
import com.victor.student_management_api.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/high-grades")
    public List<Student> getStudentsWithGradesAboveEight() {
        return studentService.getStudentsWithGradesAboveEight();
    }

    @PutMapping("/{matricula}")
    public Student updateStudent(@PathVariable Long matricula, @RequestBody StudentCreateRequest request) {
        return studentService.updateStudent(matricula, request);
    }
}
