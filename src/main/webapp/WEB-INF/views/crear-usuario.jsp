<html>

<head>
<title>Crear Usuario</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Static content -->
<link rel="stylesheet" href="/resources/css/style.css">
<script type="text/javascript" src="/resources/js/app.js"></script>
<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed" rel="stylesheet">

<style>

#main-container{
	font-family: 'Roboto Condensed', sans-serif;
	padding-top: 2%;
	padding-left: 1%;
	padding-right: 1%;
	padding-bottom: 2%;
	background-color: #FFF;
	opacity: .8;
	margin-top: 50px;    
    margin-left: auto;
    margin-right: auto;
	width: 40%;
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
	font-family: 'Roboto Condensed', sans-serif;
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
	background-color: #f44336;
}


.container-crear {
	font-family: 'Roboto Condensed', sans-serif;
	max-width: 300px;
	margin: auto;
	text-align: center;
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
}
</style>
</head>

<body background="/resources/images/background_1.jpg">
	<div id= "main-container">
	<h2>CREAR USUARIO</h2>

	<div  align="center"><font color="red">${errorMessage}</font></div>

	<form method="post" action="/creationofuser">

		<div class="container">
			<br>
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

		<div class="container-crear">
			<button type="button" class="cancelbtn">CANCELAR</button>
		</div>
	</form>
	</div>


</body>

</html>