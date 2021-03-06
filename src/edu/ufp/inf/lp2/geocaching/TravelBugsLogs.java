package edu.ufp.inf.lp2.geocaching;

import java.io.Serializable;

public class TravelBugsLogs implements Serializable {

    String cache;
    String user;
    Cache c;
    UserPremium p;
    Date date;
    boolean destinoConcluido;

    /**
     * Construtor dos TravelBugsLogs
     * @param cache
     * @param user
     * @param c
     * @param p
     * @param date
     */

    public TravelBugsLogs(String cache, String user, Cache c, UserPremium p,Date date) {
        this.cache = cache;
        this.user = user;
        this.c = c;
        this.p = p;
        this.destinoConcluido = false;
        this.date=date;
    }

    @Override
    public String toString() {
        if(p==null){
            return "TravelBugsLogs{" +
                    "cache='" + cache + '\'' +
                    ", c=" + c +
                    ", p=" + p +
                    ", destinoConcluido=" + destinoConcluido +
                    '}';
        }
        return "TravelBugsLogs{" +
                ", user='" + user + '\'' +
                ", c=" + c +
                ", p=" + p +
                ", destinoConcluido=" + destinoConcluido +
                '}';
    }
}
