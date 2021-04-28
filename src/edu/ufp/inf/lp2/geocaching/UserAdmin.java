package edu.ufp.inf.lp2.geocaching;

public class UserAdmin extends UserPremium {

    public UserAdmin(String id, String name, int x, int y) {
        super(id, name, x, y);
    }

    @Override
    public String toString() {
        return "UserAdmin{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", cachesVisitadas=" + cachesVisitadas +
                ", cachesEscondidas=" + cachesEscondidas +
                '}';
    }
}