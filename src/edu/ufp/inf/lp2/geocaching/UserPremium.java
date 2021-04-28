package edu.ufp.inf.lp2.geocaching;

public class UserPremium extends UserBasic {

    public UserPremium(String id, String name, int x, int y) {
        super(id, name, x, y);
    }

    @Override
    public String toString() {
        return "UserPremium{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", cachesVisitadas=" + cachesVisitadas +
                ", cachesEscondidas=" + cachesEscondidas +
                '}';
    }
}