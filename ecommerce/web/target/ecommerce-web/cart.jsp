<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>LISTA DE PRODUTOS</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta charset="ISO-8859-1">
<title>Listagem de Produtos</title>
</head>
<body>
<h2>Carrinho de Compras</h2>
	<form action="cart" method="get">
		<div class="container">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>Preco</th>
				</thead>
				<tbody>
					<c:forEach var="produto" items="${inCart}">
						<tr>
							<td>${produto.id}</td>
							<td>${produto.nome}</td>
							<td>${produto.preco}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</form>
		<div>
		<button type="button" 
		class="btn btn-primary btn-xs"
		data-toggle="modal" data-target="#myModal">
		Realizar Pedido
		</button>
		</div>
		<div>
		<button 
		onclick="window.location.href = '/ecommerce-web/buy';" 
		class="btn btn-secondary btn-xs">
		Comprar Mais
		</button>
		</div>
  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">   
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Associe um Cliente ao Carrinho</h4>
        </div>
        <div class="modal-body">
    		  <form action="cart" method="post">
			    <div class="radio">
			    <input type="hidden" name="idProd" value="0">

		 <select name="cliente">
			    <option value="0">Selecione o Cliente:</option>
			   	<c:forEach var="cliente" items="${listaClientes}">
		    	<option value="${cliente.id}">${cliente.usuario}</option>
	    	</c:forEach>
    	 </select>
				</div>
			    
			            <div>
        <button type="submit" 
		class="btn btn-primary btn-xs">
		Confirma
		</button>
        </div>
			  </form>    
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div> 
		
</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<link rel="dns-prefetch" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css?family=Raleway:150,200,300"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

</html>