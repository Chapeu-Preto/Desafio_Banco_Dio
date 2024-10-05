package com.banco_dio.deafio;

import utilitarios.Utils;

public abstract class Conta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIA = 1;

	private int agencia;
	private int conta;
	private double saldo = 0.0;
	private Cliente cliente;
	
	public Conta (Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.conta = SEQUENCIA++;
		this.cliente = cliente;
	}


	public void transferir (Conta contaParaDeposito, Double valor, IConta contaDestino) {
		if (valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			
			contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
			System.out.println("Transferencia Realizada com sucesso.");
		} else {
			System.out.println("Não foi possível realizar a tranferência.");
		}
		
	}

	
	public void sacar (Double valor) {
		
		if (valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			System.out.println("Saque realizado com sucesso.");
		} else {
			System.out.println("Saldo insufuciente");
		}
	}
	
	public void depositar (Double valor) {
		
		if (valor > 0) {
			setSaldo(getSaldo() + valor);
			System.out.println("Deposito realizado com sucesso.");
		} else {
			System.out.println("Não fi possível realizar o deposito.");
		}
	}
	
	public void transferir (Conta contaDestino, Double valor) {
		
		if (valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			
			contaDestino.saldo = contaDestino.getSaldo() + valor;
			System.out.println("Treansferência realizada com sucesso.");
		} else {
			System.out.println("Não fi possível realizar a transferência.");
		}
		
	}
	
	public void imprimirExtrato () {
		
	}
	
	public String toString() {
		return "\nNúmero da Conta: " + this.getConta() +
	            "\nNome: " + this.cliente.getNome() +
	            "\nCPF: " + this.cliente.getCpf() +
	            "\nE-mail: " + this.cliente.getEmail() +
	            "\nEndereço: " + this.cliente.getEndereco() +
	            "\nContato: " + this.cliente.getContato() +
	            "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
	            "\n";
	}

	
	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
