package Exemplo.model.exceptions;

public class DomainException extends Exception { //SE FOR UMA RUNTIMEEXCPETION, NÃO É OBRIGATÓRIO O TRATAMENTO DAS EXCEPTIONS

    private static final long serialVersionUID = 1L;

    public DomainException (String mensage){
        super(mensage);
    }

}
