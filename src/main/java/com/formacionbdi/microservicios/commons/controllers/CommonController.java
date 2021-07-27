package com.formacionbdi.microservicios.commons.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.microservicios.commons.service.CommonService;


@RestController
public class CommonController<E, S extends CommonService<E>> {

	@Autowired
	protected S service;

	@GetMapping
	public ResponseEntity<?> listar() {

		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> detalle(@PathVariable Long id) {
		Optional<E> o = service.findById(id);
		if (o.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.ok().body(o.get());
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody E entity) {
		E entitydb = service.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(entitydb);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		service.deleteById(id);

		return ResponseEntity.noContent().build();
	}

}

//@RestController
//public class CommonController {
//
//	@Autowired
//	private AlumnoService service;
//
//	@GetMapping
//	public ResponseEntity<?> listar() {
//
//		return ResponseEntity.ok().body(service.findAll());
//	}
//
//	@GetMapping("/{id}")
//	public ResponseEntity<?> detalle(@PathVariable Long id) {
//		Optional<Alumno> o = service.findById(id);
//		if (o.isEmpty()) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//		}
//		return ResponseEntity.ok().body(o.get());
//	}
//
//	@PostMapping
//	public ResponseEntity<?> crear(@RequestBody Alumno alumno) {
//		Alumno alumnodb = service.save(alumno);
//		return ResponseEntity.status(HttpStatus.CREATED).body(alumnodb);
//	}
//
//	@PutMapping("/{id}")
//	public ResponseEntity<?> editar(@RequestBody Alumno alumno, @PathVariable Long id) {
//		Optional<Alumno> o = service.findById(id);
//		if (o.isEmpty()) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//		}
//
//		Alumno alumnodb = o.get();
//		alumnodb.setNombre(alumno.getNombre());
//		alumnodb.setApellido(alumno.getApellido());
//		alumnodb.setEmail(alumno.getEmail());
//
//		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnodb));
//	}
//
//	@DeleteMapping("/{id}")
//	public ResponseEntity<?> eliminar(@PathVariable Long id) {
//		service.deleteById(id);
//
//		return ResponseEntity.noContent().build();
//	}
//
//}
