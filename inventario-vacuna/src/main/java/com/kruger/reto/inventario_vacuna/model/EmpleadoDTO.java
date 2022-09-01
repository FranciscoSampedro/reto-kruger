package com.kruger.reto.inventario_vacuna.model;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpleadoDTO {

    private Long empId;

    @NotNull
    @Size(max = 10)
    private String empCedula;

    @NotNull
    @Size(max = 64)
    private String empNombres;

    @NotNull
    @Size(max = 64)
    private String empApellidos;

    @NotNull
    @Size(max = 128)
    private String empEmail;

    @NotNull
    private LocalDate empFechanacimiento;

    @NotNull
    @Size(max = 64)
    private String empDireccion;

    @NotNull
    @Size(max = 10)
    private String empTelefono;

}
