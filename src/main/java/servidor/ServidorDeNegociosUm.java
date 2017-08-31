package servidor;

import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("servidorUm")
public class ServidorDeNegociosUm implements ServidorDeNegocios{

    ServidorDeDados servidorDeDados = new ServidorDeDados();

    @Override
    @Path("/deposito/{conta}/{quantidade}")
    @POST
    public void deposito(@PathParam("conta") int conta, @PathParam("quantidade") int quantidade) {

    }

    @Override
    @Path("/saque/{conta}/{quantidade}")
    @POST
    public void saque(@PathParam("conta") int conta,@PathParam("quantidade") int quantidade) {



    }

    @Override
    @Path("/saldo/{conta}")
    @GET
    public int saldo(@PathParam("conta") int conta) {

        return servidorDeDados.saldoCliente(conta);
    }

    @Override
    public void transferencia(int contaOrigem, int contaDestino, int valor) {

    }
}
