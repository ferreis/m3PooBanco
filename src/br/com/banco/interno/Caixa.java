package br.com.banco.interno;

import br.com.banco.exception.IdBancoInvalidoException;

import java.util.LinkedList;
import java.util.List;

public class Caixa {
    List<Banco> bancos;
    List<Conta> contas;

    public Caixa() {
        this.bancos = new LinkedList<>();
        this.contas = new LinkedList<>();
    }

    public void criarConta(Conta conta) {
        bancos.get(conta.idBanco).novaConta(new Conta(conta));
    }

    public List<String> listaBanco() {
        List<String> lista = new LinkedList<>();
        for (int x = 0; bancos.size() > x; x++) {
            lista.add("ID " + x + " " + bancos.get(x));
        }
        return lista;
    }
    public String nomeBanco(int id){
        return bancos.get(id).nomeBanco;
    }

    public int verificarIdBanco(int idBanco) throws IdBancoInvalidoException {
        for (int x = 0; x < bancos.size(); x++) {
            Banco novoBanco = bancos.get(x);
            if (novoBanco != null && novoBanco.idBanco == bancos.get(x).idBanco) {
                return x;
            }
        }
        throw new IdBancoInvalidoException();
    }

}
