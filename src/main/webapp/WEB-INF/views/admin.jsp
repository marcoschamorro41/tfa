<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Static content -->
<link rel="stylesheet" href="/resources/css/style.css">
<script type="text/javascript" src="/resources/js/app.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.card {
	max-width: 300px;
	margin: auto;
	text-align: center;
	font-family: arial;
}

.title {
	color: #4caf50;
	font-size: 18px;
	font-weight: bold;
}

button {
	border: none;
	outline: 0;
	display: inline-block;
	padding: 8px;
	color: white;
	background-color: #4caf50;
	text-align: center;
	cursor: pointer;
	width: 100%;
	font-size: 18px;
}

a {
	text-decoration: none;
	font-size: 22px;
	color: black;
}

button:hover, a:hover {
	opacity: 0.7;
}
</style>
</head>
<body>

	<h2 style="text-align: center">Bienvenido</h2>

	<div class="card">

		<p class="title">${name}</p>
		<p>Empresa ${corporate}</p>
		<p>Usted puede realizar las siguientes actividades:</p>
		<p>
			<button >Busqueda</button>
		</p>
		<p>
			<button>Reportes</button>
		</p>
		<p>
			<button>Filtros</button>
		</p>
		<p>
			<button onclick="location.href='/usuarios'">Administración de Usuarios</button>
		</p>

	</div>

</body>
</html>