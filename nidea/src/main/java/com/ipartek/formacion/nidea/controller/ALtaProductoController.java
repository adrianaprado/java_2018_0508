package com.ipartek.formacion.nidea.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Connection.Request;

import com.ipartek.formacion.nidea.pojo.Alert;
import com.ipartek.formacion.nidea.pojo.Categoria;
import com.ipartek.formacion.nidea.pojo.Producto;

/**
 * Servlet implementation class FormularioController
 */
@WebServlet("/formulario")
public class ALtaProductoController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		//TODO llamar al Modelo para recuperar las opciones del selector "categorias"
		ArrayList<Categoria> cats=recuperarCategorias();
		
		
		request.setAttribute("categoria",cats );
		
		
		request.getRequestDispatcher("formulario.jsp").forward(request, response);

	}

	private ArrayList<Categoria> recuperarCategorias() {
		
		ArrayList<Categoria> cats=new ArrayList<Categoria>();
		cats.add(new Categoria(1,"Cocina","CC"));
		cats.add(new Categoria(2,"Baño","BA"));	
		cats.add(new Categoria(3,"Dormitorio","DO"));
		
		return cats;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			
			// recoger parametros
			String imagen=request.getParameter("imagen");
			String nombre=request.getParameter("nombre");
			String codigo = request.getParameter("codigo");
			String oferta=request.getParameter("oferta");
			String precio = request.getParameter("precio");
			String descripcion = request.getParameter("descripcion");
			
			
			Alert alert=new Alert();
			
			
			// validar parametros
			if (codigo.isEmpty()) {

				request.setAttribute("alert", new Alert(alert.ALERT_WARNING,"Completa los campos obligatorios"));
				request.getRequestDispatcher("formulario.jsp").forward(request, response);
				
				
				
			}else {
				// crear Producto a traves de parametros recibidos del formulario
				Producto p = new Producto();
				
				//ponemos img por defecto si no se inserta
				if (imagen==null || ("").equals(imagen)) {
					p.setImagen(p.IMG_PROD_POR_DEFECTO);
				}else {
					
					p.setImagen(imagen);
				}
				
				p.setNombre(nombre);
				p.setCodigo(codigo);
				p.setOferta(("on".equalsIgnoreCase(oferta))?true:false);//TODO validar
				p.setDescripcion(descripcion);
				p.setPrecio(Float.parseFloat(precio));
				// pasa parametro
				request.setAttribute("producto", p);
				request.setAttribute("alert", new Alert(alert.ALERT_SUCCESS,"Producto dado de alta correctamente"));
				
				
			}
			
			
			
			

		} catch (Exception e) {
						// Si nos da error el server le mandamos al formulario de nuevo
						request.setAttribute("alert", new Alert());
						request.getRequestDispatcher("formulario.jsp").forward(request, response);
			
		} finally {
			// ir a la vista
			
				request.getRequestDispatcher("resultado.jsp").forward(request, response);
			
			
		}
	}

}