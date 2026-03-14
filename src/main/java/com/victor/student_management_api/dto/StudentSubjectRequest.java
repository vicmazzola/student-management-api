package com.victor.student_management_api.dto;

public record StudentSubjectRequest(
        String subject,
        Integer grade
) {
}
