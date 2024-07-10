package com.bancodigital.banco;

import java.util.List;

import com.bancodigital.cliente.Cliente;
import com.bancodigital.conta.Conta;
//import com.bancodigital.conta.ContaCorrente;
import com.bancodigital.investimentos.CDB;
import com.bancodigital.investimentos.Investimento;

public class Banco {
	
	private String nome;
	private List<Conta> contas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	public double calcularTotalCDBs() {
		double totalCDBs = 0.0;

		for(Conta conta : contas) {
			Cliente cliente = conta.getCliente();
			List<Investimento> investimentos = cliente.getInvestimentos();

			for(Investimento investimento : investimentos) {
				if(investimento instanceof CDB) {
					totalCDBs += investimento.getSaldo();
				}
			}
		}

		return totalCDBs;
	}
	/*
	public void fechamentoDia(List<ContaCorrente> contas) {
		// percorrer todas as contas correntes e verificar o total depositado em CC no dia
		 

	}
*/	
}
