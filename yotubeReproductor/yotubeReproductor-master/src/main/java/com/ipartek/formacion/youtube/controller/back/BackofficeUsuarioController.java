package com.ipartek.formacion.youtube.controller.back;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.Usuario;

/**
 * Servlet implementation class BackofficeUsuarioController
 */
@WebServlet("/backoffice/usuarios")
public class BackofficeUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Usuario> usuarios = getMockUsers();// new ArrayList<Usuario>();
		String id = request.getParameter("id");
		if (id == null) {

			request.setAttribute("usuarios", usuarios);
			request.getRequestDispatcher("usuario/index.jsp").forward(request, response);
		} else {
			Usuario usuario = new Usuario();
			if (Integer.parseInt(id) > 0) {
				usuario = usuarios.get(Integer.parseInt(id)-1);
			}
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher("usuario/formulario.jsp").forward(request, response);
		}

	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		String rol = request.getParameter("rol");
		
		Usuario usuario = new Usuario();
		usuario.setId(Long.parseLong(id));
		usuario.setNombre(nombre);
		usuario.setPassword(password);
		usuario.setRol(Integer.parseInt(rol));
		
		
		request.setAttribute("usuario", usuario);
		request.getRequestDispatcher("usuario/formulario.jsp").forward(request, response);
		
		}
	
	private ArrayList<Usuario> getMockUsers() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario u = null;
		for (int i = 1; i < 100 ; i++) {
			
			u = new Usuario("nombre" + i, "123456");
			if(i == 1) {
				u.setRol(Usuario.ROL_ADMIN);
			}
			
			u.setId(i);
			usuarios.add(u);
			
		}
		return usuarios;
	}
		
	}
	



