package edu.ufp.inf.lp2.geocaching;

import edu.princeton.cs.algs4.ST;

import java.util.ArrayList;

public class Cache {

  public static ST<String, UserBasic> userST = new ST<>();
  public static ST<String, Cache> cacheST = new ST<>();
  public ArrayList<Objeto> objetos = new ArrayList<>();
  public UserBasic usercreator;
  public CacheDiff type;

  public String serialNumber;

  CacheDiff cacheEasy = CacheDiff.Easy;
  //se quiser dizer que uma cache é facil é so fazer   System.out.println(cacheEasy.CacheDiff());

  CacheDiff cacheMedium = CacheDiff.Medium;

  CacheDiff cacheHard = CacheDiff.Hard;

  public int x;
  public int y;

  public Cache(String serialNumber, UserBasic usercreator, CacheDiff type , int x, int y) {
    this.usercreator = usercreator;
    this.serialNumber = serialNumber;
    this.type=type;
    this.x = x;
    this.y = y;
  }

  /*
  public void insertCache(){
    cacheST.put(this.nameCache,this);
  }

  public void removeCache(){
    cacheST.remove(this.serialNumber);
  }

  metodos para ver se a cache ja foi vizitada pelo user
*/



  public void addObjectToCache(Objeto objeto) throws AlreadyRegisteredObjectException {
    if (!objetos.contains(objeto)) {
      objetos.add(objeto);
    }
    throw new AlreadyRegisteredObjectException("Object already registered!");
  }

  public boolean removeObjectFromCache(String nameItem) {
    for (int i = 0; i < objetos.size(); i++) {
      objetos.get(i).nameItem.equals(nameItem);
      if (objetos.get(i).nameItem.equals(nameItem)) {
        return objetos.remove(objetos.get(i));
      }
    }
    return false;

  }

  public void printObjetoFromCache(){
    System.out.println("Item da Lista de objetos: ");
    for (int i = 0; i < objetos.size(); i++){
      System.out.println(objetos.get(i).nameItem);
    }
  }



}

