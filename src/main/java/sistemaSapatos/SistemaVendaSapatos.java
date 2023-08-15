package sistemaSapatos;

import sistemaSapatos.expections.ClienteJaExisteException;
import sistemaSapatos.expections.SapatoJaExisteException;
import sistemaSapatos.expections.VendaJaExisteExcpetion;

import javax.swing.*;
import java.util.List;

public class SistemaVendaSapatos {
    private List<Sapato> listaSapatos;
    private List<Cliente> listaClientes;
    private List<Venda> listaVendas;


    public void cadastrarSapato(Sapato sapato) throws SapatoJaExisteException {
        if (sapatoJaExiste(sapato)) {
            throw new SapatoJaExisteException("Sapato já existe no sistema!");
        } else {
            listaSapatos.add(sapato);
        }

    }

    public void cadastrarCliente(Cliente cliente) throws ClienteJaExisteException {
        if (clienteJaExiste(cliente)) {
            throw new ClienteJaExisteException("Cliente já existe no sistema!");
        } else {
           listaClientes.add(cliente);
        }

    }

    public void cadastrarVenda(Venda venda) throws VendaJaExisteExcpetion {
        if (vendaJaExiste(venda)) {
            throw new VendaJaExisteExcpetion("Venda já existe no sistema!");
        } else {
            listaVendas.add(venda);
        }

    }

    public boolean sapatoJaExiste(Sapato sapatoTeste){
        for (Sapato s: listaSapatos){
            if (sapatoTeste.equals(s)){
                return true;
            }
        }
        return false;
    }


    public boolean clienteJaExiste(Cliente clienteTeste){
        for (Cliente c: listaClientes){
            if (clienteTeste.equals(c)){
                return true;
            }
        }
        return false;
    }


    public boolean vendaJaExiste(Venda vendaTeste){
        for (Venda v: listaVendas){
            if (vendaTeste.equals(v)){
                return true;
            }
        }
        return false;
    }
}
