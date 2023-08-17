package sistemaFilmes;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class FilmeTest {
    @Test
    public void testaConstutor(){
        List<CategoriaFilme> categorias = new LinkedList<>();
        categorias.add(CategoriaFilme.ROMANCE);
        categorias.add(CategoriaFilme.DRAMA);
        Filme f = new Filme("Titanic", "001", categorias);
        assertEquals("Titanic", f.getNome());
        assertEquals("001", f.getCodigo());
        List<CategoriaFilme> categoriasGet = f.getCategorias();
        assertEquals(2,categoriasGet.size());
        assertTrue(categoriasGet.contains(CategoriaFilme.ROMANCE));
        assertTrue(categoriasGet.contains(CategoriaFilme.DRAMA));

    }

    @Test
    public void ehCategoria(){
        List<CategoriaFilme> categorias = new LinkedList<>();
        categorias.add(CategoriaFilme.FICCAO);
        categorias.add(CategoriaFilme.ACAO);
        Filme f = new Filme("Matrix", "002", categorias);
        assertFalse(f.ehCategoria(CategoriaFilme.ROMANCE));
        assertFalse(f.ehCategoria(CategoriaFilme.TERROR));
        assertTrue(f.ehCategoria(CategoriaFilme.FICCAO));
    }
}
