package servidor;

import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;


@RestController
@RequestMapping("/servidor")
public class ServidorResource{

    ServidorDeDados servidorDeDados = new ServidorDeDados();

    @PostMapping("/deposito/{conta}/{quantidade}")
    public void deposito(@PathParam("conta") int conta, @PathParam("quantidade") int quantidade) {

    }

    @PostMapping("/saque/{conta}/{quantidade}")
    public void saque(@PathParam("conta") int conta,@PathParam("quantidade") int quantidade) {

    }

    @RequestMapping(value = "/saldo/{conta}",method = RequestMethod.GET)
    public int saldo(@PathParam("conta") int conta) {

        return servidorDeDados.saldoCliente(conta);
    }

    public void transferencia(int contaOrigem, int contaDestino, int valor) {

    }
}
