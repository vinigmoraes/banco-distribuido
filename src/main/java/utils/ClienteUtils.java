package utils;

import model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import servidor.ServidorDeDados;

import static model.Mensagem.CONTA_INVALIDA;

@Component
public class ClienteUtils {

    @Autowired
    private ServidorDeDados servidorDeDados;

    public static boolean verificaSeClienteExiste(Cliente cliente) {
        if(cliente != null){
            cliente.setMensagem(CONTA_INVALIDA.mensagem());
            return true;
        }
        return false;
    }

    public Cliente encontraClientePorConta(Integer id){

        return servidorDeDados.listaDeClientes()
                .stream().filter(cliente -> cliente.getConta() == id)
                .findFirst()
                .get();

    }

    public void atualizaSaldoEntreTransferencias(int contaOrigem, int contaDestino, int valor) {

        Cliente clienteOrigem = encontraClientePorConta(contaOrigem);
        clienteOrigem.setSaldo(servidorDeDados.saldoCliente(contaOrigem) - valor);

        Cliente clienteDestino = encontraClientePorConta(contaDestino);
        clienteDestino.setSaldo(servidorDeDados.saldoCliente(contaDestino) + valor);
    }
}
