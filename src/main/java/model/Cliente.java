package model;

public class Cliente {

    private Integer id;
    private String nome;
    private int saldo;
    private int conta;
    private String mensagem;

    public Cliente(Integer id, String nomeDoCliente, int saldoDoCliente, int conta){
        this.nome = nomeDoCliente;
        this.saldo = saldoDoCliente;
        this.conta = conta;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cliente{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", saldo=").append(saldo);
        sb.append(", conta=").append(conta);
        sb.append('}');
        return sb.toString();
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

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
