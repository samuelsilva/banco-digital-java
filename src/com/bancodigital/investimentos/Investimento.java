package com.bancodigital.investimentos;

import java.time.LocalDate;

public abstract class Investimento {
    protected LocalDate inicial;
    protected LocalDate vencimento;
    protected double saldo;
    
    public Investimento(LocalDate inicial, LocalDate vencimento, double saldo) {
        this.inicial = inicial;
        this.vencimento = vencimento;
        this.saldo = saldo;
    }

    public abstract double calcularRendimento();

    public LocalDate getInicial() {
        return inicial;
    }

    public void setInicial(LocalDate inicial) {
        this.inicial = inicial;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    
}
