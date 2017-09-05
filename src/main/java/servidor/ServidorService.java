package servidor;

import com.google.gson.Gson;
import model.Cliente;
import model.Mensagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static model.Mensagem.*;

@Service
public class ServidorService {

    @Autowired
    private ServidorDeDados servidorDeDados;

    public String efetuaTransferenciaEntreCliente(int contaOrigem, int contaDestino, int valor){

        Cliente cliente = encontraClientePorConta(contaOrigem);

        if(servidorDeDados.saldoCliente(contaOrigem) >= valor){

            atualizaSaldoEntreTransferencias(contaOrigem, contaDestino, valor);
            cliente.setMensagem(SUCESSO.mensagem());

            return new Gson().toJson(cliente);
        }
            cliente.setMensagem(SALDO_INVALIDO.mensagem());
            return cliente.getMensagem();
        }


    public HttpStatus efetuaSaque(int conta, int quantidade) {

        if(servidorDeDados.saldoCliente(conta) >= quantidade){
            Cliente cliente = encontraClientePorConta(conta);
            cliente.setSaldo(servidorDeDados.saldoCliente(conta) - quantidade);
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

    private void atualizaSaldoEntreTransferencias(int contaOrigem, int contaDestino, int valor) {

        Cliente clienteOrigem = encontraClientePorConta(contaOrigem);
        clienteOrigem.setSaldo(servidorDeDados.saldoCliente(contaOrigem) - valor);

        Cliente clienteDestino = encontraClientePorConta(contaDestino);
        clienteDestino.setSaldo(servidorDeDados.saldoCliente(contaDestino) + valor);
    }
}
