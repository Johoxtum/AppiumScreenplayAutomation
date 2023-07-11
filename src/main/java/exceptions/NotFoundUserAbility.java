package exceptions;

public class NotFoundUserAbility extends RuntimeException{

    public NotFoundUserAbility(){
        super("El actor no tiene la habilidad");
    }
}
