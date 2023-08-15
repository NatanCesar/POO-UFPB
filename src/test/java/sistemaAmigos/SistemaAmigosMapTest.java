package sistemaAmigos;

import sistemaAmigos.exceptions.AmigoInexistenteException;
import sistemaAmigos.exceptions.AmigoNaoSorteadoException;

public class SistemaAmigosMapTest {
    public static void main(String[] args) {

        SistemaAmigo SA = new SistemaAmigo();

        SA.cadastraAmigo("Maria","mariazinha.arrobinha123@gmail.com");
        SA.cadastraAmigo("José","jose157@gmail.com");

        try{
            SA.configuraAmigoSecretoDe("mariazinha.arrobinha123@gmail.com","jose157@gmail.com");
        } catch (AmigoInexistenteException a){
            System.out.println(a.getMessage());
        }

        try{
            SA.configuraAmigoSecretoDe("jose157@gmail.com","mariazinha.arrobinha123@gmail.com");
        } catch (AmigoInexistenteException a){
            System.out.println(a.getMessage());
        }

        SA.enviarMensagemParaAlguem("José, te amo.","mariazinha.arrobinha123@gmaim.com",
                "jose157@gmail.com",true);
        SA.enviarMensagemParaTodos("HELLO WORLD!","mariazinha.arrobinha123@gmaim.com",true);

        for (Mensagem m: SA.pesquisaMensagensAnonimas()){
            System.out.println(m.getTextoCompletoAExibir());
        }

        try{
            if (SA.pesquisaAmigoSecretoDe("jose157@gmail.com").equals("mariazinha.arrobinha123@gmail.com")) {
                System.out.println("OK");
            }
        } catch (AmigoInexistenteException a){
            System.out.println("Amigo inexistente.");
        } catch (AmigoNaoSorteadoException b){
            System.out.println("Amigo ainda não sorteado");
        }


    }
}
