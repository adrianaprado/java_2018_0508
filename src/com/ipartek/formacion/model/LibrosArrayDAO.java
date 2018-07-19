package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.Libro;
import com.ipartek.formacion.pojo.VideoYoutube;

public class LibrosArrayDAO implements CrudAble<Libro> {
		//Atributos estatictos
		private static LibrosArrayDAO INSTANCE = null;
		private static List<Libro> lista = null;
		
	//PATRON SINGLETON
		//Constructor Privado para que nadie pueda hacer un  new
		private LibrosArrayDAO() {
			lista = new ArrayList<Libro>();
		}
		//Para construir un contructor privado y poder utilizarlo publicamente
		public static synchronized LibrosArrayDAO getInstance() { 
			if (INSTANCE == null) { 
				INSTANCE = new LibrosArrayDAO(); //Así solo tenemos un objeto LibrosArrayDao
			}
			return INSTANCE; //Devuelve un objeto de la propia clase
		}
		
		
	//Todos los metodos que implementa la interfaz crudable - EN ESTE CASO NO SON IMPORTANTES
		
		@Override
		public boolean insert(Libro nuevo_libro) {
			boolean resul = false;
			if ( nuevo_libro != null ) {
				resul = lista.add(nuevo_libro);			
			}			
			return resul;
		}

		@Override
		public List<Libro> getAll() {
			return lista;
		}

		@Override
		public Libro getById(long id) {
			Libro resul = null;
			//foreach
			for (Libro libroIteracion : lista) {
				if ( id == libroIteracion.getId() ) { //Si coinciden los ID
					resul = libroIteracion;//Guardamos resultado
					break;
				}
			}
			return resul;
		}

		@Override
		public boolean update(Libro libro_modificado) {
			boolean resul = false;
			Libro lIteracion = null;
			//buscar libro a eliminar
			for (int i = 0; i < lista.size(); i++) {
				
				lIteracion = lista.get(i);   //libro sobre el que iteramos
				
				if ( libro_modificado.getId() == lIteracion.getId() ) {    // libro encontrado
					lista.set(i, libro_modificado);
					resul = true;
				}
			}
			return resul;
		}

		@Override
		public boolean delete(long id) {
			boolean resul = false;
			Libro lIteracion = null;
			
			//buscar libro a eliminar
			for (int i = 0; i < lista.size(); i++) {
				
				lIteracion = lista.get(i);   //video sobre el que iteramos
				
				if ( id == lIteracion.getId() ) {    // video encontrado
					resul = lista.remove(lIteracion);
					break;
				}
			}
			return false;
		}


		
/**
 * Retorna los libros prestados o no prestados		
 * @param isPrestado boolena true=>listado prestado, false=>listado no prestado
 * @return listado de libros
 */
		public List<Libro> getAllPrestados(boolean isPrestado){
			ArrayList<Libro> resul =new ArrayList<Libro>();
			//Recorrer el listado
			for(Libro libro:lista) {
				if(libro.isPrestado()==isPrestado) {
					resul.add(libro);
				}
			}
			
			return resul;
		}
/**
 * Buscamos Libros que coincida el titulo, es ignoreCase, nos sirve cualquier coincidencia	
 * @param  Busqueda String termino a buscar 
 * @return lostado de Libros que coincidan con la "busqueda"
 */
		public List<Libro> buscarPorTitulo(String busqueda){
			ArrayList<Libro> resul =new ArrayList<Libro>();
			if(busqueda!=null){
				//Recorrer el listado
				for(Libro libroIteracion:lista) {
					if(libroIteracion.getTitulo().toLowerCase().contains(busqueda.toLowerCase())) {
						resul.add(libroIteracion);
					}
				}
			}
			return resul;
			
		}
}