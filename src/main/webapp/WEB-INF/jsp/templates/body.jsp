<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${head}</title>
</head>
<body>
	<script>
		function validateform() {
			var nome = document.form.nome.value;
			var data = document.form.data.value;
			var cpf = document.form.cpf.value;
			var sexo = document.form.sexo.value;
			var status = document.form.status.value;
			var modelo = document.form.modelo.value;
				
			if(isFieldEmptyOrNull(nome)) {
				alert("Por Favor, preencha nome");
				document.form.nome.focus();
				return false;
			}
		
			if(!isValidDate(data)) {
				alert("Por Favor, preencha data");
				document.form.data.focus();
				return false;
			}
			
			if(!valida_cpf(cpf)) {
				alert("Por Favor, preencha CPF sem símbolo");
				document.form.cpf.focus();
				return false;
			}
			
			if(isFieldEmptyOrNull(sexo)) {
				alert("Por Favor, preencha sexo");
				document.form.sexo.focus();
				return false;
			}
			
			if(isFieldEmptyOrNull(status)) {
				alert("Por Favor, preencha status");
				document.form.status.focus();
				return false;
			}
			
			if(isFieldEmptyOrNull(modelo)) {
				alert("Por Favor, preencha Modelo de carro");
				document.form.modelo.focus();
				return false;
			}
		}	
		
		function valida_cpf(cpf) {
			if(isFieldEmptyOrNull(cpf))
				return false;
			
			var numeros, digitos, soma, i, resultado, digitos_iguais;
		    digitos_iguais = 1;
		    
		    if(hasValidLength(cpf))
		    	return false;
		    
		    for (i = 0; i < cpf.length - 1; i++)
		    	if (cpf.charAt(i) != cpf.charAt(i + 1)) {
					digitos_iguais = 0;
		            break;
			}
		    
		    if (!digitos_iguais) {
				numeros = cpf.substring(0,9);
		        digitos = cpf.substring(9);
		        soma = 0;
		        for (i = 10; i > 1; i--)
		        	soma += numeros.charAt(10 - i) * i;
		        
		        resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
		        if(resultado != digitos.charAt(0))
		        	return false;
		            
		       	numeros = cpf.substring(0,10);
		        soma = 0;
		        for (i = 11; i > 1; i--)
		        	soma += numeros.charAt(11 - i) * i;
		        
		        resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
		        if (resultado != digitos.charAt(1))
		        	return false;
		        
		        return true;
		    }
		    else
		    	return false;
		}
		
		function hasValidLength(cpf) {
			return cpf.length < 11;
		}
		
		function isValidDate(data) {
			
			if(isValidDateFormat(data)) {
				var dateArray = getDigits(data);
				  
				var day = parseInt(dateArray[0]);
				var month = parseInt(dateArray[1]);
				var year = parseInt(dateArray[2]);
				  
				var daysOfMonth = [31,28,31,30,31,30,31,31,30,31,30,31];
				if (month == 1 || month > 2) {
					if (day > daysOfMonth[month - 1])
				  		return false;
				  
				if (month == 2) 
					return isValidFebuary(day, year);
				}
				else {
					return false;
				}
			
				return true;
			}
		}
			
		function getDigits(data) {
			var opera1 = data.split('/');
			var opera2 = data.split('-');
			
			lopera1 = opera1.length;
			lopera2 = opera2.length;
			
			var pdate;
			if (lopera1 > 1)
				pdate = data.split('/');
			else if (lopera2 > 1)
				pdate = data.split('-');	
			
			return pdate;
		}
		
		function  isValidDateFormat(data) {
			var dateformat = /^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/;
			return data.match(dateformat);
		}
		
		function isValidFebuary(day, year) {
			var leapYear = false;
		  	if ( (!(year % 4) && year % 100) || !(year % 400)) {
		  		leapYear = true;
		  	}
		  	if ((leapYear == false) && ( day >= 29)) {
		  		return false;
		  	}
		  	if ((leapYear == true) && (day > 29)) {
		  		return false;
		  	}
		}
		
		function isFieldEmptyOrNull(field) {
			return field == null || field == ""; 
		}
	</script>

	<h2>${head}</h2>