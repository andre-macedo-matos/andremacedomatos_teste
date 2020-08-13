<%@include file="../templates/body.jsp"%>
<%@include file="../templates/menu.jsp"%>

<div>
	<div>
		<form name="form" method="post" action="${linkTo[MotoristaController].create}" onsubmit="return validateform()" >
			<input type="hidden" name="id" value="${motorista.id}"/><br /> 
			<label for="nome">Nome:</label> <input id="nome" type="text" name="motorista.nome" /><br /> 
			<label for = "data">Data de Nascimento:</label> <input id = "data" type = "text" name = "motorista.dataNascimento"/><br />
			<label for = "cpf">CPF:</label> <input id = "cpf" type = "text" name = "motorista.cpf"/><br />
			<label for = "sexo">Sexo:</label>
			<select id = "sexo" name = "motorista.sexo">
				<option value="F">Feminino</option>
				<option value="M">Masculino</option>
			</select>
			<label for = "status">Status</label>
			<select id = "status" name = "motorista.status">
				<option value="A">Ativo</option>
				<option value="I">Inativo</option>
			</select><br>
			<label for = "modelo">Modelo de Carro:</label> <input id = "modelo" type = "text" name = "motorista.modeloCarro"/><br />
	        <input type="submit" value="Cadastrar" />
		</form>
	</div>

	<table>
		<tr>
			<th>Nome</th>
			<th>Data de Nascimento</th>
			<th>CPF</th>
			<th>Sexo</th>
			<th>Modelo do Carro</th>
			<th>Status</th>
		</tr>

		<c:forEach items="${motoristaList}" var="motorista">
			<tr>
				<td>${motorista.nome}</td>
				<td>${motorista.dataNascimento}</td>
				<td>${motorista.cpf}</td>
				<td>${motorista.sexo}</td>
				<td>${motorista.modeloCarro}</td>
				<td>${motorista.status eq 'A'.charAt(0) ? 'Ativo' : 'Inativo'}</td>
				<td>	
					<a href = "${linkTo[MotoristaController].update}?id=${motorista.id}&status=${motorista.status ne 'A'.charAt(0) ? 'A' : 'I'}">
						${motorista.status ne 'A'.charAt(0) ? 'Ativa?' : 'Inativa?'}
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>

</body>
</html>