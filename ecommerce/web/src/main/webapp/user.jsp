<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>CADASTRO DE CLIENTE</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta charset="ISO-8859-1">
<title>CADASTRANDO UM NOVO CLIENTE</title>
</head>
<body>
		<div class="container">
			<h2>NOVO CLIENTE</h2>
			<form action="user" method="post">
			<span class="form-group"> <label for="usuario"><b>Nome de Usuario:</b></label>
				<input type="text" class="form-control" id="usuario"
				placeholder="Insira um usuario" name="usuario" required>
			</span> <span class="form-group"> <label for="email"><b>Email:</b></label>
				<input type="text" class="form-control" id="email"
				placeholder="Insira um email" name="email" required>
				<button type="submit" class="btn btn-primary">Salvar</button>
				</form>
				<button onclick="window.location.href = '/ecommerce-web/index.jsp';" class="btn btn-secondary">Inicio</button>
			</span><br>
		</div>
	<hr>
	<h2 align="center">Lista de Clientes</h2>
	<br>
	<div class="container">
					<table class="table table-striped">
					<thead>
						<tr>
							<th>ID</th>
							<th>Nome</th>
							<th>Email</th>
					</thead>
		<c:forEach var="cliente" items="${listaClientes}">
		<form action="user" method="post">
					<tbody>					
						<tr>
							<td>${cliente.id}</td>
							<td>${cliente.usuario}</td>
							<td>${cliente.email}</td>
						</tr>
					</tbody>
					</form>				 	
				 </c:forEach>
				</table>
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