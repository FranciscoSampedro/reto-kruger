package com.kruger.reto.inventario_vacuna.repos;

import com.kruger.reto.inventario_vacuna.domain.Vacuna;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacunaRepository extends JpaRepository<Vacuna, Long> {
}
