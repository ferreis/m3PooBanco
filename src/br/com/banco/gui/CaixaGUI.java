package br.com.banco.gui;

import br.com.banco.interno.Banco;
import br.com.banco.interno.Caixa;
import br.com.banco.interno.Conta;

import java.util.List;
import java.util.Scanner;

public class CaixaGUI {

    Caixa caixas;
    Banco bancos;
    Conta contas;

    public CaixaGUI(Banco banco) {
        this.bancos = banco;
    }

    public String lerValor(String rotulo) {
        System.out.print(rotulo + ": ");
        Scanner leitura = new Scanner(System.in);
        return leitura.nextLine();
    }

    public void iniciarAtendimento() {
        try {
            int opcao;
            do {
                System.out.println("Caixa");
                System.out.println("Opções:");
                System.out.println("[1] Depositar");
                System.out.println("[2] Sacar");
                System.out.println("[3] Transferir");
                System.out.println("[4] Criar Conta");
                System.out.println("[5] Cadastrar Banco");
                opcao = Integer.parseInt(this.lerValor("Digite uma opcao"));
                switch (opcao) {
                    case 0 -> this.preset();
                    case 1 -> this.listaConta();
                    case 2 -> this.listaBanco();
                    //case 3 -> this.transferir();
                    //case 4 -> this.criarConta();
                    //case 5 -> this.cadastrarBanco();
                }
            } while (opcao != 6);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    private void criarConta(){
        int id = Integer.parseInt(this.lerValor("Digite o número de identificação: "));
        String nome = caixas.nomeBanco(id);
        double limite = Double.parseDouble(lerValor("Digite o limete: "));
        double saldo = Double.parseDouble(lerValor("Digite o saldo inicial"));
        caixas.criarConta(new Conta(limite,saldo,id,nome));
    }

    public void listaBanco() {
        List<String> lista = caixas.listaBanco();
        for (String conta : lista) {
            System.out.println(conta);
        }
    }

    public void listaConta() {
        List<String> lista = bancos.listConta();
        for (String conta : lista) {
            System.out.println(conta);
        }
    }

    private void preset() {
        try {
            caixas.presetCaixa();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

}