package com.ipartek.formacion.youtube.controller.front;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.youtube.model.ComentarioDAO;
import com.ipartek.formacion.youtube.model.VideoDAO;
import com.ipartek.formacion.youtube.pojo.Alert;
import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Servlet implementation class FrontofficeController
 */
@WebServlet("/perfil/inicio")
public class FrontofficeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static final String VIEW_INICIO = "/perfil/index.jsp";
	
	private static VideoDAO daoVideo;
	private static ComentarioDAO daoComentario;
	
	private static Alert alert;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoVideo = VideoDAO.getInstance();
		daoComentario = ComentarioDAO.getInstance();
	}

	@Override
	public void destroy() {
		daoVideo = null;
		daoComentario = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			
			Usuario user = (Usuario) request.getSession().getAttribute("usuario");
			
			alert = new Alert(Alert.SUCCESS, "Panel de Usuario");
			
			
			request.setAttribute("comentarios", daoComentario.getAllByIdUsuario(user.getId()));
			request.setAttribute("videos", daoVideo.getAllPerUserId(user.getId()));
			request.setAttribute("alert", alert);

		} catch (Exception e) {
			
			alert = new Alert();
			e.printStackTrace();
		
		} finally {
			
			request.getRequestDispatcher(VIEW_INICIO).forward(request, response);
		}

	}

}