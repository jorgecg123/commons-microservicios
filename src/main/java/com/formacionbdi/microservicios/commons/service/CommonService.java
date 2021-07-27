package com.formacionbdi.microservicios.commons.service;

import java.util.Optional;


public interface CommonService<E> {

	public Iterable<E> findAll();
	
	public Optional<E> findById(Long id);
	
	public E save(E entity);
	
	public void deleteById(Long id);
}

//public interface AlumnoService {
//
//	public Iterable<Alumno> findAll();
//	
//	public Optional<Alumno> findById(Long id);
//	
//	public Alumno save(Alumno alumno);
//	
//	public void deleteById(Long id);
//}
