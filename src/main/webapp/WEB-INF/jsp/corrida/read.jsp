<%@include file="../templates/body.jsp"%>
<%@include file="../templates/menu.jsp"%>

<div>
	<div>
		<form name = "form" method = "post" action = "${linkTo[CorridaController].create}" onsubmit="return validateCorridaForm()" >
			<input type = "hidden" name = "id" value = "${corrida.id}"/><br /> 
			<label for = "motorista">Motorista</label>
			<select id = "motorista" name = "motoristaId">
				<option value = "-1" selected>Selecione</option>
				<c:forEach items = "${motoristas}" var="motorista">
					<c:if test="${motorista.status ne 'I'.charAt(0)}">
						<option value = "${motorista.id}">${motorista.nome}</option>
					</c:if>
				</c:forEach>
			</select><br />
			<label for = "passageiro">Passageiro</label>
			<select id = "passageiro" name = "passageiroId">
				<option value = "-1" selected>Selecione</option>
				<c:forEach items="${passageiros}" var="passageiro">
					<option value="${passageiro.id}">${passageiro.nome}</option>
				</c:forEach>
			</select><br />
			<label for="valor">Valor:</label> <input id="valor" type="text" name="valorCorrida" /><br /> 
	        <input type="submit" value="Cadastrar" />
		</form>
	</div>

	<table>
		<tr>
			<th>Motorista</th>
			<th>Passageiro</th>
			<th>Valor</th>
		</tr>

		<c:forEach items="${corridaList}" var="corrida">
			<tr>
				<td>${corrida.motorista.nome}</td>
				<td>${corrida.passageiro.nome}</td>
				<td>${corrida.valor}</td>
			</tr>
		</c:forEach>
	</table>
</div>

</body>
</html>