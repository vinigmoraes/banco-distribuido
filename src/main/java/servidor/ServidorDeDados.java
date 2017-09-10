package servidor;

import model.Cliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServidorDeDados {

    private final Logger logger = LoggerFactory.getLogger(ServidorDeDados.class);

    private List<Cliente> clientes = new ArrayList<>();

    protected List<Cliente> listaDeClientes() {

        clientes.add(new Cliente(1, "Bruno", 1000, 1));
        clientes.add(new Cliente(2, "Gabriel", 1000, 2));
        clientes.add(new Cliente(3, "Diego", 1000, 3));
        clientes.add(new Cliente(4, "Murilo", 1000, 4));
        clientes.add(new Cliente(5, "Vinicius", 1000, 5));
        clientes.add(new Cliente(6, "Vitor", 1000, 6));
        clientes.add(new Cliente(7, "Maria", 1000, 7));
        clientes.add(new Cliente(8, "Larissa", 1000, 8));
        clientes.add(new Cliente(9, "Marilia", 1000, 9));
        clientes.add(new Cliente(10, "Leandro", 1000, 10));

        return clientes;

    }

    /**
     * método responsável por mostrar o saldo do cliente desejado
     * @param conta
     * @return
     */

    public int saldoCliente(Integer conta) {

         int saldo = listaDeClientes().stream()
                .filter(cliente -> cliente.getConta() == conta)
                .findFirst()
                .get().getSaldo();

         logger.info("Saldo da Conta" + " " + conta + " Consultado");

        return saldo;
    }
}

