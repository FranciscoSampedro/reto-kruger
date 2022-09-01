package com.kruger.reto.inventario_vacuna.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VacunaDTO {
    private Long Id;
    private String vacLote;
    private String vacNombre;
    private String vacDescripcion;
}
