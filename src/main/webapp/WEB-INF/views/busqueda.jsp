<html>

<head>
<title>Realizar Busqueda</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Static content -->

<script type="text/javascript" src="/resources/js/app.js"></script>
<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed" rel="stylesheet">

<style>

body {
	font-family: 'Roboto Condensed', sans-serif;
}

h2 {
	text-align: center;
}

.contiene{
	font-family: 'Roboto Condensed', sans-serif;
	font-size: 16px;7
	padding: 12px 20px;
	background-color: white;
	opacity: .8;
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

	display: inline-block;
	line-height: 120%;
	font-family: 'Roboto Condensed', sans-serif;
	border: none;
	outline: 0;
	display: inline-block;
	padding: 8px;
	color: #4CAF50;
	background-color: transparent;
	border: 1px solid #4CAF50;
	transition: background-color ease 400ms;
	text-align: center;
	cursor: pointer;
	width: 100%;
	font-size: 18px;
}


button:hover {
	color: #FFF;
	background-color: #4CAF50;
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

.card {
	font-family: 'Roboto Condensed', sans-serif;
	background-color: white;
	opacity: .8;
	color: #000;
    display: block;
    padding-top: 1%;
    padding-bottom: 2%;
    padding-left: 20px;
    padding-right: 20px;
    margin-top: 20px;    
    margin-left: auto;
    margin-right: auto;
	width: 30%;
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

<body background="/resources/images/background_1.jpg">
	<div class="card">
	<div  align="center"><font color="red">${errorMessage}</font></div>

	<h2>REALIZAR UNA BÚSQUEDA</h2>	

	<form method="post" action="/editionofuser">
		<input type="hidden" name="oldUsername" value="${empresa}" />
			<br>
			<p>
				<select name="titleNot" class= "Contiene">
					<option value="yes">Contiene</option>
					<option value="not">No contiene</option>
				</select>
				<input type="text" placeholder="Ingresar palabra o frase a buscar" name="title">
			</p>
			<br/>
			<p>
				<label for="operator"><b>SELECCIONE UN OPERADOR BOOLEANO: </b></label>
				<select name="operator" class= "Contiene">
					<option value="yes">Y (AND)</option>
					<option value="not">O (OR)</option>
				</select>
			</p>
			<br/>
			<p>
				<select name="bodyNot" class= "Contiene">
					<option value="yes">Contiene</option>
					<option value="not">No contiene</option>
				</select>
				<input type="text" placeholder="Ingresar palabra o frase a buscar" name="body">
			</p>
			
			<br>

			<button type="submit">BUSCAR - NO TOCAR</button>

	</form>

			<p>
			<button onclick="location.href='/resultados-busqueda'">Buscar</button>
			</p>
			<button onclick="location.href='/admin'"> REGRESAR AL MENÚ </button>
			<br>
	</div>
	


</body>

</html>