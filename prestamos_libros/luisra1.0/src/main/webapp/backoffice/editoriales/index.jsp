<%@page import="com.ipartek.formacion.libros.controller.backoffice.ICRUDController"%>

<%@ include file="../include/header.jsp" %>


<%@ include file="../include/nav.jsp" %>
<div class="container">
  
  	  <%@ include file="../include/alert.jsp" %>
  	  
  	  <%@ include file="../include/modal.jsp" %>
  		
      <div class="row">
          <div class="col-lg-12">
              <h1 class="page-header">Editoriales</h1>
          </div> 
      </div> 
     
      <div class="row margin-bottom-5">
      		<div class="col-md-4">
      			<a href="editoriales?id=-1&op=<%= ICRUDController.OP_IR_FORMULARIO %>" class="btn btn-success mb-3">Crear Nuevo</a>
      		</div>	
      </div>
      
      <div class="row">
      
      		<!--  DATATBLES -->
      		<table id="tablaOrdenable" class="display" style="width:100%">
		        <thead>
		            <tr>
		                <th>ID</th>
		                <th>Nombre</th>
		                <th>Operaciones</th>	                
		            </tr>
		        </thead>
		        
		        <tbody>
		        	<c:forEach items="${ editoriales }" var="editorial">
			            <tr>
			                <td>${ editorial.id }</td>
			                <td>${ editorial.nombre }</a></td>
			                <td>
				                <a class="badge badge-primary" href="editoriales?op=<%= ICRUDController.OP_IR_FORMULARIO %>&id=${ editorial.id }&nombre=${ editorial.nombre }">Editar</a>
				                <a class="badge badge-danger" data-toggle="modal" onclick="showModalForm(4, ${ editorial.id }, <%= ICRUDController.OP_ELIMINAR %>);">Eliminar</a>
				            </td>   	                
			            </tr>
		            </c:forEach>
		        </tbody>
		       
		        <tfoot>
		            <tr>
		                 <th>ID</th>
		                <th>Nombre</th>
		                <th>Operaciones</th>	  
		            </tr>
		        </tfoot>
    	</table> 	<!-- table#tablaOrdenable -->		
      </div> <!-- ./ row -->

</div>

<%@ include file="../include/footer.jsp" %>