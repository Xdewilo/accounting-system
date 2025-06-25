package com.example.contaflux.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Setter
@Getter
@Table(name = "asientos")
public class JournalEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User user;

}
