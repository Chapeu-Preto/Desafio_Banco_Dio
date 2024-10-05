package com.banco_dio.deafio;

public class ContaCorrente extends Conta{
	 
	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}
	
	public void imprimirExtrato() {
		System.out.println("     Extrato Conta Corrente     ");
		System.out.println("Titular: " + this.getCliente().getNome());
		System.out.println("Agência: " + this.getAgencia());
		System.out.println("Conta: " + this.getConta());
		System.out.println("                                        ");
		System.out.println("Saldo: " + this.getSaldo());
	}
	
}
