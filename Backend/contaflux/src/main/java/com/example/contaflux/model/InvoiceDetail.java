package com.example.contaflux.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Setter
@Getter
@Table(name = "factura_detalles")
public class InvoiceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private Integer cantidad;
    private BigDecimal valorUnitario;
    private BigDecimal subtotal;

    @ManyToOne
    @JoinColumn(name = "factura_id")
    private Invoice invoice;

}

