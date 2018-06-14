<html>

<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

h1, h2{
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
    width: 10%;
	border-radius: 50%;
}

.container {
    display: block;
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

<body>
	
	<div class="container" align="center">
	<h1>Buscar una Keyword</h1>
		<div class="form">
		
			<font color="red">${errorMessage}</font>
			<form method="post" action="/creationofkeyword">
				            <p>
                <label for="keyword"><b>Ingrese Keyword</b></label> <input
                    type="text" placeholder="Ingrese Keyword"
                    name="keyword" required>
            <p>
               

			<p></p>
            <button type="submit">BUSCAR KEYWORD</button>

			</form>
		</div>
	</div>

</body>


</html>