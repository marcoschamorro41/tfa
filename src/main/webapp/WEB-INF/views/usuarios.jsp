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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>

.button {
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

table {
    font-family: arial, sans-serif;
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
<body>

<h2>Administracion de usuarios</h2>
<h2> </h2>
<button onclick="location.href='/usercreation'" class="button createUser">Crear Usuario</button>
<h2> </h2>
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

<h2></h2>


</body>
</html>
