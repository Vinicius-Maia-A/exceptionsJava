package model.exceptions;

public class DomainException extends RuntimeException{

    //declarando versão de uma classe serializable
    private static final long serialVersionUID = 1L;

    public DomainException(String mesage){
        super(mesage);
    }
}
