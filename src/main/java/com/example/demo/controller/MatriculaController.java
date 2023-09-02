package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.dto.MatriculaDTO;
import com.example.demo.repository.modelo.dto.Matriculardto;
import com.example.demo.service.IMatriculaService;

@Controller
@RequestMapping("matriculas")
public class MatriculaController {

	
	@Autowired
	private IMatriculaService matriculaService;
	
	@GetMapping("/vistaMatricula")
	public String vistaMatricula(Matriculardto matriculardto) {
	return "vistaMatricula";
	}
	
	@PostMapping("/matricular")
	public String matricular(Matriculardto matriculardto) {	
		this.matriculaService.matricular(matriculardto);
		return "redirect:/matriculas/vistaMatricula";	
	}
	
	@GetMapping("/vistaListaMatricula")
	public  String listaMatricula(Model model) {
		List<MatriculaDTO>matriculaDTO= this.matriculaService.buscarDTO();
		model.addAttribute("matriculaDTO",matriculaDTO);
		return "vistaListaMatricula";
		
	}
	


}
