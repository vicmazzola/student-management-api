package com.victor.student_management_api.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_registro_aluno")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Student {

    @Id
    @Column(name = "matricula")
    @EqualsAndHashCode.Include
    @ToString.Include
    private Long matricula;

    @Column(name = "nome", nullable = false)
    private String name;

    @Column(name = "sexo", nullable = false, length = 1)
    private String gender;

    @Column(name = "nascimento", nullable = false)
    private LocalDate birthDate;

    @JsonManagedReference
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudentSubject> subjects = new ArrayList<>();
}