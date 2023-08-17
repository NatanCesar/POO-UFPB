package sistemaFilmes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaFilmesMap {
    private Map<String, Filme> filmes;


    public SistemaFilmesMap(){
        this.filmes = new HashMap<>();
    }

    public void cadastrarFilme(Filme f) throws FilmeJaExisteExcpetion{
        if (this.filmes.containsKey(f.getCodigo())){
            throw new FilmeJaExisteExcpetion("sistemaFilmes " + f.getNome() + " já cadastrado no cinema!");
        } else{
            this.filmes.put(f.getCodigo(),f);
        }
    }

    public List<Filme> pesquisaRomances(){
        List<Filme> filmesRomanticos = new ArrayList<>();
        for (Filme f: filmes.values()){
            if (f.ehCategoria(CategoriaFilme.ROMANCE)){
                filmesRomanticos.add(f);
            }
        }
    return filmesRomanticos;
    }

    public List<Filme> getTodosFilmes(){
        return new ArrayList<>(filmes.values());
    }
}
