package com.kruger.reto.inventario_vacuna.model;

import java.time.LocalDate;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpleadoVacunaDTO {
    private EmpleadoDTO empleado;

    private VacunaDTO vacuna;
    @Size(max = 2)
    private String vacEstado;
    private long id;

    private LocalDate fechaVacunacion;

    private Integer numeroDosis;

}
