package model;

public enum Mensagem {

    SUCESSO("Transferencia realizada com sucesso"),
    CONTA_INVALIDA("A conta digitada não foi encontrada"),
    SALDO_INVALIDO("Saldo insuficiente");

    private String messagem;

    Mensagem(String url) {
        this.messagem = url;
    }

    public String mensagem() {
        return messagem;
    }


}
