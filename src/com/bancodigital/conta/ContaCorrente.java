package com.bancodigital.conta;

import com.bancodigital.cliente.Cliente;

public class ContaCorrente extends Conta {

	
	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Corrente ===");
		super.imprimirInformacoesComuns();
	}

	
}
