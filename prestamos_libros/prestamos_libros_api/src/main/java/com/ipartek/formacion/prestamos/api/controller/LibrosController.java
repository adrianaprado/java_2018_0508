package com.ipartek.formacion.prestamos.api.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.prestamos_libros.pojo.Libro;
import com.ipartek.formacion.prestamos_libros.service.ServiceLibro;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags= {"LIBROS"}, produces="application/json", description="Gestión de Libros")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/libros")
public class LibrosController {
	
	private final static Logger LOG = Logger.getLogger(LibrosController.class);

	ServiceLibro serviceLibro = null;
	ValidatorFactory factory = null;
	Validator validator = null;

	public LibrosController() {
		super();
		serviceLibro = ServiceLibro.getInstance();
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@ApiOperation(value = "Listado Libros")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Listado Libros"),
			@ApiResponse(code = 404, message = "No se encontro Libro") })

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Libro>> listado() {

		ArrayList<Libro> list = new ArrayList<Libro>();
		ResponseEntity<ArrayList<Libro>> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			list = (ArrayList<Libro>) serviceLibro.listar();
			response = new ResponseEntity<>(list, HttpStatus.OK);

		} catch (Exception e) {
			LOG.error(e);
		}

		return response;
	}

	@ApiOperation(value = "Detalle Libro")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Detalle Libro"),
			@ApiResponse(code = 404, message = "No se encontro Libro valor incorrecto"),
			@ApiResponse(code = 409, message = "Caracteres vacios") })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Libro> detalle(@PathVariable long id) {

		ResponseEntity<Libro> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			Libro libro = serviceLibro.buscarId(id);
			if (libro != null && libro.getId() > 0) {
				response = new ResponseEntity<>(libro, HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			LOG.error(e);
		}
		return response;
	}

	@ApiOperation(value = "Eliminar Libro")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Eliminar Libro"),
			@ApiResponse(code = 404, message = "No se encontro Libro id libro incorrecto"),
			@ApiResponse(code = 409, message = "No se puede eliminar el libro por que esta asociado a un prestamo") })
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> eliminar(@PathVariable long id) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			if (serviceLibro.eliminar(id)) {
				response = new ResponseEntity<>(HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (SQLIntegrityConstraintViolationException e) {
			response = new ResponseEntity<>(new ResponseMensaje("No se puede eliminar si tiene Prestamo asociados"),
					HttpStatus.CONFLICT);
			LOG.warn(response);
		} catch (Exception e) {
			LOG.error(e);
		}
		return response;
	}

	@ApiOperation(value = "Crear Libro")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Crear Libro"),
			@ApiResponse(code = 409, message = "Esta vacio Libro o el Nombre del libro ya existe o el editorial no exisiste") })

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> crear(@RequestBody Libro libro) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			Set<ConstraintViolation<Libro>> violations = validator.validate(libro);

			if (violations.isEmpty()) {

				if (serviceLibro.crear(libro)) {
					response = new ResponseEntity<>(libro, HttpStatus.CREATED);
				} else {
					response = new ResponseEntity<>(new ResponseMensaje("libro creado"), HttpStatus.CREATED);
				}

			} else {
				ResponseMensaje mensaje = new ResponseMensaje("Los datos no son correctos");
				for (ConstraintViolation<Libro> v : violations) {
					mensaje.addError(v.getPropertyPath() + ": " + v.getMessage());
				}				
				response = new ResponseEntity<>(mensaje, HttpStatus.CONFLICT);
			}

		} catch (SQLIntegrityConstraintViolationException e) {

			ResponseMensaje msj = new ResponseMensaje("Los datos no son correctos");
			response = new ResponseEntity<>(msj, HttpStatus.CONFLICT);
			LOG.debug(response);
		} catch (Exception e) {
			LOG.error(e);
		}
		return response;
	}

	@ApiOperation(value = "Modificar Libro")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Modificar Libro"),
			@ApiResponse(code = 404, message = "No se encontro Libro id libro incorrecto"),
			@ApiResponse(code = 409, message = "No se puede modificar libro con el mismo nombre o que esta vacio") })

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Libro libro) {

		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		try {

			Set<ConstraintViolation<Libro>> violations = validator.validate(libro);
			if (violations.isEmpty()) {

				libro.setId(id);
				if (serviceLibro.modificar(libro)) {
					response = new ResponseEntity<>(libro, HttpStatus.OK);
				} else {
					response = new ResponseEntity<>(HttpStatus.CONFLICT);
				}

			} else {
				ResponseMensaje mensaje = new ResponseMensaje("Los datos no son correctos");
				for (ConstraintViolation<Libro> v : violations) {
					mensaje.addError(v.getPropertyPath() + ": " + v.getMessage());
				}
				;
				response = new ResponseEntity<>(mensaje, HttpStatus.CONFLICT);
			}

		} catch (SQLIntegrityConstraintViolationException e) {
			response = new ResponseEntity<>(new ResponseMensaje("los datos son incorrectos"), HttpStatus.CONFLICT);
			LOG.debug(response);
		} catch (Exception e) {
			LOG.error(e);
		}
		return response;
	}

}