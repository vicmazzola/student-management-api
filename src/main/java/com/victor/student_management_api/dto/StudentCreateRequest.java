package com.victor.student_management_api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record StudentCreateRequest(
        @NotNull
        Long matricula,

        @NotBlank
        String name,

        @NotBlank
        String gender,

        @NotNull
        LocalDate birthDate,

        List<@Valid StudentSubjectRequest> subjects
) {

}
