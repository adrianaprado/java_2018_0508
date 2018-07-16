package com.ipartek.formacion.ejercicios;

/**
 * el metodoB lanzar una excepcion con throws ...se lanza siempre para arriba.
 * 
 * @author andreaPerez
 *
 */
public class Excepciones3 {

	public static void main(String[] args) throws Exception {

		System.out.println("Dentro del main");
		metodoA();

		System.out.println("salgo del main");
	}

	public static void metodoA() throws Exception {

		System.out.println("entro del metodoA");
		metodoB();
		System.out.println("salgo del metodoA");
	}

	public static void metodoB() throws Exception {

		System.out.println("entro del metodoB");

		metodoC();
		System.out.println("salgo del metodoB");

	}

	public static void metodoC() throws Exception {

		System.out.println("dentro del metodoC");

		Object o = null;
		o.toString();

		System.out.println("salgo del metodoC");
	}

}