package com.ipartek.formacion.youtube.pojo;

public class Usuario {
	
	private long id;
	private String nombre;
	private String password;
	//TODO  Rol;
	
	public Usuario() {
		super();
		this.id=-1;
		this.nombre = "";
		this.password = "";
	}

		
	public Usuario(String nombre, String password) {
		this();
		this.nombre = nombre;
		this.password = password;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", password=" + password + "]";
	}


}
