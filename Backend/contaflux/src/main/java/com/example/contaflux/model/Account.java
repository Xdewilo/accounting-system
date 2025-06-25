package com.example.contaflux.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "cuentas")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private String nombre;
    private String tipo;
    private Integer nivel;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "cuenta_padre_id")
    private Account parentAccount;

    // Getters and setters
}

