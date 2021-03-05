package com.hospital.horario.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.horario.entity.Horario;
import com.hospital.horario.exeption.HorarioException;
import com.hospital.horario.repository.HorarioRepository;

import java.util.List;

@Service
public class HorarioService {
	@Autowired
	public HorarioRepository horarioRepository;

	public Horario addNewHorario(Horario horario) {

		return horarioRepository.save(horario);
	}

	public void deleteHorario(Long horarioId) {
		if (!existeHorario(horarioId)) {
			throw new HorarioException("El horario que quieres borrar no existe ");
		}
 
	horarioRepository.deleteById(horarioId);
	}
	public Horario getHorario(long horarioId) {
		if (!existeHorario(horarioId)) {
			throw new HorarioException("el horario que buscas no existe");
						
		}
		return horarioRepository .getOne(horarioId);
	}

	public List<Horario> getAllHorarios() {
		List<Horario> horarios = horarioRepository.findAll();
		if (horarios.isEmpty()) {
			throw new HorarioException("No existe ninguna lista");
		}

		return horarios;
	}

	public Horario updateHorario(Horario horario) {

		if (!existeHorario(horario.getIdHorario())) {
			throw new HorarioException("el horario que quieres modificar no existe");
		}

		return horarioRepository.save(horario);
	}

	public Boolean existeHorario(Long horarioId) {

		Optional<Horario> horario = horarioRepository.findById(horarioId);
		if (horario.isEmpty()) {
			return false;
		}
		return true;

	}

}
