package sistemaSapatos.expections;

public class ClienteJaExisteException extends Exception{
    public ClienteJaExisteException(String mensagem){
        super(mensagem);
    }
}
