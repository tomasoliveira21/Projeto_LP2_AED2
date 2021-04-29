package edu.ufp.inf.lp2.geocaching;

import edu.princeton.cs.algs4.ST;

import java.util.ArrayList;

public class Cache{ // é necessario fazer extends do userBasic (?)


  public ST<String, UserBasic> hUsers= new ST<>();
  public ArrayList<CacheLogs> cacheLogs= new ArrayList<>();

  public UserBasic userCreator;
  public CacheDiff type;
  public String serialNumber;
  public Objeto obj;

  public int x;
  public int y;
  public String regiao;

  public String getRegiao() {
    return regiao;
  }

  public void setRegiao(String regiao) {
    this.regiao = regiao;
  }

  public String getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }


  public Cache(String serialNumber, CacheDiff type , UserBasic userCreator, Objeto obj , int x, int y, String regiao) {
    this.serialNumber = serialNumber;
    this.type=type;
    this.userCreator = userCreator;
    this.obj=obj;
    this.x = x;
    this.y = y;
    this.regiao=regiao;
  }

  /*
  public void addObjectToArrayList(Objeto objeto) throws AlreadyRegisteredObjectException {
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

*/

  @Override
  public String toString() {
    return "Cache{" +
            "userCreator=" + userCreator.name +
            ", type=" + type +
            ", serialNumber='" + serialNumber + '\'' +
            ", obj=" + obj.nameItem +
            ", x=" + x +
            ", y=" + y +
            ", regiao='" + regiao + '\'' +
            '}';
  }
}

