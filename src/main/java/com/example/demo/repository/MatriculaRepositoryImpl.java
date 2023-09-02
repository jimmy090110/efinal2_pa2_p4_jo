package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.dto.MatriculaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class MatriculaRepositoryImpl implements IMatriculaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Matricula matriculas) {
		this.entityManager.persist(matriculas);
		
	}
	
	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<MatriculaDTO> seleccionarDTO() {
		TypedQuery<MatriculaDTO>query= this.entityManager.createQuery("Select new com.example.demo.repository.modelo.dto.MatriculaDTO(m.estudiante.cedula,m.materia.codigo,m.fechaMatricula,m.nombreHilo) from Matricula m",MatriculaDTO.class);
		return query.getResultList();
	}

}
