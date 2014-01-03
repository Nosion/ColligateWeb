<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Flot Examples: Categories</title>
	<link href="css/examples.css" rel="stylesheet" type="text/css">

	<script language="javascript" type="text/javascript" src="js/jquery.js"></script>
	<script language="javascript" type="text/javascript" src="js/jquery.flot.js"></script>
	<script language="javascript" type="text/javascript" src="js/jquery.flot.categories.js"></script>
	<%@ page import="dk.qwn.colligate.dbquery"%>
	<%@ page import="java.sql.Connection,java.sql.DriverManager,java.sql.ResultSet,java.sql.SQLException,java.sql.Statement,java.util.ArrayList,java.util.List;" %>
	<% dbquery hej = new dbquery();	%>
	
	<script type="text/javascript">
	
$(function() {

	var data = <% out.print(dbquery.getGraphString()); %>;	
		
		
	$.plot("#placeholder", [ data ], {
		series: {
			bars: {
				show: true,
				barWidth: 0.6,
				align: "center"
			}
		},
		xaxis: {
			mode: "categories",
			tickLength: 0
		}
	});

	// Add the Flot version string to the footer

	$("#footer").prepend("Flot " + $.plot.version + " &ndash; ");
});
</script>

</head>
<body>

<div id="header">
	<h2>Categories</h2>
</div>

<div id="content">

	<div class="demo-container">
		<div id="placeholder" class="demo-placeholder"></div>
	</div>

	<p>With the categories plugin you can plot categories/textual data easily.</p>

</div>

<div id="footer">
	Copyright &copy; 2007 - 2013 IOLA and Ole Laursen
</div>
<% out.print(dbquery.getGraphString()); %>
</body>
</html>