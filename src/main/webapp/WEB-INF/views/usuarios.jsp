<!DOCTYPE html>
<html>
<head>
<title>Usuario</title>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Static content -->
<link rel="stylesheet" href="/resources/css/style.css">
<script type="text/javascript" src="/resources/js/app.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>

.button {
    background-color: #d10303;
    border: none;
    color: white;
    padding: 15px 25px;
    text-align: center;
    font-size: 16px;
    cursor: pointer;
}

.btn {
    border: none;
    background-color: inherit;
    padding: 14px 28px;
    font-size: 16px;
    cursor: pointer;
    display: inline-block;
    
}

.btn:hover {background: #eee;}

.edit {color: green;}
.delete {color: red;}

table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

th{
	text-align: center;
	padding: 8px;
	border: 1px solid #dddddd;
}

td {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}

.pagination a {
	
    color: black;
    float: left;
    padding: 8px 16px;
    font-family: arial, sans-serif;
    transition: background-color .3s;
}

.pagination a.active {
    background-color: #d10303;
    color: white;
}

</style>
</head>
<body>

<h2>Usted esta en la pagina de Administracion de usuarios</h2>
<h2> </h2>
<button class="button createUser">Crear Usuario</button>
<h2> </h2>

<table>

<tr>
    <th>ID</th>
    <th>Nombre</th>
    <th>Correo</th>
    <th>Tipo de usuario</th>
    <th>Accion</th>
  </tr>

<tr>
    <td>01</td>
    <td>Marcos Chamorro</td>
    <td>marcos.chamorro@gmail.com</td>
    <td>Administrador</td>
    <td>
    <button class="btn edit">Editar</button>
<button class="btn delete">Borrar</button>
    </td>
    
</tr>


</table>

<h2></h2>

<div class="pagination">
  <a href="#">&laquo;</a>
  <a class="active" href="#">1</a>
  <a href="#">2</a>
  <a href="#">3</a>
  <a href="#">4</a>
  <a href="#">5</a>
  <a href="#">6</a>
  <a href="#">&raquo;</a>
</div>

</body>
</html>
