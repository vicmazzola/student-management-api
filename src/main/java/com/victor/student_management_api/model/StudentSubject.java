package com.victor.student_management_api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_aluno_materias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class StudentSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @ToString.Include
    private Long id;

    @Column(name = "materia", nullable = false)
    private String subject;

    @Column(name = "nota_final", nullable = false)
    private Integer grade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "matricula", nullable = false)
    private Student student;
}