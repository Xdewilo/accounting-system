package com.example.contaflux.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "empresas")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String nit;
    private String direccion;
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "plan_suscripcion_id")
    private SubscriptionPlan planSuscripcion;

}
