package com.kruger.reto.inventario_vacuna.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import com.kruger.reto.inventario_vacuna.domain.EmpleadoVacuna;
import com.kruger.reto.inventario_vacuna.model.EmpleadoVacunaDTO;
import com.kruger.reto.inventario_vacuna.repos.EmpleadoRepository;
import com.kruger.reto.inventario_vacuna.repos.EmpleadoVacunaRepository;
import com.kruger.reto.inventario_vacuna.repos.VacunaRepository;

@Service
public class EmpleadoVacunaService {
    @Autowired
    private EmpleadoVacunaRepository empleadoVacunaRepository;
    private EmpleadoRepository empleadoRepository;
    private VacunaRepository vacunaRepository;
    @Autowired
    private ModelMapper modelMapper;

    // public Long create(final EmpleadoVacunaDTO empleadoVacunaDTO) {
    // final EmpleadoVacuna empleadoVacuna = new EmpleadoVacuna();
    // mapToEntity(empleadoVacunaDTO, empleadoVacuna);
    // return empleadoVacunaRepository.save(empleadoVacuna).getId();
    // }

    public List<EmpleadoVacunaDTO> findAll() {
        return empleadoVacunaRepository.findAll(Sort.by("id"))
                .stream()
                .map(empleadoVacuna -> convertEntityToDto(empleadoVacuna))
                .collect(Collectors.toList());
    }

    // private EmpleadoVacuna mapToEntity(final EmpleadoVacunaDTO empleadoVacunaDTO,
    // final EmpleadoVacuna empleadoVacuna) {
    // empleadoVacuna.setEmp(empleadoRepository.findById(empleadoVacunaDTO.getIdEmpleado()).get());
    // empleadoVacuna.setVac(vacunaRepository.findById(empleadoVacunaDTO.getIdVacuna()).get());
    // empleadoVacuna.setVacEstado(empleadoVacunaDTO.getVacEstado());
    // empleadoVacuna.setVacFechaVacuna(empleadoVacunaDTO.getFechaVacunacion());
    // empleadoVacuna.setVacNumDosis(empleadoVacunaDTO.getNumeroDosis());
    // return empleadoVacuna;
    // }

    // private EmpleadoVacunaDTO mapToDTO(final EmpleadoVacuna empleadoVacuna, final
    // EmpleadoVacunaDTO empleadoVacunaDTO) {
    // empleadoVacunaDTO.setFechaVacunacion(fechaVacunacion);
    // return empleadoVacunaDTO;
    // }
    @Transactional
    private EmpleadoVacunaDTO convertEntityToDto(final EmpleadoVacuna empleadoVacuna) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        EmpleadoVacunaDTO empleadoVacunaDTO = new EmpleadoVacunaDTO();
        empleadoVacunaDTO = modelMapper.map(empleadoVacuna, EmpleadoVacunaDTO.class);
        return empleadoVacunaDTO;
    }

}
