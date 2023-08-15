package sistemaAmigos.tests;

import sistemaAmigos.Amigo;
import sistemaAmigos.SistemaAmigo;
import sistemaAmigos.exceptions.AmigoJaExisteException;

import javax.swing.JOptionPane;
import java.util.List;

public class TestaSistemaAmigosGUI {
    public static void main(String[] args) throws AmigoJaExisteException {
        SistemaAmigo SA = new SistemaAmigo();

        int quantAmigos = Integer.parseInt(JOptionPane.showInputDialog(null,"Quantos amigos vão participar?"));

        // Cadasta os amigos no sistema //
        for (int i = 0; i < quantAmigos; i++){
            String nomeAmigo = JOptionPane.showInputDialog("Qual nome do amigo? ");
            String emailAmigo = JOptionPane.showInputDialog("Qual email do amigo? ");
            SA.cadastraAmigo(nomeAmigo,emailAmigo);
        }

        // Sorteia o amigo secreto de cada um cadastrado //
        List<Amigo> listaAmigos = SA.pesquisaTodosAmigos();
         for (int j = 0; j < listaAmigos.size(); j++){
             if (listaAmigos.size()-1 == j){
                 listaAmigos.get(j).setEmailAmigoSorteado(listaAmigos.get(0).getEmail());
             } else{
                 listaAmigos.get(j).setEmailAmigoSorteado(listaAmigos.get(j+1).getEmail());
             }
            JOptionPane.showMessageDialog(null, listaAmigos.get(j).getNome() + ", Seu amigo secreto é o: "
                    + listaAmigos.get(j).getEmailAmigoSorteado());
        }


         // Enviando mensagem //
        String emailRemetente = JOptionPane.showInputDialog(null,"Qual email do remetente da mensagem? ");
        String texto = JOptionPane.showInputDialog(null,"Qual o texto da mensagem? ");
        String anonima = JOptionPane.showInputDialog(null,"A mensagem é anonima? ").toUpperCase();
        boolean ehAnonima = true;

        if (anonima.equals("NÃO")|| anonima.equals("NAO")){
            ehAnonima = false;
        }
        SA.enviarMensagemParaTodos(texto,emailRemetente,ehAnonima);
        JOptionPane.showMessageDialog(null,SA.pesquisaTodasAsMensagens().get(0).getTextoCompletoAExibir());


    }
}
