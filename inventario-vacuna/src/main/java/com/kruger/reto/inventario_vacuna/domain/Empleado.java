package com.kruger.reto.inventario_vacuna.domain;

import java.time.LocalDate;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Empleado {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long empId;

        @Column(nullable = false, length = 10)
        private String empCedula;

        @Column(nullable = false, length = 64)
        private String empNombres;

        @Column(nullable = false, length = 64)
        private String empApellidos;

        @Column(nullable = false, length = 128)
        private String empEmail;

        @Column(nullable = false)
        private LocalDate empFechanacimiento;

        @Column(nullable = false, length = 64)
        private String empDireccion;

        @Column(nullable = false, length = 10)
        private String empTelefono;

        @OneToMany(mappedBy = "emp")
        private Set<EmpleadoVacuna> empEmpleadoVacunas;

        @OneToMany(mappedBy = "emp")
        private Set<Usuario> empUsuarios;

}
