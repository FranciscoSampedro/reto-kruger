package com.kruger.reto.inventario_vacuna.service;

import com.kruger.reto.inventario_vacuna.domain.Empleado;
import com.kruger.reto.inventario_vacuna.model.EmpleadoDTO;
import com.kruger.reto.inventario_vacuna.repos.EmpleadoRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoService(final EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public List<EmpleadoDTO> findAll() {
        return empleadoRepository.findAll(Sort.by("empId"))
                .stream()
                .map(empleado -> mapToDTO(empleado, new EmpleadoDTO()))
                .collect(Collectors.toList());
    }

    public EmpleadoDTO get(final Long empId) {
        return empleadoRepository.findById(empId)
                .map(empleado -> mapToDTO(empleado, new EmpleadoDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final EmpleadoDTO empleadoDTO) {
        final Empleado empleado = new Empleado();
        mapToEntity(empleadoDTO, empleado);
        return empleadoRepository.save(empleado).getEmpId();
    }

    public void update(final Long empId, final EmpleadoDTO empleadoDTO) {
        final Empleado empleado = empleadoRepository.findById(empId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(empleadoDTO, empleado);
        empleadoRepository.save(empleado);
    }

    public void delete(final Long empId) {
        empleadoRepository.deleteById(empId);
    }

    private EmpleadoDTO mapToDTO(final Empleado empleado, final EmpleadoDTO empleadoDTO) {
        empleadoDTO.setEmpId(empleado.getEmpId());
        empleadoDTO.setEmpCedula(empleado.getEmpCedula());
        empleadoDTO.setEmpNombres(empleado.getEmpNombres());
        empleadoDTO.setEmpApellidos(empleado.getEmpApellidos());
        empleadoDTO.setEmpEmail(empleado.getEmpEmail());
        empleadoDTO.setEmpFechanacimiento(empleado.getEmpFechanacimiento());
        empleadoDTO.setEmpDireccion(empleado.getEmpDireccion());
        empleadoDTO.setEmpTelefono(empleado.getEmpTelefono());
        return empleadoDTO;
    }

    private Empleado mapToEntity(final EmpleadoDTO empleadoDTO, final Empleado empleado) {
        empleado.setEmpCedula(empleadoDTO.getEmpCedula());
        empleado.setEmpNombres(empleadoDTO.getEmpNombres());
        empleado.setEmpApellidos(empleadoDTO.getEmpApellidos());
        empleado.setEmpEmail(empleadoDTO.getEmpEmail());
        empleado.setEmpFechanacimiento(empleadoDTO.getEmpFechanacimiento());
        empleado.setEmpDireccion(empleadoDTO.getEmpDireccion());
        empleado.setEmpTelefono(empleadoDTO.getEmpTelefono());
        return empleado;
    }

}
