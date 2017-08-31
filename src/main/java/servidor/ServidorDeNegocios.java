package servidor;

public interface ServidorDeNegocios {

    void deposito(int conta, int quantidade);

    void saque(int conta, int quantidade);

    int saldo(int conta);

    void transferencia(int contaOrigem, int contaDestino, int valor);

}
