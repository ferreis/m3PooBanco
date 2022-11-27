package br.com.banco.interno;

public abstract class  Transacao extends Banco{
    public Transacao(String nomeBanco, int idBanco) {
        super(nomeBanco, idBanco);
    }
    public abstract boolean transferir(int numeroContaOrigem, int numeroContaDestino, double valor);

}
