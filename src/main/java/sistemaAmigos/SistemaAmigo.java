package sistemaAmigos;

import sistemaAmigos.exceptions.AmigoInexistenteException;
import sistemaAmigos.exceptions.AmigoJaExisteException;
import sistemaAmigos.exceptions.AmigoNaoSorteadoException;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class SistemaAmigo {
    private List<Mensagem> mensagens = new ArrayList<>();
    private List<Amigo> amigos = new ArrayList<>();

    Random gerador = new Random();

    public void cadastraAmigo(String nomeAmigo, String emailAmigo) throws AmigoJaExisteException{
        Amigo am = new Amigo(nomeAmigo,emailAmigo);
        amigos.add(am);
    }

    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoInexistenteException{
        for (Amigo m: amigos){
            if (m.getEmail().equals(emailAmigo)){
                return m;

            }
        }
        throw new AmigoInexistenteException("Amigo não existe no sistema");
    }

    public void enviarMensagemParaTodos(String mensagem, String emailRementente, boolean ehAnonima){
        MensagemParaTodos m = new MensagemParaTodos(mensagem,emailRementente,ehAnonima);
        mensagens.add(m);
    }

    public void enviarMensagemParaAlguem(String mensagem, String emailRemetente, String emailDestinatario, boolean ehAnonima){
      MensagemParaAlguem m = new MensagemParaAlguem(mensagem,emailRemetente,emailDestinatario,ehAnonima);
      mensagens.add(m);
    }

    public List<Mensagem> pesquisaMensagensAnonimas(){
        List<Mensagem> mensagensAnonimas = new ArrayList<>();
        for (Mensagem m: mensagens){
            if (m.ehAnonima()){
                mensagensAnonimas.add(m);
            }
        }
        return mensagensAnonimas;
    }

    public List<Mensagem> pesquisaTodasAsMensagens(){
        return mensagens;
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSecreto) throws AmigoInexistenteException {
        for (Amigo am: amigos){
            if (am.getEmail().equals(emailDaPessoa)){
                am.setEmailAmigoSorteado(emailAmigoSecreto);
                return;
            }
        }
        throw new AmigoInexistenteException("Amigo não existe no sistema!");
    }


    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoNaoSorteadoException, AmigoInexistenteException {
        for (Amigo am: amigos){
            if (am.getEmail().equals(emailDaPessoa)){
                if (am.getEmailAmigoSorteado().isEmpty()){
                    throw new AmigoNaoSorteadoException("Amigo ainda não foi sorteado!");
                } else{
                    return am.getEmailAmigoSorteado();
                }
            }
        }
        throw new AmigoInexistenteException("Amigo não encontrado no sistema!");
    }


    public List<Amigo> pesquisaTodosAmigos(){
        return amigos;
    }
}
