
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Keyword Guardado</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  .card {
	max-width: 300px;
	margin: auto;
	text-align: center;
	font-family: arial;
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
<body>

<div class="container">
  <h2>En hora buena!</h2>
  <div class="alert alert-success">
    <strong>Keyword guardado con éxito!</strong>
    	<p> </p>
    	<p>El Keyword es: ${keyword}</p>
		<p>El Limite es: ${limite}</p>
		<p>La empresa es: ${corporate}</p>
  </div>

</div>
<div class="card">
    <p>
			<button onclick="location.href='/keywords'">Regresar a Keywords</button>
		</p>
    <p>
			<button onclick="location.href='/admin'">Regresar al menu principal</button>
		</p>
		
		</div>
</body>
</html>