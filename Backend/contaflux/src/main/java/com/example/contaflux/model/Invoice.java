package com.example.contaflux.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@Table(name = "facturas")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaEmision;
    private LocalDate fechaVencimiento;
    private BigDecimal total;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Client client;
}
