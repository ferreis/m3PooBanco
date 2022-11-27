package br.com.banco.interno;

public class Saque extends Transacao{
    public Saque(String nomeBanco, int idBanco) {
        super(nomeBanco, idBanco);
    }

    @Override
    public boolean transferir(int numeroContaOrigem, int numeroContaDestino, double valor) {
        return false;
    }
}
