package servidor;

import com.google.gson.Gson;
import model.Cliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.ClienteUtils;

import static model.Mensagem.*;
import static utils.ClienteUtils.*;

@Service
public class ServidorService {

    private final Logger logger = LoggerFactory.getLogger(ServidorService.class);

    @Autowired
    private ServidorDeDados servidorDeDados;

    @Autowired
    private ClienteUtils clienteUtils;

    /**
     * método responsável por efetuar transferencia bancaria entre duas contas.
     * @param contaOrigem
     * @param contaDestino
     * @param valor
     * @return JSON
     */

    public String efetuaTransferenciaEntreCliente(int contaOrigem, int contaDestino, int valor){

        Cliente cliente = clienteUtils.encontraClientePorConta(contaOrigem);

        if(servidorDeDados.isLocked()){
            return TRANSACAO_EM_USO.mensagem();
        }

        if(verificaSeClienteExiste(cliente) && servidorDeDados.saldoCliente(contaOrigem) >= valor && valor > 0){
            try {
            servidorDeDados.getLock();
            clienteUtils.atualizaSaldoEntreTransferencias(contaOrigem, contaDestino, valor);
            cliente.setMensagem(TRANSFERENCIA_SUCESSO.mensagem());
            logger.info("Transferencia efetuada com sucesso entre as contas " + contaOrigem + " e" + contaDestino);
            Thread.sleep(5000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                servidorDeDados.unLock();
            }

            return new Gson().toJson(cliente);
        }

            return new Gson().toJson(SALDO_INVALIDO.mensagem());
        }

    /**
     * método responsável por efetuar saque em uma determinada conta.
     * @param conta
     * @param quantidade
     * @return JSON
     */

    public String efetuaSaque(int conta, int quantidade) {

        Cliente cliente = clienteUtils.encontraClientePorConta(conta);

        if(servidorDeDados.isLocked()){
            return TRANSACAO_EM_USO.mensagem();
        }

        if(servidorDeDados.saldoCliente(conta) >= quantidade){

            cliente.setSaldo(servidorDeDados.saldoCliente(conta) - quantidade);
            cliente.setMensagem(SAQUE_SUCESSO.mensagem());
            logger.info("Saque efetuado com sucesso na conta" + conta + " na quantia de " + quantidade);
            return new Gson().toJson(cliente);
        }
            return new Gson().toJson(SALDO_INVALIDO.mensagem());
    }

    /**
     * método responsável por efetuar deposito em uma determinada conta.
     * @param conta
     * @param quantidade
     * @return JSON
     */

    public String efetuaDeposito(int conta, int quantidade) {

        Cliente cliente = clienteUtils.encontraClientePorConta(conta);
        cliente.setSaldo(servidorDeDados.saldoCliente(conta) + quantidade);
        cliente.setMensagem(SAQUE_SUCESSO.mensagem());
        logger.info("Deposito efetuado com sucesso na conta " + conta + " na quantia de" + quantidade);
        return new Gson().toJson(cliente);

    }
}
