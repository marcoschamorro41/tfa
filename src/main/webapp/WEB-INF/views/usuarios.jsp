<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.mysql.cj.jdbc.MysqlDataSource"%>
<%@page import="com.tfa.connectors.DataBaseManager"%>
<%@page import="com.tfa.connectors.SQLClient"%>


<!DOCTYPE html>
<html>
<head>
<title>Usuario</title>

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
    width: 100%;
}

th{
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

<h2>ADMINISTRACIÓN DE USUARIOS</h2>
<h2> </h2>
<button onclick="location.href='/usercreation'" class="button createUser">+ Crear Usuario</button>

<br/><br/>
<table>

  <tr>
    <th>Usuario</th>
    <th>Empresa</th>
    <th>Rol</th>
    <th>Accion</th>
  </tr>
  
  


<%
try {
	
	MysqlDataSource dataSource = DataBaseManager.getMysqlDataSource();
	String query = "SELECT * FROM usuarios";
	Connection conn = dataSource.getConnection();
	PreparedStatement statement = conn.prepareStatement(query);
	ResultSet rs = statement.executeQuery();
	
	while (rs.next()) {
		
		%>
		
		<tr>
			<td><%=rs.getString("username") %></td>
			<td><%=rs.getString("company") %></td>
			<td><%=rs.getString("rol") %></td>
			<th>
			
				<form action="/edituser" method="get">
                	<input type="hidden" name="username" value="<%=rs.getString("username") %>" />
                	<button class="btn edit">Editar</button>
            	</form>

				<form action="/deleteuser" method="get">
                	<input type="hidden" name="username" value="<%=rs.getString("username") %>" />
                	<button class="btn delete">Borrar</button>
            	</form>
			
			
			</th>
		</tr>
		
		<%
	}
	
	rs.close();
	statement.close();
	conn.close();

} catch (SQLException e) {
	e.printStackTrace();
}
%>


</table>
<br/><br/>

<div class= "volver-section">
<button onclick="location.href='/admin'" class="volver"> REGRESAR AL MENÚ </button>
			<br>
</div>


</div>


</body>
</html>
