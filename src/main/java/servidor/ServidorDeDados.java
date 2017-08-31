package servidor;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ServidorDeDados {

    private List<Cliente> clientes = new ArrayList<>();

    private List<Cliente> listaDeClientes(){

        clientes.add(new Cliente("Bruno",1000,1));
        clientes.add(new Cliente("Gabriel",1000,2));
        clientes.add(new Cliente("Diego",1000,3));
        clientes.add(new Cliente("Murilo",1000,4));
        clientes.add(new Cliente("Vinicius",1000,5));
        clientes.add(new Cliente("Vitor",1000,6));
        clientes.add(new Cliente("Maria",1000,7));
        clientes.add(new Cliente("Larissa",1000,8));
        clientes.add(new Cliente("Marilia",1000,9));
        clientes.add(new Cliente("Vitor",1000,10));

        return clientes;

    }

    public int saldoCliente(int conta){

        return clientes.stream()
                .filter(cliente -> cliente.getConta() == conta)
                .findFirst()
                .get().getSaldo();
    }

}
