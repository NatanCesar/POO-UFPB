package sistemaFilmes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaFilmeMapTest {
    SistemaFilmesMap sistema;


    @BeforeEach
    void setUP(){ this.sistema = new SistemaFilmesMap();}

    @Test
    public void testaCadastrar(){
        List<CategoriaFilme> categoriasBarbie = new ArrayList<>();
        categoriasBarbie.add(CategoriaFilme.COMEDIA);
        Filme f = new Filme("Barbie", "002",categoriasBarbie);

        try{
            sistema.cadastrarFilme(f);
        } catch (FilmeJaExisteExcpetion e){
            fail("Não deveria lançar exceção");
        }
        try{
            sistema.cadastrarFilme(f);
            fail("Não deveria lançar exceção");
        } catch (FilmeJaExisteExcpetion e){
            //OK
        }
    }

    @Test
    public void testaPesquisarRomances(){
        List<Filme> filmesRomanticos = sistema.pesquisaRomances();
        for (Filme f: filmesRomanticos){
            assertTrue(f.ehCategoria(CategoriaFilme.ROMANCE));
            assertFalse(f.ehCategoria(CategoriaFilme.ACAO));
        }
    }
}
