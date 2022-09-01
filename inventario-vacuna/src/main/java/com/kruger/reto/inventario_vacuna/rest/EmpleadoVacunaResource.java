package com.kruger.reto.inventario_vacuna.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import com.kruger.reto.inventario_vacuna.model.EmpleadoVacunaDTO;
import com.kruger.reto.inventario_vacuna.service.EmpleadoVacunaService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping(value = "/api/empleados-vacuna", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmpleadoVacunaResource {
    @Autowired
    EmpleadoVacunaService empleadoVacunaService;

    @GetMapping
    public ResponseEntity<List<EmpleadoVacunaDTO>> getAllEmpleados() {
        return ResponseEntity.ok(empleadoVacunaService.findAll());
    }
    // @PostMapping
    // @ApiResponse(responseCode = "201")
    // public ResponseEntity<Long> createEmpleadoVacuna(@RequestBody @Valid final
    // EmpleadoVacunaDTO empleadoVacunaDTO) {
    // return new ResponseEntity<>(empleadoVacunaService.create(empleadoVacunaDTO),
    // HttpStatus.CREATED);
    // }

}
