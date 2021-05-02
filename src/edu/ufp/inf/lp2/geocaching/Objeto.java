package edu.ufp.inf.lp2.geocaching;

public class Objeto {


  public String nameItem;
  public String id;
  public UserBasic criadorObjeto;

  public Objeto(String id, String nameItem) {
    this.id=id;
    this.nameItem = nameItem;
  }

  @Override
  public String toString() {
    return "Objeto{" +
            "nameItem='" + nameItem + '\'' +
            ", id='" + id + '\'' +
            '}';
  }
}