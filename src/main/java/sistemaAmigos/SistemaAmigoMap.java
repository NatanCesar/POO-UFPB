package sistemaAmigos;

import sistemaAmigos.exceptions.AmigoInexistenteException;
import sistemaAmigos.exceptions.AmigoNaoSorteadoException;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;



public class SistemaAmigoMap {
    private List<Mensagem> mensagens = new ArrayList<>();
    private Map<String, Amigo> amigos;

    Random gerador = new Random();


    //
    // KEY DO MAP: emailAmigo
    //
    public void cadastraAmigo(String nomeAmigo, String emailAmigo) {
        Amigo am = new Amigo(nomeAmigo, emailAmigo);
        amigos.put(emailAmigo, am);
    }

    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoInexistenteException {
        if (!amigos.containsKey(emailAmigo)) {
            throw new AmigoInexistenteException("Amigo não existe no sistema");
        } else {
            return amigos.get(emailAmigo);

        }
    }

    public void enviarMensagemParaTodos(String mensagem, String emailRementente, boolean ehAnonima) {
        MensagemParaTodos m = new MensagemParaTodos(mensagem, emailRementente, ehAnonima);
        mensagens.add(m);
    }

    public void enviarMensagemParaAlguem(String mensagem, String emailRemetente, String emailDestinatario, boolean ehAnonima) {
        MensagemParaAlguem m = new MensagemParaAlguem(mensagem, emailRemetente, emailDestinatario, ehAnonima);
        mensagens.add(m);
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {
        List<Mensagem> mensagensAnonimas = new ArrayList<>();
        for (Mensagem m : mensagens) {
            if (m.ehAnonima()) {
                mensagensAnonimas.add(m);
            }
        }
        return mensagensAnonimas;
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        return mensagens;
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSecreto) throws AmigoInexistenteException {
        if (!amigos.containsKey(emailDaPessoa)) {
            throw new AmigoInexistenteException("Amigo não encontrado no sistema");
        } else {
            Amigo amigoEncontrado = amigos.get(emailDaPessoa);
            amigoEncontrado.setEmailAmigoSorteado(emailAmigoSecreto);
        }
    }


    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws
            AmigoNaoSorteadoException, AmigoInexistenteException {

        if (amigos.containsKey(emailDaPessoa)) {
            Amigo amigosEncontrado = amigos.get(emailDaPessoa);
            if (amigosEncontrado.getEmailAmigoSorteado().isEmpty()) {
                throw new AmigoNaoSorteadoException("Amigo ainda não foi sorteado!");
            } else {
                return amigosEncontrado.getEmailAmigoSorteado();
            }
        } else {
            throw new AmigoInexistenteException("Amigo não encontrado no sistema!");
        }
    }


}
