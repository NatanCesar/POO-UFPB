package sistemaFilmes;

import java.util.List;

public class Filme {
    private String nome;
    private String codigo;
    private List<CategoriaFilme> categorias;


    public Filme(String nome, String codigo, List<CategoriaFilme> categorias) {
        this.nome = nome;
        this.codigo = codigo;
        this.categorias = categorias;
    }

    public List<CategoriaFilme> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<CategoriaFilme> categorias) {
        this.categorias = categorias;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean ehCategoria(CategoriaFilme categoria){
        for (CategoriaFilme c: categorias){
            if (c.equals(categoria)){
                return true;
            }
        }
        return false;
    }
}
