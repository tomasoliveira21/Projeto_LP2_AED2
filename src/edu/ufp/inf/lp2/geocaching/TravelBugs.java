package edu.ufp.inf.lp2.geocaching;

import edu.ufp.inf.lp2.geocaching.AED2Class.BST_AED2;

import java.io.Serializable;
import java.util.ArrayList;


public class TravelBugs extends  Objeto implements Serializable {

  public Cache cacheDestino;

  public ArrayList<TravelBugsLogs> historicoTravelBugsLogs = new ArrayList<>();
  public BST_AED2<String,Cache> historicoCaches = new BST_AED2<>();
  public BST_AED2<String,UserBasic> historicoUsers = new BST_AED2<>();


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