package edu.ufp.inf.lp2.geocaching;


public class CacheLogs {

    Date data;
    String userID;
    public String objetocolocado;
    public String objetoretirado;

    public CacheLogs(Date data, String userID, String objetocolocado, String objetoretirado) {
        this.data = data;
        this.userID = userID;
        this.objetocolocado = objetocolocado;
        this.objetoretirado = objetoretirado;
    }

}