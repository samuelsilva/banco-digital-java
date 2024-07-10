package com.bancodigital.testes;

import com.bancodigital.cliente.Cliente;
import com.bancodigital.conta.Conta;
import com.bancodigital.conta.ContaCorrente;
import com.bancodigital.conta.ContaPoupanca;

public class TesteConta {
    
    public static void main(String[] args) {
        Cliente samuel = new Cliente();
        samuel.setNome("Samuel Dario");

        Conta cc = new ContaCorrente(samuel);
        Conta cp = new ContaPoupanca(samuel);
        
        cc.depositar(50.00);
        System.out.println("Saldo da conta corrente é:" + cc.getSaldo());
        cc.sacar(15.00);
        System.out.println("Saldo da conta corrente é:" + cc.getSaldo());
        

        cp.depositar(100.00);
        cp.transferir(15.00, cc);

        cc.imprimirExtrato();
        cp.imprimirExtrato();

    }
}
