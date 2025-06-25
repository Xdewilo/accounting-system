package com.example.contaflux.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "usuarios")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;

    @Column(name = "password_hash")
    private String passwordHash;

    private String rol; // admin, contador...

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Company company;

}
