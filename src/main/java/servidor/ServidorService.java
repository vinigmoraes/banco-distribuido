package servidor;

import model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ServidorService {

    @Autowired
    private ServidorDeDados servidorDeDados;

    public HttpStatus efetuaTransferenciaEntreCliente(int contaOrigem, int contaDestino, int valor){

        if(servidorDeDados.saldoCliente(contaOrigem) <= valor){
            Cliente cliente = encontraClientePorConta(contaDestino);
            cliente.setSaldo(servidorDeDados.saldoCliente(contaDestino) + valor);
            return HttpStatus.OK;
        }

        return HttpStatus.NOT_FOUND;
    }


    private Cliente encontraClientePorConta(Integer id){

        return servidorDeDados.listaDeClientes()
                .stream().
                filter(cliente -> cliente.getConta() == id)
                .findFirst()
                .get();
    }
}
