package sistemaAmigos;

public abstract class Mensagem {
    private String mensagem;
    private String emailRemetente;
    private boolean anonima;

    public Mensagem(String mensagem, String emailRemetente, boolean anonima) {
        this.mensagem = mensagem;
        this.emailRemetente = emailRemetente;
        this.anonima = anonima;
    }

    public String getMensagem() {
        return mensagem;
    }
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    public abstract String getTextoCompletoAExibir();

    public String getEmailRemetente() {
        return emailRemetente;
    }

    public void setEmailRemetente(String emailRemetente) {
        this.emailRemetente = emailRemetente;
    }

    public boolean ehAnonima(){
        return anonima;
    }
}
