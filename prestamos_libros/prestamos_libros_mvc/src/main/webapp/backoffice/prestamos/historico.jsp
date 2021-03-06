<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.ipartek.formacion.prestamolibros.controller.CrudControllable"%>
<%@page import="com.ipartek.formacion.prestamolibros.pojo.Prestamo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>
<%@include file="../includes/nav.jsp"%>

<div id="page-wrapper">
	<%@include file="../includes/alert.jsp"%>

	<div class="row divTitulo">
        <div class="col-md-8">
            <h1 class="page-header titulo">Hístorico de préstamos <span class="badge">${fn:length(historico)}</span></h1>
        </div>
	</div>

	<table id="tablaOrdenable" class="display">
		<thead>
			<tr>
				<th>Fecha de devolución</th>
				<th>Libro</th>
				<th>Alumno</th>
				<th>Fecha de inicio</th>
				<th>Fecha final</th>
				<th>Modificar préstamo</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${historico}" var="h">

				<tr>
					<td>${h.devuelto}</td>
					<td><a href="libros?id=${h.libro.id}&op<%=CrudControllable.OP_IR_FORMULARIO %>" >${h.libro.titulo}</a></td>
					<td><a href="alumnos?id=${h.alumno.id}&op=<%=CrudControllable.OP_IR_FORMULARIO %>">${h.alumno.nombre} ${h.alumno.apellidos}</a></td>
					<td>${h.fechaInicio}</td>
					<td>${h.fechaFin}</td>
					<td><a href="prestamos?libro=${h.libro.id}&alumno=${h.alumno.id}&fechaInicio=${h.fechaInicio}&fechaFin=${h.fechaFin}&fechaDevuelto=${h.devuelto}&op=6" class="btn btnModificar">Modificar préstamo</a></td>
				</tr>

			</c:forEach>

		</tbody>
		<tfoot>
			<tr>
				<th>Fecha de devolución</th>
				<th>Libro</th>
				<th>Alumno</th>
				<th>Fecha de inicio</th>
				<th>Fecha final</th>
				<th>Modificar préstamo</th>
			</tr>
		</tfoot>
	</table>
	
	<!-- Modal devolución -->
			<div class="modal fade" id="modalDevolucion" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel">Atención</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
			      	<form action="prestamos" method="post">
			      	
			      		<div class="form-group">
				      		<label for="titulo">Libro</label>
				        	<input type="text" class="form-control" id="titulo" readonly />
			        	</div><div class="form-group">
				      		<label for="nombre">Alumno</label>
				        	<input type="text" class="form-control"id="nombre" readonly />
			        	</div>
			      	
				      	<div class="form-group">
				      		<label for="fechaDevolucion">Fecha de devolución</label>
				        	<input type="date" class="form-control" name="fechaDevolucion" id="fechaDevolucion" required />
			        	</div>
			        	
			        	<input type="hidden" name="libro" id="libro" />
			        	<input type="hidden" name="alumno" id="alumno" />
			        	<input type="hidden" name="fechaInicio" id="fechaInicio" />
			        	<input type="hidden" name="op" value=<%=CrudControllable.OP_ELIMINAR %> />
			        	<input type="submit" class="btn btn-primary btn-block" value="Finalizar préstamo" />
			        	
			        </form>
			      </div>
			    </div>
			  </div>
			</div>


</div>
<%@include file="../includes/footer.jsp"%>