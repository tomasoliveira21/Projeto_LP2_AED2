package edu.ufp.inf.lp2.geocaching;
import edu.princeton.cs.algs4.ST;

public class Objeto extends TravelBugs {

  public static ST<String, Objeto> itemC = new ST<>(); // muito provavelmente mal 🤡🤡🤡🤡🤡🤡🤡

  private String nameItem;
  private String type;

  public Objeto(String nameItem, String type) {
    this.nameItem = nameItem;
    this.type = type;
  }

  public void insertItemtoCache(Objeto i) {
    itemC.put(this.nameItem,this);
  }

  public void removeItemfromCache(Objeto i){
    itemC.remove(this.nameItem);
  }

  public void removeItemFromCacheByType(Objeto i){  // muito provavelmente mal 🤡🤡🤡🤡🤡🤡🤡
    if (this.type!=null){
      itemC.remove(this.type);
    }
  }


}