package edu.ufp.inf.lp2.geocaching;

import edu.princeton.cs.algs4.ST;

public class Cache{

  public static ST<String, UserBasic> userST = new ST<>();
  public static ST<String, Cache> cacheST = new ST<>();
  public static ST<String, Objeto> itemC = new ST<>(); // muito provavelmente mal 🤡🤡🤡🤡🤡🤡🤡

  private String nameCache;
  private String serialNumber;

  public Cache(String name, String serialNumber) {
    this.nameCache = name;
    this.serialNumber = serialNumber;
  }

  public boolean iscacheVisitada(Cache c) {
    return false;
  }

  public boolean iscacheEscondida(Cache c) {
  return false;
  }


  public void insertCache(){
    cacheST.put(this.nameCache,this);
  }

  public void removeCache(){
    cacheST.remove(this.serialNumber);
  }

  //coordenadas da cache ... help 🤡🤡🤡🤡🤡🤡🤡

}