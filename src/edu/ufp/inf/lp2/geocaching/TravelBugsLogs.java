package edu.ufp.inf.lp2.geocaching;

public class TravelBugsLogs {

    String cache;
    String user;
    Cache c;
    UserPremium p;

    boolean destinoConcluido;

    public TravelBugsLogs(String cache, String user, Cache c, UserPremium p) {
        this.cache = cache;
        this.user = user;
        this.c = c;
        this.p = p;
        this.destinoConcluido = false;
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
