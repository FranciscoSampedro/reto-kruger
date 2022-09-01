package com.kruger.reto.inventario_vacuna.domain;

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
public class Vacuna {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long vacId;

        @Column(nullable = false, length = 32)
        private String vacLote;

        @Column(nullable = false, length = 32)
        private String vacNombre;

        @Column(nullable = false, length = 32)
        private String vacDescripcion;

        @OneToMany(mappedBy = "vac")
        private Set<EmpleadoVacuna> vacEmpleadoVacunas;

}
