package com.ipartek.formacion.youtube.controller.back;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.model.RolDAO;
import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.model.VideoYoutubeDAO;

/**
 * Servlet implementation class BackofficeController
 */
@WebServlet("/backoffice/inicio")
public class BackofficeController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String VIEW_INICIO = "/backoffice/index.jsp";
	
	private static UsuarioDAO daoUsuario;
	private static VideoYoutubeDAO daoVideo;
	private static RolDAO daoRol;
    
	@Override
	public void init(ServletConfig config) throws ServletException {		
		super.init(config);
		daoUsuario = UsuarioDAO.getInstance();
		daoVideo = VideoYoutubeDAO.getInstance();
		daoRol = RolDAO.getInstance();
	}
	
	@Override
	public void destroy() {		
		daoUsuario = null;
		daoVideo = null;
		daoRol = null;
	}
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
				
			request.setAttribute("videos", daoVideo.getAll().size() );
			request.setAttribute("usuarios", daoUsuario.getAll().size() );
			request.setAttribute("roles", daoRol.getAll().size());
						
		}catch (Exception e) {
			e.printStackTrace();
		}finally {			
			request.getRequestDispatcher(VIEW_INICIO).forward(request, response);
		}
		
		
	}

}