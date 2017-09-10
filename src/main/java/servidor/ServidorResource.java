package servidor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/negocios1")
public class ServidorResource{

    private final Logger logger = LoggerFactory.getLogger(ServidorResource.class);

    @Autowired
    private ServidorDeDados servidorDeDados;

    @Autowired
    private ServidorService servidorService;

    @PostMapping("/deposito/{conta}/{quantidade}")
    public String deposito(@PathVariable("conta") int conta, @PathVariable("quantidade") int quantidade) {

        return servidorService.efetuaDeposito(conta, quantidade);

    }

    @PostMapping("/saque/{conta}/{quantidade}")
    public String saque(@PathVariable("conta") int conta, @PathVariable("quantidade") int quantidade) {

       return servidorService.efetuaSaque(conta,quantidade);
    }

    @RequestMapping(value = "/saldo/{conta}",method = RequestMethod.GET)
    public int saldo(@PathVariable("conta") Integer conta) {

        return servidorDeDados.saldoCliente(conta);
    }

    @RequestMapping(value = "/transferencia/{contaOrigem}/{contaDestino}/{valor}", method = RequestMethod.POST)
    public String transferencia(@PathVariable("contaOrigem") Integer contaOrigem,
                                        @PathVariable("contaDestino") Integer contaDestino,
                                        @PathVariable("valor") Integer valor) {

        return servidorService.efetuaTransferenciaEntreCliente(contaOrigem,contaDestino,valor);
    }
}
