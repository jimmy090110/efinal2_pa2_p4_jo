package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.dto.MatriculaDTO;

public interface IMatriculaRepository {
	
	public void insertar(Matricula matriculas);
	
	public  List<MatriculaDTO> seleccionarDTO();

}
