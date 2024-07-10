package com.bancodigital.conta;

import com.bancodigital.cliente.Cliente;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirExtrato() {

		System.out.println("=== Extrato Conta Poupanca ===");
		super.imprimirInformacoesComuns();		
	}
	

}
