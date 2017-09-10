package servidor;

import org.junit.Assert;
import org.junit.Test;


public class ServidorDeDadosTest extends ServidorDeDados {

    @Test
    public void retornaOSaldoDoClienteDesejado(){

        Assert.assertEquals(1000, saldoCliente(1));
    }
}
