package com.bancodigital.cliente;

import java.util.ArrayList;
import java.util.List;

import com.bancodigital.conta.ContaCorrente;
import com.bancodigital.investimentos.Investimento;

public class Cliente {
	
	private String nome;
	private List<Investimento> investimentos;
	private ContaCorrente contaCorrente;

	public Cliente() {
		this.investimentos = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Investimento> getInvestimentos() {
		return investimentos;
	}

	public void setContaCorrente(ContaCorrente contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

	public void adicionarInvestimento(Investimento investimento) {
		this.investimentos.add(investimento);
	}

	public void investir(Investimento investimento, double valor) {
        if (contaCorrente.getSaldo() >= valor) {
            contaCorrente.sacar(valor);
            investimento.setSaldo(valor);
            adicionarInvestimento(investimento);
        } else {
            System.out.println("Saldo insuficiente na conta corrente.");
        }
    }

	public void imprimirExtratoInvestimentos() {
		System.out.println("Cliente: " + this.nome);
        System.out.println("******* Investimentos *******");
        for (Investimento investimento : this.investimentos) {
            System.out.println("Tipo: " + investimento.getClass().getSimpleName());
            System.out.println("Rendimento: " + investimento.calcularRendimento());
        }
	}
}
