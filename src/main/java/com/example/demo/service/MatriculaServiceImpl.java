package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.IMateriaRepository;
import com.example.demo.repository.IMatriculaRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.dto.MatriculaDTO;
import com.example.demo.repository.modelo.dto.Matriculardto;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

	@Autowired
	private IMatriculaRepository matriculaRepository;
	
	@Autowired
	private IMateriaRepository materiaRepository;
	
	@Autowired
	private IEstudianteRepository estudianteRepository;
	
	@Transactional(value = TxType.REQUIRED)
	public void matricular(Matriculardto matriculardto) {
		
		Materia mater = new Materia();
		Estudiante estud = new Estudiante();
	    Materia mate1 = this.materiaRepository.seleccionarporCodigo(mater.getCodigo());
	    Estudiante estu = this.estudianteRepository.seleccionarPorCedula(estud.getCedula());
	    List<Matricula> listaMatricula = new ArrayList<>();
	    
	    Materia mate2 = new Materia();
	    mate2.setCodigo(matriculardto.getCodigo2());
	    Matricula matri2= new Matricula();
	    matri2.setMateria(mate2);
	    listaMatricula.add(matri2);
	    
	    Materia mate3 = new Materia();
	    mate3.setCodigo(matriculardto.getCodigo3());
	    Matricula matri3= new Matricula();
	    matri3.setMateria(mate3);
	    listaMatricula.add(matri3);
	    
	    Materia mate4 = new Materia();
	    mate4.setCodigo(matriculardto.getCodigo4());
	    Matricula matri4= new Matricula();
	    matri4.setMateria(mate4);
	    listaMatricula.add(matri4);
	    
	    listaMatricula.parallelStream().forEach((matri) -> {
	        matri.setEstudiante(estu);
	        matri.setMateria(mate1);
	        matri.setFechaMatricula(LocalDateTime.now());
	        matri.setNombreHilo("Hilo");
	        this.matriculaRepository.insertar(matri);
	    });
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public List<MatriculaDTO> buscarDTO() {
		
		return this.matriculaRepository.seleccionarDTO();
	}



}
