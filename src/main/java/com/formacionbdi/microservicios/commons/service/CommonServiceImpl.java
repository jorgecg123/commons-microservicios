package com.formacionbdi.microservicios.commons.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public class CommonServiceImpl<E,R extends CrudRepository<E,Long>> implements CommonService<E> {
	
	@Autowired
	private R repository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<E> findAll() {

		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<E> findById(Long id) {

		return repository.findById(id);
	}

	@Override
	@Transactional
	public E save(E entity) {

		return repository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {

		repository.deleteById(id);;
	}

}


//public class AlumnoServiceImpl implements AlumnoService {
//	
//	@Autowired
//	private AlumnoRepository repository;
//
//	@Override
//	@Transactional(readOnly = true)
//	public Iterable<Alumno> findAll() {
//
//		return repository.findAll();
//	}
//
//	@Override
//	@Transactional(readOnly = true)
//	public Optional<Alumno> findById(Long id) {
//
//		return repository.findById(id);
//	}
//
//	@Override
//	@Transactional
//	public Alumno save(Alumno alumno) {
//
//		return repository.save(alumno);
//	}
//
//	@Override
//	@Transactional
//	public void deleteById(Long id) {
//
//		repository.deleteById(id);;
//	}
//
//}