package servidor;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

public class ServidorDeNegociosUm implements ServidorDeNegocios{

    @Override
    @Path("/deposito/{conta}/{quantidade}")
    @POST
    public void deposito(@PathParam("conta") int conta, @PathParam("quantidade") int quantidade) {

    }

    @Override
    public void saque(int conta, int quantidade) {

    }

    @Override
    public int saldo(int conta) {
        return 0;
    }

    @Override
    public void transferencia(int contaOrigem, int contaDestino, int valor) {

    }
}
