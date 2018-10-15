<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed" rel="stylesheet">
<style>
body {
	font-family: 'Roboto Condensed', sans-serif;
}

h2 {
	text-align: center;
}

input[type=text], input[type=password] {
	width: 70%;
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
	width: 70%;
	margin-top: 25px;
	margin-left: auto;
    margin-right: auto;
	
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
    width: 30%;
	border-radius: 50%;
	color: white;
}

.container {
	color: white;
    display: block;
    background-color: #000;
    opacity: .7;
    padding-top: 2%;
    margin-top: 40px;
    margin-left: auto;
    margin-right: auto;
	width: 30%;
    height: 10%;
}

span.psw {
	float: right;
	padding-top: 16px;
}

div {
	resize: none;
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
<body background="/resources/images/background_1.jpg">

<div class=container>
	<h2>INICIAR SESION</h2>

	<div  align="center"><font color="red">${errorMessage}</font></div>

	<form method="post">
		<div class="imgcontainer">
			<img src="/resources/images/eyeroll.png" alt="Avatar" class="avatar">
		</div>

		<div align="center">
			<label for="corporate"><b>Empresa</b></label> 
			<br>
			<input type="text"
				placeholder="Ingresar empresa" name="corporate" required> 
			<br>
			<label for="uname"><b>Usuario</b></label> 
			<br>
			<input type="text" placeholder="Ingresar nombre de usuario" name="name" required>
			<br>
			<label for="psw"><b>Contraseña</b></label> 
			<br>
			<input type="password" placeholder="Ingresar contraseña" name="password" required>

			<button type="submit">INGRESAR</button>
		</div>

	</form>
	<br/>
	<br/>
</div>
</body>
</html>
