package com.kruger.reto.inventario_vacuna.domain;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class EmpleadoVacuna {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;

        @Column(nullable = false)
        private LocalDate vacFechaVacuna;

        @Column(nullable = false)
        private Integer vacNumDosis;

        @Column(nullable = false, length = 2)
        private String vacEstado;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "vac_id", nullable = false)
        private Vacuna vac;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "emp_id", nullable = false)
        private Empleado emp;

}
