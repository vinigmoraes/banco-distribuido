package model;

public class Cliente {

    private String nome;
    private Long saldo;
    private String conta;

    public Cliente(String nomeDoCliente, long saldoDoCliente, String conta){
        this.nome = nomeDoCliente;
        this.saldo = saldoDoCliente;
        this.conta = conta;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getSaldo() {
        return saldo;
    }

    public void setSaldo(Long saldo) {
        this.saldo = saldo;
    }
}
