package edu.ufp.inf.lp2.geocaching;

import edu.princeton.cs.algs4.RedBlackBST;

public class UserPremium extends UserBasic {

    public double cachesEscondidas;
    public RedBlackBST<String,TravelBugs> meusTravelBugs = new RedBlackBST<>();

    public UserPremium(String name, String id) {
        super(id, name);
    }


    public void criarTravelBug(){

    }



    @Override
    public String toString() {
        return "UserPremium{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", cachesVisitadas=" + cachesVisitadas +
                '}';
    }
}