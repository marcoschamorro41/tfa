
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Keyword Guardado</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed" rel="stylesheet">
  
<style>
  
body {
	font-family: 'Roboto Condensed', sans-serif;
}

.container{
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
 
.card {
	max-width: 300px;
	margin: auto;
	text-align: center;
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

</style>
</head>


<body background="/resources/images/background_1.jpg">
<div class="container">
  <h2>En hora buena!</h2>
  <div class="alert alert-success">
    <strong>Keyword guardado con éxito!</strong>
    	<p> </p>
    	<p>El Keyword es: ${keyword}</p>
		<p>El Limite es: ${limite}</p>
		<p>La empresa es: ${corporate}</p>
  </div>


<div class="card">
    <p>
			<button onclick="location.href='/keywords'">Regresar a Keywords</button>
		</p>
    <p>
			<button onclick="location.href='/admin'">Regresar al menu principal</button>
		</p>
		
</div>
</div>
</body>
</html>