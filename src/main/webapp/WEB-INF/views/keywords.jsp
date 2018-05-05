<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Static content -->
<link rel="stylesheet" href="/resources/css/style.css">
<script type="text/javascript" src="/resources/js/app.js"></script>

<title>Keywords</title>
</head>


<body>
	<h1>Keywords</h1>
	<div id="formulario">
		<div class="form">
			<font color="red">${errorMessage}</font>
			<form method="post">
				<a>Keyword: <input type="text" name="keyword" /></a><br> <br>
				<a>Limit: <input type="text" name="limit" />
				</a>
				<hr>
				<input type="submit" />
			</form>
		</div>
	</div>
</body>
</html>