package com.bancodigital.investimentos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CDB extends Investimento {
	
	private static final double CDI = 0.0639; // 6.39%
	
	private double taxaContratadaCDI; // colocar 120 equivale a 120%

	public CDB(LocalDate inicial, LocalDate vencimento, double valorAplicado, double taxaContratadaCDI) {
		super(inicial, vencimento, valorAplicado);
		this.taxaContratadaCDI = taxaContratadaCDI;

	}
	// vencimento em anos - 2, 3, 4...
	public void depositar(double valor, int anosContratados) {
		this.saldo += valor;
		this.inicial = LocalDate.now();
		this.vencimento = LocalDate.now().plusYears(anosContratados);
	}
	
	public void sacar(double valor) {
		calcularSaldo();
		this.saldo -= valor;		
	}
	
	public void calcularSaldo() {
		
		double rendimento = calcularRendimento();		
		this.saldo += rendimento;
		System.out.println("Valor Investido no CDB: "+ this.saldo);	
	}

	public double calcularRendimento() {

		double rendimento = 0; // = this.saldo * (CDI * (taxaContratadaCDI / 100));
		
		LocalDate hoje = LocalDate.now();

		if(!hoje.isBefore(vencimento)) {
			long anosPassados = ChronoUnit.YEARS.between(inicial, vencimento);		
			rendimento = this.saldo * (CDI * (taxaContratadaCDI / 100)) * anosPassados;	
			
			//zerar o cdb e depositar na conta corrente
		} else {
			long anosPassados = ChronoUnit.YEARS.between(inicial, hoje);		

			if(anosPassados > 0) {
				rendimento = this.saldo * (CDI * (taxaContratadaCDI / 100)) * anosPassados;	
			}
		}
		//calcularSaldo();
		return this.saldo += rendimento;
	}	


}
 