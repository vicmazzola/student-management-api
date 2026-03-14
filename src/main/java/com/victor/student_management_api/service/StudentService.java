package com.victor.student_management_api.service;

import com.victor.student_management_api.dto.StudentCreateRequest;
import com.victor.student_management_api.dto.StudentSubjectRequest;
import com.victor.student_management_api.model.Student;
import com.victor.student_management_api.model.StudentSubject;
import com.victor.student_management_api.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(StudentCreateRequest request) {

        Student student = new Student();
        student.setMatricula(request.matricula());
        student.setName(request.name());
        student.setGender(request.gender());
        student.setBirthDate(request.birthDate());

        if (request.subjects() != null) {
            for (StudentSubjectRequest subjectRequest : request.subjects()) {

                StudentSubject subject = new StudentSubject();

                subject.setSubject(subjectRequest.subject());
                subject.setGrade(subjectRequest.grade());
                subject.setStudent(student);
                student.getSubjects().add(subject);
            }
        }

        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
