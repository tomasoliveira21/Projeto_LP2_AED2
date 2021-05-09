package edu.ufp.inf.lp2.geocaching;

public class Objeto {


  public String nameItem;
  public String id;
  public UserBasic criadorObjeto;
  public UserBasic userAtual;
  public Cache cacheAtual;

  /**
   * Construtor Objeto (Item)
   * @param id
   * @param nameItem
   * @param criadorObjeto
   */

  public Objeto(String id, String nameItem,UserBasic criadorObjeto) {
    this.id=id;
    this.nameItem = nameItem;
    this.criadorObjeto=criadorObjeto;
  }

    public Objeto() {

    }

    @Override
  public String toString() {
    return "Objeto{" +
            "nameItem='" + nameItem + '\'' +
            ", id='" + id + '\'' +
            '}';
  }
}