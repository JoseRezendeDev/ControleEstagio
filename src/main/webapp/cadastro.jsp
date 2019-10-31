<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro</title>
</head>
<body>
<h3>Cadastro de usuário</h3>
<form action=controle method=post>

	<input checked type=radio name=tipoUsuario id=r1 value=1>
	<label for=r1>Aluno</label>
	<input type=radio name=tipoUsuario id=r2 value=2>
	<label for=r2>Administrador</label>
	<input type=radio name=tipoUsuario id=r3 value=3>
	<label for=r3>Supervisor</label>
	<input type=radio name=tipoUsuario id=r4 value=4>
	<label for=r4>Empresa</label>
	<br>
	Login: <input type=text name=login>
	<br>
	Senha: <input type=password name=senha>
	<br>
	<input type=submit value=Cadastrar name=comando>
</form>
</body>
</html>