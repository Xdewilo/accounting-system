package com.example.contaflux.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pagos_clientes")
public class ClientPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaPago;
    private BigDecimal valor;
    private String metodoPago;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "factura_id")
    private Invoice invoice;

    // Getters and setters
}
