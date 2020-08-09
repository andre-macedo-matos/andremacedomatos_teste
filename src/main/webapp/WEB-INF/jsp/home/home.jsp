<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${head}</title>
</head>
<body>
	<h2>${head}</h2>
	
	<b>Menu</b>
	<ul>
		<li><a href = "${linkTo[HomeController].home}">Home</a></li>
		<li><a href = "${linkTo[MotoristaController].home}">Motoristas</a></li>
		<li><a href = "${linkTo[PassageiroController].home}">Passageiros</a></li>
		<li><a href = "${linkTo[CorridaController].home}">Corridas</a></li>
	</ul>
</body>
</html>