package edu.ufp.inf.lp2.geocaching;
import edu.princeton.cs.algs4.ST;

public class UserAdmin extends UserPremium {

    public static ST<String, UserBasic> userST = new ST<>();
    public static ST<String, Cache> cacheST = new ST<>();

    public UserAdmin(String id, String name, int age) {
        super(id, name, age);
    }

   //um Admin pode modificar + Adicionar tudo inclusive TravelBugs


    @Override
    public String toString() {
        return "UserAdmin{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", age=" + age +
                ", cachesVisitadas=" + cachesVisitadas +
                ", cachesEscondidas=" + cachesEscondidas +
                '}';
    }
}