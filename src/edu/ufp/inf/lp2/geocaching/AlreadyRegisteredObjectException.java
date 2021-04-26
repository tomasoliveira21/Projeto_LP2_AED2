package edu.ufp.inf.lp2.geocaching;

public class AlreadyRegisteredObjectException extends Exception{

    public AlreadyRegisteredObjectException(String message) {
        super(message);
        System.out.println("AlreadyRegisteredObjectException : " + message);
    }

}
