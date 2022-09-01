package com.kruger.reto.inventario_vacuna.repos;

import com.kruger.reto.inventario_vacuna.domain.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}
