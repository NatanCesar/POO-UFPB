package sistemaSapatos;

import sistemaSapatos.expections.SapatoJaExisteException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Cliente implements Comparable<Cliente> {
    private String nome;
    private String cpf;
    private double valorDaConta;
    private List<Venda> listaCompras;



    public Cliente(String nome, String cpf) {
        this.cpf = cpf;
        this.nome = nome;
        this.valorDaConta = 0.0;
        this.listaCompras = new ArrayList<>();
    }

    public void AdquirirSapato(Venda venda) {
        listaCompras.add(venda);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        if (!Objects.equals(nome, cliente.nome)) return false;
        return Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (cpf != null ? cpf.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Cliente c) {
        return this.nome.compareTo(c.getNome());
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getValorDaConta() {
        return valorDaConta;
    }

    public void setValorDaConta(double valorDaConta) {
        this.valorDaConta = valorDaConta;
    }

    public List<Venda> getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(List<Venda> listaCompras) {
        this.listaCompras = listaCompras;
    }
}


