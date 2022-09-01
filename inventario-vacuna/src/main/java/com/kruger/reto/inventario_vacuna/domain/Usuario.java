package com.kruger.reto.inventario_vacuna.domain;

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
public class Usuario {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long usuId;

        @Column(nullable = false, length = 128)
        private String usuUsername;

        @Column(nullable = false, length = 256)
        private String usuPassword;

        @Column(nullable = false, length = 2)
        private String usuEstado;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "emp_id", nullable = false)
        private Empleado emp;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "rol_id", nullable = false)
        private Rol rol;

}
