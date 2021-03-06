package com.ipartek.formacion.prestamolibros.service;

import java.sql.Date;
import java.util.List;

import com.ipartek.formacion.prestamolibros.pojo.Alumno;
import com.ipartek.formacion.prestamolibros.pojo.Libro;
import com.ipartek.formacion.prestamolibros.pojo.Prestamo;

public interface IServicePrestamo {
	
	/**
	 * Para poder prestar un libro se necesitan los siguientes parámetros:
	 * @param idLibro long Identificador del libro
	 * @param idAlumno long Identificador del alumno
	 * @param fechaInicio java.sql.date Fecha de inicio del préstamo
	 * @return true si realiza el préstamo correctamente, false en caso contrario
	 * @throws Exception
	 */
	boolean prestar(long idLibro, long idAlumno, Date fechaInicio)throws Exception;
		
	boolean devolver(long idAlumno, long idLibro, Date fechaInicio, Date fechaDevolucion)throws Exception;
	
	boolean modificarPrestamo(long idLibro, long idAlumno, Date fechaInicio, Date fechaFin, long oldIdLibro, long oldIdAlumno, Date oldFechaInicio)throws Exception;
	
	boolean modificarHistorico(long idLibro, long idAlumno, Date fechaInicio, Date fechaDevolucion, Date fechaFin, long oldIdLibro, long oldIdAlumno, Date oldFechaInicio)throws Exception;
	
	/**
	 * Colección de préstamos que están activos, fechaDevolucion == null
	 * @return
	 * @throws Exception
	 */
	List<Prestamo> prestados() throws Exception;
	
	/**
	 * Colección de préstamos realizados y no activos, fechaDevolucion != null
	 * @return
	 * @throws Exception
	 */
	List<Prestamo> historico() throws Exception;
	
	/**
	 * Colección de libros que actualmente no están prestados.
	 * @return
	 * @throws Exception 
	 */
	List<Libro> librosDisponibles() throws Exception;
	
	/**
	 * Colección de alumnos que actualmente no tienen ningún préstamo activo.
	 * Solo se puede prestar un libro y hasta que no se devuelva no se puede realizar otro préstamo.
	 * @return
	 */
	List<Alumno> alumnosDisponibles() throws Exception;
	
}
