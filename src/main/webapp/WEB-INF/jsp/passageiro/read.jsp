<%@include file="../templates/body.jsp"%>
<%@include file="../templates/menu.jsp"%>

<div>
	<div>
		<form name = "form" method = "post" action="${linkTo[PassageiroController].create}" onsubmit="return validatePassageiroForm()" >
			<input type = "hidden" name="id" value="${passageiro.id}"/><br /> 
			<label for = "nome">Nome:</label> <input id="nome" type="text" name="passageiro.nome" /><br /> 
			<label for = "data">Data de Nascimento:</label> <input id = "data" type = "text" name = "passageiro.dataNascimento"/><br />
			<label for = "cpf">CPF:</label> <input id = "cpf" type = "text" name = "passageiro.cpf"/><br />
			<label for = "sexo">Sexo:</label>
			<select id = "sexo" name = "passageiro.sexo">
				<option value="F">Feminino</option>
				<option value="M">Masculino</option>
			</select><br />
	        <input type="submit" value="Cadastrar" />
		</form>
	</div>

	<table>
		<tr>
			<th>Nome</th>
			<th>Data de Nascimento</th>
			<th>CPF</th>
			<th>Sexo</th>
		</tr>

		<c:forEach items="${passageiroList}" var="passageiro">
			<tr>
				<td>${passageiro.nome}</td>
				<td>${passageiro.dataNascimento}</td>
				<td>${passageiro.cpf}</td>
				<td>${passageiro.sexo}</td>
			</tr>
		</c:forEach>
	</table>
</div>

</body>
</html>