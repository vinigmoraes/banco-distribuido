package servidor;

import com.google.gson.Gson;
import model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static model.Mensagem.*;

@Service
public class ServidorService {

    @Autowired
    private ServidorDeDados servidorDeDados;

    /**
     * método responsável por efetuar transferencia bancaria entre duas contas.
     * @param contaOrigem
     * @param contaDestino
     * @param valor
     * @return JSON
     */

    public String efetuaTransferenciaEntreCliente(int contaOrigem, int contaDestino, int valor){

        Cliente cliente = encontraClientePorConta(contaOrigem);

        if(cliente == null){
            cliente.setMensagem(CONTA_INVALIDA.mensagem());
            return new Gson().toJson(cliente);
        }

        if(servidorDeDados.saldoCliente(contaOrigem) >= valor){

            atualizaSaldoEntreTransferencias(contaOrigem, contaDestino, valor);
            cliente.setMensagem(TRANSFERENCIA_SUCESSO.mensagem());
            return new Gson().toJson(cliente);
        }else{
            cliente.setMensagem(SALDO_INVALIDO.mensagem());
            return new Gson().toJson(cliente);
             }
        }

    /**
     * método responsável por efetuar saque em uma determinada conta.
     * @param conta
     * @param quantidade
     * @return JSON
     */

    public String efetuaSaque(int conta, int quantidade) {

        Cliente cliente = encontraClientePorConta(conta);

        if(servidorDeDados.saldoCliente(conta) >= quantidade){
            cliente.setSaldo(servidorDeDados.saldoCliente(conta) - quantidade);
            cliente.setMensagem(SAQUE_SUCESSO.mensagem());
            return new Gson().toJson(cliente);
        }
         cliente.setMensagem(SALDO_INVALIDO.mensagem());
         return new Gson().toJson(cliente);
    }

    /**
     * método responsável por efetuar deposito em uma determinada conta.
     * @param conta
     * @param quantidade
     * @return JSON
     */

    public String efetuaDeposito(int conta, int quantidade) {

        Cliente cliente = encontraClientePorConta(conta);
        cliente.setSaldo(servidorDeDados.saldoCliente(conta) + quantidade);
        return new Gson().toJson(cliente);

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
