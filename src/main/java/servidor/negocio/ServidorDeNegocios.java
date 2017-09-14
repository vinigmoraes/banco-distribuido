package servidor.negocio;

public interface ServidorDeNegocios {

    String deposito(int conta, int quantidade);

    String saque(int conta, int quantidade);

    int saldo(Integer conta);

    String transferencia(Integer contaOrigem, Integer contaDestino, Integer valor) throws InterruptedException;

}
