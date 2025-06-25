package com.example.contaflux.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "asiento_detalles")
public class JournalDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal debito;
    private BigDecimal credito;

    @ManyToOne
    @JoinColumn(name = "asiento_id")
    private JournalEntry journalEntry;

    @ManyToOne
    @JoinColumn(name = "cuenta_id")
    private Account account;

}
