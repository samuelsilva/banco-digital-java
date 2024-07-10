package com.bancodigital.testes;

import java.time.LocalDate;
import java.util.ArrayList;

import com.bancodigital.banco.Banco;
import com.bancodigital.cliente.Cliente;
import com.bancodigital.conta.Conta;
import com.bancodigital.conta.ContaCorrente;
import com.bancodigital.conta.ContaPoupanca;
import com.bancodigital.investimentos.CDB;

public class TesteContaCliente {

    public static void main(String[] args) {
        Banco banco = new Banco();
        banco.setNome("Banco Digital DIO");

        Cliente cliente1 = new Cliente();
        cliente1.setNome("João");
        ContaCorrente contaCorrente1 = new ContaCorrente(cliente1);
        cliente1.setContaCorrente(contaCorrente1);
        contaCorrente1.depositar(3000.00);
        Conta contaPoupanca1 = new ContaPoupanca(cliente1);
        contaCorrente1.transferir(1000.00, contaPoupanca1);

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Maria");
        ContaCorrente contaCorrente2 = new ContaCorrente(cliente2);
        cliente2.setContaCorrente(contaCorrente2);
        contaCorrente2.depositar(2000);

        banco.setContas(new ArrayList<>());
        banco.getContas().add(contaCorrente1);
        banco.getContas().add(contaCorrente2);

        // Investindo em CDB e Fundo
        CDB cdb1 = new CDB(LocalDate.now(), LocalDate.now().plusYears(1), 0, 120);
        cliente1.investir(cdb1, 1000);

        //Fundo fundo1 = new Fundo(LocalDate.now(), LocalDate.now().plusYears(1), 0, 10);
        //cliente1.investir(fundo1, 500);

        CDB cdb2 = new CDB(LocalDate.now(), LocalDate.now().plusYears(1), 0, 130);
        cliente2.investir(cdb2, 1500);

        contaCorrente1.imprimirExtrato();
        contaPoupanca1.imprimirExtrato();
        cliente1.imprimirExtratoInvestimentos();
        contaCorrente2.imprimirExtrato();
        cliente2.imprimirExtratoInvestimentos();

        System.out.println("Valor total investido em CDBs no banco: " + banco.calcularTotalCDBs());
    }
}
