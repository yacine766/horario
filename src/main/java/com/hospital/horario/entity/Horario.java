package com.hospital.horario.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
	private String Horario;
}
