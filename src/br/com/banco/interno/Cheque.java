package br.com.banco.interno;

public class Cheque extends Transacao{
    public Cheque(String nomeBanco, int idBanco) {
        super(nomeBanco, idBanco);
    }

    @Override
    public boolean transferir(int numeroContaOrigem, int numeroContaDestino, double valor) {
        return false;
    }
}
