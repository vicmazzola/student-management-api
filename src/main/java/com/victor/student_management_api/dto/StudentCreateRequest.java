package com.victor.student_management_api.dto;

import java.time.LocalDate;
import java.util.List;

public record StudentCreateRequest(
        Long matricula,
        String name,
        String gender,
        LocalDate birthDate,
        List<StudentSubjectRequest> subjects
) {

}
