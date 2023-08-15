package sistemaAmigos;

public class MensagemParaAlguem extends Mensagem{
    private String emailDestinatario;


    public MensagemParaAlguem(String mensagem,String emailRemetente, String emailDestinatario,boolean anonima) {
        super(mensagem, emailRemetente, anonima);
        this.emailDestinatario = emailDestinatario;
    }
    @Override
    public String getTextoCompletoAExibir() {
        if (super.ehAnonima()){
            return "Mensagem para " + this.emailDestinatario + ":\n " + super.getMensagem();
        } else {
            return "Mensagem de: " + super.getEmailRemetente() + " para " + this.emailDestinatario + ":\n " + super.getMensagem();
        }
    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }


}
