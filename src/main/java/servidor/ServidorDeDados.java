package servidor;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ServidorDeDados {

    private List<Cliente> clientes = new ArrayList<>();

    public List<Cliente> listaDeClientes(){

        clientes.add(new Cliente("Bruno",1000));
        clientes.add(new Cliente("Gabriel",1000));
        clientes.add(new Cliente("Diego",1000));
        clientes.add(new Cliente("Murilo",1000));
        clientes.add(new Cliente("Vinicius",1000));
        clientes.add(new Cliente("Vitor",1000));
        clientes.add(new Cliente("Maria",1000));
        clientes.add(new Cliente("Larissa",1000));
        clientes.add(new Cliente("Marilia",1000));
        clientes.add(new Cliente("Vitor",1000));

        return clientes;

    }

}
