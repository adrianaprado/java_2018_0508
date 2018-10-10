<%@page import="com.ipartek.formacion.youtube.controller.back.CrudControllable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>   
<%@include file="../includes/nav.jsp" %>   


 	<div id="page-wrapper" class="contenedor">
 	  
	<%@include file="../includes/alert.jsp" %>   
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header titulo">Usuarios <span class="badge nUsuarios">${fn:length(usuarios)}</span></h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
	
  		<div class="row buscador">
  		
  			<div class="col-md-8">
  				<form action="buscar" method="post">
  					<input type="search" name="buscador" placeholder="Buscar por nombre" />
  					<button type="submit"><i class="fas fa-search"></i></button>
  				</form> 			
  			</div>
  			<div class="col-md-4 btn-crear">
  				<a href="usuarios?id=-1&op=<%=CrudControllable.OP_IR_FORMULARIO %>" class="btn btn-primary">Crear nuevo</a>  			
  			</div>
  		
  		</div>
	       
	    
		<table id="tablaOrdenable" class="display">
			<thead>
			    <tr>
			        <th>Id</th>
			        <th>Nombre</th>
			        <th>Rol</th>
			    </tr>
			</thead>
			<tbody>
			    
				<c:forEach items="${usuarios}" var="u">
				    	
				    <tr>
				    	<td>${u.id}</td>
				    	<td><a href="usuarios?id=${u.id }&op=<%=CrudControllable.OP_IR_FORMULARIO %>">${u.nombre}</a></td>
				    	<td>${u.rol.nombre}</td>			    	
				    </tr>
				    
				</c:forEach>
			        
			</tbody>
			<tfoot>
				<tr>
				    <th>Id</th>
				    <th>Nombre</th>
				    <th>Rol</th>
			 	</tr>
			</tfoot>
		</table>
		
		
	</div>
<%@include file="../includes/footer.jsp"%>