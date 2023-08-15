package sistemaAmigos;

import java.util.Objects;

public class Amigo {
    private String nome;
    private String email;
    private String emailAmigoSorteado;



    public Amigo(String nomeAmigo, String emailAmigo){
        email = emailAmigo;
        nome = nomeAmigo;
        emailAmigoSorteado = "";
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailAmigoSorteado() {
        return emailAmigoSorteado;
    }

    public void setEmailAmigoSorteado(String emailAmigoSorteado) {
        this.emailAmigoSorteado = emailAmigoSorteado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Amigo amigo = (Amigo) o;

        if (!Objects.equals(nome, amigo.nome)) return false;
        return Objects.equals(email, amigo.email);
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
