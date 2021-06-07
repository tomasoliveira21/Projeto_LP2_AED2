package edu.ufp.inf.lp2.geocaching;

import java.io.Serializable;

public class AlreadyRegisteredObjectException extends Exception implements Serializable {

    /**
     * Não estamos a utilizar, mas seria uma exceção caso já existisse um objeto!
     * @param message
     */
    public AlreadyRegisteredObjectException(String message) {
        super(message);
        System.out.println("AlreadyRegisteredObjectException : " + message);
    }

}
