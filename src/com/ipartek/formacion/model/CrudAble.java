package com.ipartek.formacion.model;

import java.util.List;

/**
 * Interfaz para especificar los metodos de <b>CRUD<b>
 * 
 * <ul>
 * <li>Create</li>
 * <li>Read</li>
 * <li>Update</li>
 * <li>Delete</li>
 * </ul>
 * 
 * @author Curso
 *
 */
public interface CrudAble {
	
	boolean insert(VideoYoutube video);
	
	List<VideoYoutube> getAll();
	
	VideoYoutube getById(long id);
	
	boolean update(VideoYoutube video);
	
	boolean delete(long id);
}
