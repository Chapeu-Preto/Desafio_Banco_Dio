package com.banco_dio.deafio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco {
	
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Conta> contasBancarias;
	
	public static void main (String [] args) {
		contasBancarias = new ArrayList<Conta>();
		operacoes();
	}
	
	public static void operacoes() {
		
		System.out.println("                                            ");
		System.out.println("          Bem Vindo ao Banco Dio.ME         ");
		System.out.println("                                            ");
		System.out.println("        Escolha uma das opções abaixo       ");
		System.out.println("                                            ");
		System.out.println("  1 - Criar conta                           ");
		System.out.println("  2 - Depositar                             ");
		System.out.println("  3 - Sacar                                 ");
		System.out.println("  4 - Transfêrir                            ");
		System.out.println("  5 - Consultar saldo conta                 ");
		System.out.println("  6 - Sair                                  ");
		
		int operacao = scan.nextInt();
		
		switch(operacao) {
		case 1 :
			criarConta();
			break;
		case 2:
			depositar();
			break;
		case 3:
			sacar();
			break;
		case 4:
			transferir();
			break;
		case 5:
			listarContas();
			break;
		case 6:
			System.out.println("Operação finalizada, até a próxima !");
			System.exit(operacao);
		default:
			System.out.println("Opção invalida, escolha uma opção disponível.");
			operacoes();
			break;
		}
	}
	
	public static void listar() {
		
	}

	public static void criarConta () {
		
		System.out.println("Nome: ");
		String nome = scan.next();
		scan.nextLine();
		
		System.out.println("CPF: ");
		String cpf = scan.next();
		scan.nextLine();
		
		System.out.println("Endereço: ");
		String endereco = scan.nextLine();
		
		System.out.println("Contato: ");
		int contato = scan.nextInt();
		scan.nextLine();
		
		System.out.println("E-mail: ");
		String email = scan.next();
		scan.nextLine();
		
		Cliente cliente = new Cliente(nome, cpf, endereco, contato, email);
		
		System.out.println("Escolha um tipo de Conta: ");
		System.out.println("1 - Conta Corrente ");
		System.out.println("2 - Conta Poupança ");
		
		int tipoConta = scan.nextInt();
		scan.nextLine();
		
		Conta novaConta = null;
		
		if (tipoConta == 1) {
			novaConta = new ContaCorrente(cliente);
		} else if (tipoConta == 2) {
			novaConta = new ContaPoupanca(cliente);
		} else {
			System.out.println("Opção invalida escolha entre 1 ou 2.");
			criarConta();
			return;
		}
		
		contasBancarias.add(novaConta);
		System.out.println("sua conta foi criada com sucesso !");
		
		operacoes(); 
	}
	
	private static Conta encontrarConta(int numeroConta) {
		Conta conta = null;
		if (contasBancarias.size()> 0) {
			for (Conta c: contasBancarias) {
				if (c.getConta() == numeroConta)
				conta = c;
			}
		}
		return conta;
	}
	
	public static void depositar() {
		System.out.println("Digite o número da conta: ");
		int numeroConta = scan.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
		
		if (conta != null) {
			System.out.println("Quanto deseja depositar: ");
			Double valorDeposito = scan.nextDouble();
			conta.depositar(valorDeposito);
			System.out.println("Valor depositado com sucesso !");
		} else {
			System.out.println(" conta não encontrada !");
		}
		operacoes();
	}
	
	public static void sacar () {
		System.out.println("Digite o número da: ");
		int numeroConta = scan.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
		
		if (conta != null) {
			System.out.println("Quanto deseja sacar: ");
			Double valorSaque = scan.nextDouble();
			conta.sacar(valorSaque);
			System.out.println("Saque realizado com sucesso.");
		} else {
			System.out.println("Conta não encontrada.");
		}
		operacoes();
	}
	
	public static void transferir () {
		System.out.println("Digite conta remetente: ");
		int numeroContaRemetente = scan.nextInt();
		
		Conta contaRemetente = encontrarConta(numeroContaRemetente);
		
		if (contaRemetente != null) {
			System.out.println("Digite a conta de destino: ");
			int numeroContaDestinatario = scan.nextInt();
			
			Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
			
			if (contaDestinatario != null) {
				System.out.println("Quanto deseja transferir: ");
				Double valor = scan.nextDouble();
				
				contaRemetente.transferir(contaDestinatario, valor);
			} else {
				System.out.println("Conta destinatário não encontrada.");
			}
		} else {
			System.out.println("Conta remetente não encontrada.");
		}
		operacoes();
	}
	
	public static void listarContas () {
		if (contasBancarias.size() > 0) {
			for (Conta conta: contasBancarias) {
				System.out.println(conta);
			}
		} else {
			System.out.println("Não existe contas cadastradas.");
		}
		operacoes();
	}
	
}
 