<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>CADASTRO DE PRODUTO</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta charset="ISO-8859-1">
<title>CADASTRANDO UM NOVO PRODUTO</title>
</head>
<body>
	<form action="prod" method="post">
		<div class="container">
			<h2>NOVO PRODUTO</h2>
			<span class="form-group"> <label for="nome"><b>Nome:</b></label>
				<input type="text" class="form-control" id="nome"
				placeholder="Insira um nome" name="nome">
			</span> <span class="form-group"> <label for="preco"><b>Preço:</b></label>
				<input type="number" class="form-control" id="preco"
				placeholder="Informe o valor" name="preco">
			</span><br>
			<button type="submit" class="btn btn-primary">Salvar</button>
		</div>
	</form>
	<hr>
	<h2 align="center">Lista de Produtos</h2>
	<br>
	<div class="container">
					<table class="table table-striped">
					<thead>
						<tr>
							<th>ID</th>
							<th>Nome</th>
							<th>Preco</th>
					</thead>
		<c:forEach var="produto" items="${listaProdutos}">
		<form action="prod" method="post">
			<input type="hidden" name="idProd" value="${produto.id}">
					<tbody>
					
						<tr>
							<td>${produto.id}</td>
							<td>${produto.nome}</td>
							<td>${produto.preco}</td>
							<td><button type="submit" class="btn btn-primary btn-xs">Excluir</button></td>
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