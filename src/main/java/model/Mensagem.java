package model;

public enum Mensagem {

    TRANSFERENCIA_SUCESSO("Transferencia realizada com sucesso"),
    CONTA_INVALIDA("A conta digitada não foi encontrada"),
    SALDO_INVALIDO("Saldo insuficiente"),
    SAQUE_SUCESSO("Saque efetuado com sucesso"),
    DEPOSITO_SUCESSO("Saque efetuado com sucesso"),
    TRANSACAO_EM_USO("A transacao está em uso no momento: -1");


    private String messagem;

    Mensagem(String url) {
        this.messagem = url;
    }

    public String mensagem() {
        return messagem;
    }


}
