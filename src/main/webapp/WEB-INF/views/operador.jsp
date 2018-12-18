<!DOCTYPE html>
<html>
<head>
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

button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 70%;
	margin-top: 5px;
	margin-left: auto;
    margin-right: auto;
	}

.card {
	background-color: white;
	opacity: .8;
	color: #000;
    display: block;
    padding-top: 2%;
    padding-bottom: 2%;
    padding-left: 10px;
    margin-top: 50px;    
    margin-left: auto;
    margin-right: auto;
	width: 30%;
    height: 30%;    
}




button:hover {
	opacity: 0.8;
}



</style>
</head>
	<body background="/resources/images/background_1.jpg">
		<div class="card">
		<h2>B I E N V E N I D O</h2>
		<div align="center">
		<p class="title">${name}</p>
		<p>Empresa ${corporate}</p>
		<p>Usted puede realizar las siguientes actividades</p>
		</div>
		
		<div align="center">
		<p>
			<button onclick="location.href='busqueda'">BÚSQUEDA</button>
		</p>
		
	
		</div>
		</div>

	</body>
</html>