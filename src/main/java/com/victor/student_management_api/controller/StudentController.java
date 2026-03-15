package com.victor.student_management_api.controller;

import com.victor.student_management_api.dto.StudentCreateRequest;
import com.victor.student_management_api.model.Student;
import com.victor.student_management_api.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Student> createStudent(@Valid @RequestBody StudentCreateRequest request) {
        Student student = studentService.createStudent(request);
        return ResponseEntity.ok(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/high-grades")
    public ResponseEntity<List<Student>> getStudentsWithGradesAboveEight() {
        return ResponseEntity.ok(studentService.getStudentsWithGradesAboveEight());
    }

    @PutMapping("/{matricula}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable Long matricula,
            @Valid @RequestBody StudentCreateRequest request
    ) {
        Student student = studentService.updateStudent(matricula, request);
        return ResponseEntity.ok(student);
    }
}
