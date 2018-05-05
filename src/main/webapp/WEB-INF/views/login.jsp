<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
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
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
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

.container {
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

	<h2>INICIAR SESION</h2>

	<font color="red">${errorMessage}</font>

	<form method="post">
		<div class="imgcontainer">
			<img src="img_avatar2.png" alt="Avatar" class="avatar">
		</div>

		<div class="container">
			<label for="corporate"><b>Empresa</b></label> <input type="text"
				placeholder="Ingresar empresa" name="corporate" required> <label
				for="uname"><b>Usuario</b></label> <input type="text"
				placeholder="Ingresar nombre de usuario" name="name" required>

			<label for="psw"><b>Contraseña</b></label> <input type="password"
				placeholder="Ingresar contraseña" name="password" required>

			<button type="submit">INGRESAR</button>
			<label> <input type="checkbox" checked="checked"
				name="remember"> Recuerdame
			</label>
		</div>

		<div class="container" style="background-color: #f1f1f1">
			<button type="button" class="cancelbtn">Cancelar</button>
			<span class="psw">¿Olvidaste tu <a href="#">contraseña?</a></span>
		</div>
	</form>

</body>
</html>
