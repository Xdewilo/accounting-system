package com.example.contaflux.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "clientes")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String documento;
    private String direccion;
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Company company;

}
