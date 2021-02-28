package com.hospital.horario.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hospital.horario.entity.Horario;
import com.hospital.horario.exeption.HorarioException;
import com.hospital.horario.repository.HorarioRepository;

import antlr.collections.List;

@Service
public class HorarioService {
	@Autowired
	public HorarioRepository horarioRepository;

	public Horario addNewHorario(Horario horario) {
 
		return horarioRepository.save(horario);
	}

	public void deleteHorario(Long horarioId) {
		if(!existeHorario(horarioId)) {
			throw new HorarioException("El horario que quieres borrar no existe ");
		}
		Horario horario = horarioRepository.getOne(horarioId);
		horarioRepository.delete(horario);
	}

/*	public List<Horario> getAllHorarios() {
		List<Horario> listaCliente = horarioRepository.findAll();

		return horarioRepository.findAll();
	}*/

	public Horario updateHorario(Horario horario) {
	 
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
