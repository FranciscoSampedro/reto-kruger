package com.kruger.reto.inventario_vacuna.repos;

import com.kruger.reto.inventario_vacuna.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
