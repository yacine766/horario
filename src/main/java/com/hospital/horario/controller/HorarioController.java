package com.hospital.horario.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HorarioController {

	@RequestMapping(path="/Hello")
	public String getNombre() {
 log.debug("Hello world");
return "hello world";
	 
	}
}
