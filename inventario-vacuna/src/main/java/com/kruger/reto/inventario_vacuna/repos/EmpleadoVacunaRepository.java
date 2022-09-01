package com.kruger.reto.inventario_vacuna.repos;

import com.kruger.reto.inventario_vacuna.domain.EmpleadoVacuna;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmpleadoVacunaRepository extends JpaRepository<EmpleadoVacuna, Long> {
}
