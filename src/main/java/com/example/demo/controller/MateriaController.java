package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.demo.repository.modelo.Materia;
import com.example.demo.service.IMateriaService;

@Controller
@RequestMapping("materias")
public class MateriaController {
	
	@Autowired
	private IMateriaService materiaService;
	
	
	
	@GetMapping("/vistaMateria")
	public String vistaEstudiante(Materia materia) {
	return "vistaMateria";
	}
	
	@PostMapping("/guardar")
	public String guardar(Materia materia) {
		this.materiaService.ingresar(materia);
		return "redirect:/materias/vistaMateria";
	}
}
