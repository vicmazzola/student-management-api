package com.victor.student_management_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record StudentSubjectRequest(

        @NotBlank
        String subject,

        @NotNull
        Integer grade
) {
}
