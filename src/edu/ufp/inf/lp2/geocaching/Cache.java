package edu.ufp.inf.lp2.geocaching;

import edu.princeton.cs.algs4.ST;

import java.util.ArrayList;

public class Cache {

  public static ST<String, Cache> cacheST = new ST<>();
  public ArrayList<Objeto> objetos = new ArrayList<>();

  private String serialNumber;

  public Cache(String name, String serialNumber) {
    this.serialNumber = serialNumber;
  }

  public boolean iscacheVisitada(Cache c) {
    return false;
  }

  public boolean iscacheEscondida(Cache c) {
    return false;
  }

/*
  public void insertCache(){
    cacheST.put(this.nameCache,this);
  }

  public void removeCache(){
    cacheST.remove(this.serialNumber);
  }
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

