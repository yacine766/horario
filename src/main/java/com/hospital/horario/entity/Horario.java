package com.hospital.horario.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.hospital.horario.utils.Constantes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Horario {
	@Id
	@GeneratedValue
	private long idHorario;
	
	@Column(name = "horario", nullable = false)
	@NotBlank(message = Constantes.horario)
	@Size(min=3 , message = "ojo!!!")
	private String horario;
}
