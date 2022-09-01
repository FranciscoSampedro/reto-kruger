package com.kruger.reto.inventario_vacuna.rest;

import com.kruger.reto.inventario_vacuna.model.EmpleadoDTO;
import com.kruger.reto.inventario_vacuna.service.EmpleadoService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/empleados", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmpleadoResource {

    private final EmpleadoService empleadoService;

    public EmpleadoResource(final EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoDTO>> getAllEmpleados() {
        return ResponseEntity.ok(empleadoService.findAll());
    }

    @GetMapping("/{empId}")
    public ResponseEntity<EmpleadoDTO> getEmpleado(@PathVariable final Long empId) {
        return ResponseEntity.ok(empleadoService.get(empId));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createEmpleado(@RequestBody @Valid final EmpleadoDTO empleadoDTO) {
        return new ResponseEntity<>(empleadoService.create(empleadoDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{empId}")
    public ResponseEntity<Void> updateEmpleado(@PathVariable final Long empId,
            @RequestBody @Valid final EmpleadoDTO empleadoDTO) {
        empleadoService.update(empId, empleadoDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{empId}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteEmpleado(@PathVariable final Long empId) {
        empleadoService.delete(empId);
        return ResponseEntity.noContent().build();
    }

}
