<!DOCTYPE html>
<html>
<head>
<title>Keywords</title>

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
	font-family: 'Roboto Condensed', sans-serif;
	margin: 50px;
	padding-top: 2%;
	padding-left: 5%;
	padding-right: 5%;
	padding-bottom: 2%;
	background-color: #FFF;
	opacity: .8;
}

.button {
	font-family: 'Roboto Condensed', sans-serif;
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

.volver-section{
	text-align: center;
	margin-right: auto;
	margin-left: auto;
}


.volver{
	align: center;
	font-family: 'Roboto Condensed', sans-serif;
    background-color: green;
    border: none;
    color: white;
    padding: 15px 25px;
    text-align: center;
    font-size: 16px;
    cursor: pointer;
}


table {
    font-family: 'Roboto Condensed', sans-serif;
    border-collapse: collapse;
    width: 80%;
}

th{
	width: 50%;
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


<body background="/resources/images/background_1.jpg">
<div id= "main-container">

<h2>KEYWORDS</h2>
<br/>
<button onclick="location.href='/addkeywords'" class="button createUser">+ Agregar nueva Keyword</button>

<br/><br/>
<table align ="center">

  <tr>
    <th>Keyword</th>
    <th>Accion</th>
  </tr>
  

		<tr>
			<td>Coca Cola</td>
			<th>
			
				<form action="/editkeyword" method="get">
                	<input type="hidden" name="keyword" value="keyword-1" />
                	<button class="btn edit">Editar Keyword</button>
            	</form>

				<form action="/deletekeyword" method="get">
                	<input type="hidden" name="keyword" value="keyword-1" />
                	<button class="btn delete">Borrar Keyword</button>
            	</form>
			
			
			</th>
		</tr>
		
		<tr>
			<td>Coke</td>
			<th>
			
				<form action="/editkeyword" method="get">
                	<input type="hidden" name="keyword" value="keyword-1" />
                	<button class="btn edit">Editar Keyword</button>
            	</form>

				<form action="/deletekeyword" method="get">
                	<input type="hidden" name="keyword" value="keyword-1" />
                	<button class="btn delete">Borrar Keyword</button>
            	</form>
			
			
			</th>
		</tr>


</table>
<br/><br/>

<div class= "volver-section">
<button onclick="location.href='/admin'" class="volver"> REGRESAR AL MENÚ </button>
			<br>
</div>


</div>


</body>
</html>
