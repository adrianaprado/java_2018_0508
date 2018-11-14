package com.ipartek.formacion.prestamos.api.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.pojo.Alumno;
import com.ipartek.formacion.pojo.Libro;
import com.ipartek.formacion.pojo.Prestamo;
import com.ipartek.formacion.service.ServiceAlumno;
import com.ipartek.formacion.service.ServiceLibro;
import com.ipartek.formacion.service.ServicePrestamo;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/libros/prestamos")
public class PrestamosController {

	private static final int ACTIVOS = 1;
	private static final int HISTORICOS = 0;
	private final static Logger LOG = Logger.getLogger(PrestamosController.class);

	ServicePrestamo servicePrestamo = null;
	ValidatorFactory factory = null;
	Validator validator = null;

	public PrestamosController() {
		super();
		LOG.trace("constructor");
		servicePrestamo = ServicePrestamo.getInstance();
		// Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();

		LOG.trace("servicio instanciado");
	}

	
	@ApiOperation(value = "Listado de prestamos activos o historicos")
	@ApiResponses (value= {
			@ApiResponse(	code  =  200 , message  =  " Listado Prestamos"),
			@ApiResponse(	code  =  404 , message  =  " No se encontró prestamo ")					
	} )
	
	@ApiParam(value="activos",required=false,name="bla bla bla",defaultValue="1")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Prestamo>> listar(
			@RequestParam(value = "activos", required = false, defaultValue = "-1") int activos) {

		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		ResponseEntity<ArrayList<Prestamo>> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

		try {

			if (activos == ACTIVOS || activos != ACTIVOS && activos != HISTORICOS) {
				prestamos = (ArrayList<Prestamo>) servicePrestamo.listarPrestados();

			} else if (activos == HISTORICOS) {
				prestamos = (ArrayList<Prestamo>) servicePrestamo.listarHistorico();

			}
			LOG.debug("prestamos recuperados:" + prestamos.size());
			response = new ResponseEntity<>(prestamos, HttpStatus.OK);

		} catch (Exception e) {
			LOG.error(e);
			// e.printStackTrace();
		}

		return response;
	}

//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//	public ResponseEntity<Object> detalle(@PathVariable long id) throws Exception {
//		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
//		Prestamo prestamo = new Prestamo();
//		prestamo = servicePrestamo.buscarPorId(id);
//
//		if (prestamo != null && prestamo.getId() > 0) {
//
//			response = new ResponseEntity<>(alumno, HttpStatus.OK);
//		} else {
//			response = new ResponseEntity<>(
//					new ResponseMensaje("No se ha encotrado ningun registro, cambie de identificador"),
//					HttpStatus.NOT_FOUND);
//		}
//
//		return response;
//	}
//
//	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<Object> eliminar(@PathVariable long id) throws Exception {
//
//		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
//
//		try {
//
//			if (serviceAlumno.eliminar(id)) {
//				response = new ResponseEntity<>(HttpStatus.OK);
//			} else {
//				response = new ResponseEntity<>(
//						new ResponseMensaje("No se ha encotrado ningun registro, cambie de identificador"),
//						HttpStatus.NOT_FOUND);
//			}
//
//		} catch (MySQLIntegrityConstraintViolationException e) {
//
//			response = new ResponseEntity<>(
//					new ResponseMensaje(
//							"No es posible eliminar el registro deseado porque tiene algun prestamo pendiente."),
//					HttpStatus.CONFLICT);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return response;
//	}
//
//
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> prestar(@RequestBody Prestamo prestamo) throws Exception {
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		ResponseMensaje responseMensaje = new ResponseMensaje();

		try {

			Set<ConstraintViolation<Prestamo>> violations = validator.validate(prestamo);
			if (violations.size() > 0) {
				/* No ha pasado la valiadacion, iterar sobre los mensajes de validacion */

				ArrayList<String> errores = new ArrayList<>();
				for (ConstraintViolation<Prestamo> violation : violations) {
					errores.add(violation.getPropertyPath() + ": " + violation.getMessage());

				}
				responseMensaje.setErrores(errores);
				responseMensaje.setMensaje("Datos no validos");

				response = new ResponseEntity<>(responseMensaje, HttpStatus.CONFLICT);
			} else {
				if (servicePrestamo.prestar(prestamo)) {
					
					Alumno a= new Alumno();
					a=ServiceAlumno.getInstance().buscarPorId(prestamo.getAlumno().getId());
					prestamo.setAlumno(a);
					
					Libro l=new Libro();
					//l=ServiceLibro.getInstance().
					
					response = new ResponseEntity<>(prestamo, HttpStatus.CREATED);
				} else {
					response = new ResponseEntity<>(new ResponseMensaje("Datos no validos"), HttpStatus.CONFLICT);

				}
			}

		} catch (MySQLIntegrityConstraintViolationException e) {

			response = new ResponseEntity<>(new ResponseMensaje("Datos no validos"), HttpStatus.CONFLICT);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return response;
	}

	// put endPoint/libros/{id_libro}/prestamos/{id_alumno}/{fecha_inicio}

//	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//	public ResponseEntity<Object> modificar(@PathVariable long id, @RequestBody Alumno alumno) throws Exception {
//
//		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
//		ResponseMensaje responseMensaje = new ResponseMensaje();
//
//		try {
//			alumno.setId(id);
//			Set<ConstraintViolation<Alumno>> violations = validator.validate(alumno);
//			if (violations.size() > 0) {
//				/* No ha pasado la valiadacion, iterar sobre los mensajes de validacion */
//
//				ArrayList<String> errores = new ArrayList<>();
//				for (ConstraintViolation<Alumno> violation : violations) {
//					errores.add(violation.getPropertyPath() + ": " + violation.getMessage());
//
//				}
//				responseMensaje.setErrores(errores);
//				responseMensaje.setMensaje("Datos no validos");
//
//				response = new ResponseEntity<>(responseMensaje, HttpStatus.CONFLICT);
//			} else {
//				if (serviceAlumno.modificar(alumno)) {
//					response = new ResponseEntity<>(alumno, HttpStatus.OK);
//				} else {
//					response = new ResponseEntity<>(
//							new ResponseMensaje("No se ha encotrado ningun registro, cambie de identificador"),
//							HttpStatus.NOT_FOUND);
//				}
//			}
//
//		} catch (MySQLIntegrityConstraintViolationException e) {
//
//			response = new ResponseEntity<>(
//					new ResponseMensaje("Ya existe el alumno,Por favor prueba con otro nombre."),
//					HttpStatus.CONFLICT);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return response;
//	}

}
