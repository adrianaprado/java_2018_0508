package com.ipartek.formacion.libros.service;

import java.sql.Date;
import java.util.List;

import com.ipartek.formacion.libros.model.AlumnoDAO;
import com.ipartek.formacion.libros.model.EditorialDAO;
import com.ipartek.formacion.libros.model.LibroDAO;
import com.ipartek.formacion.libros.model.PrestamoDAO;
import com.ipartek.formacion.libros.pojo.Alumno;
import com.ipartek.formacion.libros.pojo.Editorial;
import com.ipartek.formacion.libros.pojo.Libro;
import com.ipartek.formacion.libros.pojo.Prestamo;

public class ServiceEditorial implements ICRUDService<Editorial> {
	
	private static ServiceEditorial INSTANCE = null;

	private static EditorialDAO editorialDao;
	
	
	private ServiceEditorial() {
		super();
		editorialDao = EditorialDAO.getInstance();
	}

	public static synchronized ServiceEditorial getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new ServiceEditorial();
		}

		return INSTANCE;
	}

	
	@Override
	public List<Editorial> listar() throws Exception {
		
		return editorialDao.getAll();
	}

	@Override
	public Editorial obtener(long id) throws Exception {
		
		return editorialDao.getById(id);
	}

	@Override
	public boolean crear(Editorial pojo) throws Exception {
	
		boolean resul = false;			
		resul = editorialDao.insert(pojo);
		
		return resul;
	}

	@Override
	public boolean modificar(Editorial pojo) throws Exception {
		
		boolean resul = false;		
		resul = editorialDao.update(pojo);

		return resul;
	}

	@Override
	public boolean eliminar(String id) throws Exception {
		
		boolean resul = false;
		resul = editorialDao.delete(id);
		
		return resul;
	}

	
	
}