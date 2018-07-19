package com.ipartek.formacion.herencia;


import java.util.ArrayList;

import com.ipartek.formacion.pojo.Ebook;
import com.ipartek.formacion.pojo.Libro;
import com.ipartek.formacion.pojo.LibroElectronico;

public class JugandoPadreHijo {

	public static void main(String[] args) throws Exception {
		
		LibroElectronico le=new LibroElectronico();
		System.out.println(le);
		
		le.setEditorial("Lorem Ipsum");
		System.out.println(le.toString());
		
		Libro l=new Libro(234, "iiifdssfs", "Libro de la selva", "Amazonas", true);
		System.out.println(l);
		
		//ObjetoGrafico o=new ObjetoGrafico();--> no se puede instanciar objetos de clases abstractas
		ObjetoGrafico o=new ObjetoGrafico() {
			void dibujar() {
				
			}
		};
		Circulo circulo=new Circulo();
		circulo.dibujar();
		System.out.println(circulo);
		
		
		///Array con todos los libros mezclados
		ArrayList <Libro> stock = new ArrayList <Libro>();
		
		Libro libro= new Libro();
		libro.setTitulo("La historia interminable");
		
		Ebook ebook= new Ebook();
		ebook.setTitulo("Estolda jolasak");
		
		stock.add(libro);
		stock.add(ebook);
		
		for (Libro libroIteracion: stock) {
			if(libroIteracion instanceof Ebook) {
				Ebook ebook2=(Ebook)libroIteracion;//-->tastear
				ebook2.encenderLuz();
				System.out.println("Soy un ebook -->"+ebook2.getTitulo());				
			}else {
				System.out.println(libroIteracion.getTitulo());
			}
			
		}
		
	}

}
