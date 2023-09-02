package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.dto.MatriculaDTO;
import com.example.demo.repository.modelo.dto.Matriculardto;

public interface IMatriculaService {
	
	
	
	public void matricular(Matriculardto matriculardto);
	
	
	public List<MatriculaDTO> buscarDTO();
	

}
