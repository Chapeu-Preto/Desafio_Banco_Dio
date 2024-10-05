package com.banco_dio.deafio;

public class Cliente {
	
	private static int counter = 1;
	private String nome;
	private String cpf;
	private String endereco;
	private String email;
	private int contato;
	
	public Cliente(String nome, String cpf, String endereco, int contato, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.email = email;
		this.contato = contato;
		counter += 1;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public int getContato() {
		return contato;
	}

	public void setContato(int contato) {
		this.contato = contato;
	}
	
	public String toString() {
		return "\nNome: " + this.getNome() +
				"\nCPF: " + this.getCpf() +
				"\nEndereço: " + this.getEndereco() +
				"\nE-mail: " + this.getEmail() +
 				"\nContato: " + this.getContato();
		
	}
	
}
