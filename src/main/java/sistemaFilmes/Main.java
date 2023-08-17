package sistemaFilmes;


import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SistemaFilmesMap sistemaFilmes = new SistemaFilmesMap();
        int quantFilmes = Integer.parseInt(JOptionPane.showInputDialog(null,"Quantos filmes vão ser cadastrados? "));

        for (int i = 0; i < quantFilmes; i++){
            String nomeFilme = JOptionPane.showInputDialog(null, "Qual nome do filme? ");
            String codigo = JOptionPane.showInputDialog(null, "Qual o código do filme? ");
            int quantCategorias = Integer.parseInt(JOptionPane.showInputDialog(null,"A quantas categorias seu filme pertence? "));
            List<CategoriaFilme> listCategorias = new ArrayList<>();
            for (int j = 0; j < quantCategorias; j++){
                String categoria = JOptionPane.showInputDialog(null, "Qual a categoria do filme? ").toUpperCase();
                listCategorias.add(CategoriaFilme.valueOf(categoria));
                }
            Filme filmeFinal = new Filme(nomeFilme,codigo,listCategorias);
            try{
                sistemaFilmes.cadastrarFilme(filmeFinal);
            } catch (FilmeJaExisteExcpetion f){
                JOptionPane.showMessageDialog(null,f.getMessage());
            }
        }

        for (Filme f: sistemaFilmes.getTodosFilmes()){
            JOptionPane.showMessageDialog(null,f.toString());
        }
    }
}
