package sistemaAmigos;

public class MensagemParaTodos extends Mensagem{
    public MensagemParaTodos(String mensagem, String emailRemetente, boolean anonima){
        super(mensagem,emailRemetente,anonima);

    }

    @Override
    public String getTextoCompletoAExibir() {
        if (super.ehAnonima()){
            return "Mensagem anônima para todos: " + super.getMensagem();
        } else {
            return  "Mensagem de: " + super.getEmailRemetente() + " Para todos: " + super.getMensagem();
        }
    }
}
