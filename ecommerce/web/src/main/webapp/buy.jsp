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
<title>Loja Online - Produtos</title>
</head>
<body>

		<div class="container">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Nome</th>
						<th>Preco</th>
						<th>Adicionar ao Carrinho</th>
				</thead>
				
					<c:forEach var="produto" items="${listaProdutos}">
					 <form action="cart" method="post">
					 <input type="hidden" name="idProd" value="${produto.id}">
					  <tbody>
						<tr>
							<td>${produto.nome}</td>
							<td>${produto.preco}</td>
							<td><button type="submit" class="btn btn-primary btn-xs">Adicionar</button></td>
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