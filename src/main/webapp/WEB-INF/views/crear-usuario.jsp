<html>

<head>
<title>Crear Usuario</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Static content -->
<link rel="stylesheet" href="/resources/css/style.css">
<script type="text/javascript" src="/resources/js/app.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
font-family


:

 

Arial
,
Helvetica
,
sans-serif


;
}
form {
	border: 3px solid #f1f1f1;
}

h2 {
	text-align: center;
}

input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
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

button:hover {
	opacity: 0.8;
}

.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}

.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
}

img.avatar {
	width: 40%;
	border-radius: 50%;
}

.container-crear {
	max-width: 300px;
	margin: auto;
	text-align: center;
	font-family: arial;
	padding: 16px;
}

span.psw {
	float: right;
	padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}
</style>
</head>

<body>
	<h2></h2>
	<h2>CREAR USUARIO</h2>

	<font color="red">${errorMessage}</font>

	<form method="post" action="/creationofuser">

		<div class="container">
			<p>
				<label for="user-name"><b>Nombre de Usuario</b></label> <input
					type="text" placeholder="Ingresar nombre de usuario"
					name="username" required>
			<p>
				<label for="password"><b>Contraseña</b></label> <input
					type="password" placeholder="Ingresar contraseña" name="password"
					required>
			<p>
				<label for="corporate"><b>Empresa</b></label> <input type="text"
					placeholder="Ingresar empresa" name="corporate" required>
			<p>
				<label for="usertype"><b>Tipo de Usuario</b></label> <input
					type="text" placeholder="Ingresar empresa" name="usertype" required>
			<p></p>
		</div>
		<div class="container-crear">
			<button type="submit">CREAR USUARIO</button>

		</div>

		<div class="container-crear" style="background-color: #f1f1f1">
			<button type="button" class="cancelbtn">Cancelar</button>
		</div>
	</form>


</body>

</html>