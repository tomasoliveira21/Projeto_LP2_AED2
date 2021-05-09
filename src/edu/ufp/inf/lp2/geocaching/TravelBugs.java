package edu.ufp.inf.lp2.geocaching;

import edu.princeton.cs.algs4.BST;

import java.util.ArrayList;


public class TravelBugs extends  Objeto{

  public Cache cacheDestino;

  public ArrayList<TravelBugsLogs> historicoTravelBugsLogs = new ArrayList<>();
  public BST<String,Cache> historicoCaches = new BST<>();
  public BST<String,UserBasic> historicoUsers = new BST<>();


  /**
   * Contrutor Travel Bugs
   * @param id
   * @param nameItem
   * @param criadorObjeto
   * @param cacheMissao
   */

  public TravelBugs(String id, String nameItem,UserBasic criadorObjeto,Cache cacheMissao) {
    super(id, nameItem,criadorObjeto);
    this.cacheDestino=cacheMissao;
    //this.id=id1;
  }

  public TravelBugs() {
    super();
  }



}