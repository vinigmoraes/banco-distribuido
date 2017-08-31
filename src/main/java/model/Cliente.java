package model;

public class Cliente {

    private String nome;
    private int saldo;
    private int conta;

    public Cliente(String nomeDoCliente, int saldoDoCliente, int conta){
        this.nome = nomeDoCliente;
        this.saldo = saldoDoCliente;
        this.conta = conta;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
