package edu.ufp.inf.lp2.geocaching;

import edu.princeton.cs.algs4.BST;

//provavelmente os travel bugs é que extends objeto
public class TravelBugs extends  Objeto{

  public Cache cacheDestino;

  public int id;

  public BST<String,TravelBugsLogs> historicoTravelBugsLogs = new BST<>();
  public BST<String,Cache> historicoCaches = new BST<>();
  public BST<String,UserBasic> historicoUsers = new BST<>();




  public TravelBugs(String id, String nameItem, Cache cache, int id1) {
    super(id, nameItem);
    this.cacheDestino=cache;
    this.id=id1;
  }



  public void now() {
  }

}