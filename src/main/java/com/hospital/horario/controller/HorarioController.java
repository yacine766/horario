package com.hospital.horario.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.horario.entity.Horario;
import com.hospital.horario.service.HorarioService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HorarioController {
	@Autowired
	public HorarioService horarioService;

	// Lista de todos los horarios

	@RequestMapping("/allhorarios")
	public List<Horario> getAllHorarios() {
		
		return horarioService.getAllHorarios();
	}
	
	//devolver horario en concreto
	@RequestMapping(path="/horario/{horarioId}",method =RequestMethod .GET)
	public Horario getHorario(@PathVariable  long  horarioId) {
		return horarioService .getHorario(horarioId);
	
	}
	
	//Insert Horario en base de datos
	@RequestMapping (path="/horario",method = RequestMethod .POST)
	public ResponseEntity<Horario>  insertNewHorario(@RequestBody Horario horario ) {
		Horario hora = horarioService .addNewHorario(horario);
		return new ResponseEntity<>(hora,HttpStatus.CREATED);
	}
	
	//delete un horario de la BD
	@RequestMapping (path="/horario/{horarioid}",method = RequestMethod.DELETE)
	public void deleteHorario(@PathVariable long horarioid) {
		horarioService .deleteHorario(horarioid);
	}
	@RequestMapping(path ="/horario/{horarioId}", method=RequestMethod.PUT)
	 public void updateCliente(@PathVariable Long horarioId,@RequestBody Horario horario) {
	  horarioService.updateHorario(horario);
	}
}
