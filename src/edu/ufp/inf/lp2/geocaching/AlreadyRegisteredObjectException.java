package edu.ufp.inf.lp2.geocaching;

public class AlreadyRegisteredObjectException extends Exception{

    /**
     * Não estamos a utilizar, mas seria uma exceção caso já existisse um objeto!
     * @param message
     */
    public AlreadyRegisteredObjectException(String message) {
        super(message);
        System.out.println("AlreadyRegisteredObjectException : " + message);
    }

}
