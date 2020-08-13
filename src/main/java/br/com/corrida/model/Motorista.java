package br.com.corrida.model;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Motorista {
	
	@Deprecated
	public Motorista() {
	}
	
	@Id @GeneratedValue
	private Long id;
	
	private String nome;
	
	private LocalDate dataNascimento;
	
	private String cpf;
	private String modeloCarro;
	private Character sexo;
	private Character status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getModeloCarro() {
		return modeloCarro;
	}
	public void setModeloCarro(String modeloCarro) {
		this.modeloCarro = modeloCarro;
	}
	public Character getSexo() {
		return sexo;
	}
	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}
	public Character getStatus() {
		return status;
	}
	public void setStatus(Character status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Motorista "  
				 + "[id=" + id 
				+ ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", cpf=" + cpf
				+ ", modeloCarro=" + modeloCarro + ", sexo=" + sexo + ", status=" + status + "]";
	}
	
	
}
