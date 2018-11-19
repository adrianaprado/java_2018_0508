package com.ipartek.formacion.libros.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.formacion.libros.controller.backoffice.AlumnosController;

/**
 * Servlet implementation class LogOutController
 */
@WebServlet("/logout")
public class LogOutController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private final static Logger LOG = Logger.getLogger(AlumnosController.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		HttpSession session = request.getSession();

		
		try{
			
			
			if ( session != null ) {
				session.removeAttribute("usuario");
				session.invalidate();
				session = null;
			}
			
			
			
			
		}catch (Exception e) {
			LOG.debug(e.getMessage());
			e.printStackTrace();
		}finally {
			response.sendRedirect(request.getContextPath() + "/login.jsp" ); 

			
		}
	}

}
