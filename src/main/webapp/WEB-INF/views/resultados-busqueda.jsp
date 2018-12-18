
<!DOCTYPE html>
<html>
<head>
<title>Resultados Busqueda</title>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Static content -->
<link rel="stylesheet" href="/resources/css/style.css">
<script type="text/javascript" src="/resources/js/app.js"></script>
<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed" rel="stylesheet">
<style>

body {
	font-family: 'Roboto Condensed', sans-serif;
}

#main-container{
	margin: 50px;
	padding-left: 5%;
	padding-right: 5%;
	padding-bottom: 2%;
	background-color: #FFF;
	opacity: .8;
}

button {
	font-family: 'Roboto Condensed', sans-serif;
	border: none;
	outline: 0;
	display: inline-block;
	padding: 5px;
	color: white;
	background-color: #4caf50;
	text-align: center;
	cursor: pointer;
	width: 90%;
	font-size: 18px;
}

.btn {
    border: none;
    background-color: inherit;
    padding: 14px 28px;
    font-size: 16px;
    cursor: pointer;
    display: inline-block;
    
}

.container-crear {
	max-width: 300px;
	margin: auto;
	text-align: center;
	font-family: arial;
	padding: 16px;
}


.btn:hover {background: #eee;}

.edit {color: green;}
.delete {color: red;}

table {
    font-family: 'Roboto Condensed', sans-serif;
    border-collapse: collapse;
    width: 100%;
}

th{
	text-align: center;
	padding: 8px;
	border: 1px solid #dddddd;
	color: white;
	background-color: #4caf50;
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
<body background="/resources/images/background_1.jpg">
<div id="main-container">
<br/>
<h2>RESULTADOS DE LA BÚSQUEDA</h2>
<br/>
<table>

  <tr>
    <th>Usuario</th>
    <th>Cuerpo</th>
	<th>Hashtags</th>
    <th>Fecha</th>
    <th>Idioma</th>
	<th>Ubicacion</th>
  </tr>
		
		<tr>
			<td>${tweets.get(0).getUsuario() }</td>
			<td>${tweets.get(0).getCuerpoTweet()}</td>
			<td>${tweets.get(0).getListaHashtags()}</td>
			<td>${tweets.get(0).getFecha()}</td>
			<td>${tweets.get(0).getIdioma()}</td>
			<td>${tweets.get(0).getUbicacion()}</td>
		</tr>
		
		<tr>
			<td>${tweets.get(1).getUsuario() }</td>
			<td>${tweets.get(1).getCuerpoTweet()}</td>
			<td>${tweets.get(1).getListaHashtags()}</td>
			<td>${tweets.get(1).getFecha()}</td>
			<td>${tweets.get(1).getIdioma()}</td>
			<td>${tweets.get(1).getUbicacion()}</td>
		</tr>
		
		<tr>
			<td>${tweets.get(3).getUsuario() }</td>
			<td>${tweets.get(3).getCuerpoTweet()}</td>
			<td>${tweets.get(3).getListaHashtags()}</td>
			<td>${tweets.get(3).getFecha()}</td>
			<td>${tweets.get(3).getIdioma()}</td>
			<td>${tweets.get(3).getUbicacion()}</td>
		</tr>
		
		<tr>
			<td>${tweets.get(2).getUsuario() }</td>
			<td>${tweets.get(2).getCuerpoTweet()}</td>
			<td>${tweets.get(2).getListaHashtags()}</td>
			<td>${tweets.get(2).getFecha()}</td>
			<td>${tweets.get(2).getIdioma()}</td>
			<td>${tweets.get(2).getUbicacion()}</td>
		</tr>
		
		<tr>
			<td>${tweets.get(4).getUsuario() }</td>
			<td>${tweets.get(4).getCuerpoTweet()}</td>
			<td>${tweets.get(4).getListaHashtags()}</td>
			<td>${tweets.get(4).getFecha()}</td>
			<td>${tweets.get(4).getIdioma()}</td>
			<td>${tweets.get(4).getUbicacion()}</td>
		</tr>
		
		<tr>
			<td>${tweets.get(5).getUsuario() }</td>
			<td>${tweets.get(5).getCuerpoTweet()}</td>
			<td>${tweets.get(5).getListaHashtags()}</td>
			<td>${tweets.get(5).getFecha()}</td>
			<td>${tweets.get(5).getIdioma()}</td>
			<td>${tweets.get(5).getUbicacion()}</td>
		</tr>
		<tr>
			<td>${tweets.get(6).getUsuario() }</td>
			<td>${tweets.get(6).getCuerpoTweet()}</td>
			<td>${tweets.get(6).getListaHashtags()}</td>
			<td>${tweets.get(6).getFecha()}</td>
			<td>${tweets.get(6).getIdioma()}</td>
			<td>${tweets.get(6).getUbicacion()}</td>
		</tr>		

		
		
</table><br/><br/>
<div class="container-crear">

			<p>
			<button onclick="location.href='/busqueda'">VOLVER ATRÄS</button>
			</p>
			<button onclick="location.href='/admin'">REGRESAR AL MENÚ</button>
			<br>		
		
		</div>
</div>


</body>
</html>
