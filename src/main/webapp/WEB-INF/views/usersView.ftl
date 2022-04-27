<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>viewpage</title>
</head>
<body>
	<table>
		<tr>
			<th>id</th>
			<th>name</th>
		</tr>
		<#list users as user>
			<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
			</tr>
		</#list>
	</table>
</body>
</html>