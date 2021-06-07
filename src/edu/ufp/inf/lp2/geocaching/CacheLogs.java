package edu.ufp.inf.lp2.geocaching;


import java.io.Serializable;

import static edu.ufp.inf.lp2.geocaching.UserAdmin.userST;

public class CacheLogs implements Serializable {

    Date data;
    String userID;
    public String objetocolocado;
    public String objetoretirado;

    /**
     * Construtor das LOGS DA CACHE
     * @param data
     * @param userID
     * @param objetocolocado
     * @param objetoretirado
     */

    public CacheLogs(Date data, String userID, String objetocolocado, String objetoretirado) {
        this.data = data;
        this.userID = userID;
        this.objetocolocado = objetocolocado;
        this.objetoretirado = objetoretirado;
    }

    @Override
    public String toString() {
        if(objetocolocado == null && objetoretirado== null){
            return "CacheLogs{" +
                    "data=" + data.print() +
                    ", User='" + userST.get(userID).name + '\'' +
                    ", objetocolocado='" + "null" + '\'' +
                    ", objetoretirado='" + "null" + '\'' +
                    '}';
        }else if(objetocolocado != null && objetoretirado== null){
            return "CacheLogs{" +
                    "data=" + data.print() +
                    ", User='" + userST.get(userID).name + '\'' +
                    ", objetocolocado='" + objetocolocado  + '\'' +
                    ", objetoretirado='" + "null" + '\'' +
                    '}';
        }else  if (objetocolocado == null){
            return "CacheLogs{" +
                    "data=" + data.print() +
                    ", User='" + userST.get(userID).name + '\'' +
                    ", objetocolocado='" + "null" + '\'' +
                    ", objetoretirado='" + objetoretirado + '\'' +
                    '}';
        }
        return "CacheLogs{" +
                "data=" + data.print() +
                ", User='" + userST.get(userID).name + '\'' +
                ", objetocolocado='" + objetocolocado + '\'' +
                ", objetoretirado='" + objetoretirado + '\'' +
                '}';
    }
}