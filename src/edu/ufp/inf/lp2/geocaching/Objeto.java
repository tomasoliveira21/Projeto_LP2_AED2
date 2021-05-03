package edu.ufp.inf.lp2.geocaching;

public class Objeto {


  public String nameItem;
  public String id;
  public UserBasic criadorObjeto;
  public UserBasic userAtual;
  public Cache cacheAtual;

  public Objeto(String id, String nameItem,UserBasic criadorObjeto) {
    this.id=id;
    this.nameItem = nameItem;
    this.criadorObjeto=criadorObjeto;
  }

  @Override
  public String toString() {
    return "Objeto{" +
            "nameItem='" + nameItem + '\'' +
            ", id='" + id + '\'' +
            '}';
  }
}