package br.com.banco.interno;

import java.util.Random;

public class Conta extends Banco {
    protected Movimentacao[] movimentacoes;
    protected boolean especial;
    protected double limite;
    protected double saldo;
    protected int numero;

    public Conta(Conta conta) {
        super(conta.nomeBanco, conta.idBanco);
        Random gerador = new Random();
        int rand = gerador.nextInt(1000, 9999);
        for (int x = 0; x < contas.size(); x++) {
            if (contas.get(x).numero!=rand){
                this.numero = rand;
            }
        }
        this.movimentacoes = new Movimentacao[1000];
        this.saldo = conta.saldo;
        this.criarMovimentacao("saldo inicial", saldo);
    }


    public boolean depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            this.criarMovimentacao("deposito", valor);
            return true;
        }
        return false;
    }

    public boolean sacar(double valor) {
        if (valor <= this.saldo + this.limite) {
            this.saldo -= valor;
            this.criarMovimentacao("saque", valor * -1);
            return true;
        }
        return false;
    }

    private void criarMovimentacao(String descricao, double valor) {
        for (int x = 0; x < movimentacoes.length; x++) {
            if (movimentacoes[x] == null) {
                movimentacoes[x] = new Movimentacao(descricao, valor);
                break;
            }
        }
    }


    private class Movimentacao {
        private String descricao;
        private double valor;

        public Movimentacao(String descricao, double valor) {
            this.descricao = descricao;
            this.valor = valor;
        }

        public String resumo() {
            return this.descricao + " R$ " + this.valor;
        }

    }
}
