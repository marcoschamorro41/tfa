<html>

<head>
<title>Realizar Busqueda</title>
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
	<h2>REALIZAR BUSQUEDA</h2>

	<div  align="center"><font color="red">${errorMessage}</font></div>

	<form method="post" action="/editionofuser">
		<input type="hidden" name="oldUsername" value="${empresa}" />
		<div class="container">
			<p>
				<select name="titleNot">
					<option value="yes">Contiene</option>
					<option value="not">No contiene</option>
				</select>
				<input type="text" placeholder="Ingresar palabra o frase a buscar" name="title">
			</p>
			<br/>
			<p>
				<label for="operator"><b>Operador Booleano -></b></label>
				<select name="operator">
					<option value="yes">Y (AND)</option>
					<option value="not">O (OR)</option>
				</select>
			</p>
			<br/>
			<p>
				<select name="bodyNot">
					<option value="yes">Contiene</option>
					<option value="not">No contiene</option>
				</select>
				<input type="text" placeholder="Ingresar palabra o frase a buscar" name="body">
			</p>
			
		</div>
		<div class="container-crear">
			<button type="submit">BUSCAR - NO TOCAR</button>
		</div>
	</form>
	
	<div class="container-crear">	
			<button onclick="location.href='/resultados-busqueda'">Buscar</button>
	</div>
	
	<div class="container-crear">	
			<button onclick="location.href='/admin'">Regresar al menu principal</button>
	</div>


</body>

</html>