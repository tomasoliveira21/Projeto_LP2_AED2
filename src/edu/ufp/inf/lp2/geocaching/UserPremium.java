package edu.ufp.inf.lp2.geocaching;

public class UserPremium extends UserBasic {

    public UserPremium(String id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "UserPremium{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", cachesVisitadas=" + cachesVisitadas +
                ", cachesEscondidas=" + cachesEscondidas +
                '}';
    }
}