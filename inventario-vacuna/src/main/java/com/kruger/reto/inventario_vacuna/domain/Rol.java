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
public class Rol {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long rolId;

        @Column(nullable = false, length = 32)
        private String rolNombre;

        @Column(nullable = false, length = 64)
        private String rolDescripcion;

        @OneToMany(mappedBy = "rol")
        private Set<Usuario> rolUsuarios;

}
