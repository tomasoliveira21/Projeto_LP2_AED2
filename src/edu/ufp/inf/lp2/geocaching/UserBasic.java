package edu.ufp.inf.lp2.geocaching;
import edu.princeton.cs.algs4.ST;

public class UserBasic{


  public String name;

  public String id;

  public int x;

  public int y;


  public double cachesVisitadas;

  public double cachesEscondidas;

  public ST<String , Cache> hCaches = new ST<>();
  //sempre que um user visitar uma cache adiciono na Hcache


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public double getCachesVisitadas() {
    return cachesVisitadas;
  }

  public void setCachesVisitadas(double cachesVisitadas) {
    this.cachesVisitadas = cachesVisitadas;
  }

  public double getCachesEscondidas() {
    return cachesEscondidas;
  }

  public void setCachesEscondidas(double cachesEscondidas) {
    this.cachesEscondidas = cachesEscondidas;
  }


  public UserBasic(String id, String name, int x, int y) {
    this.id = id;
    this.name = name;
    this.x = x;
    this.y = y;
  }

  public void progress() {
  }

  public void locatetravelBugs() {
  }



  @Override
  public String toString() {
    return "UserBasic{" +
            "name='" + name + '\'' +
            ", id='" + id + '\'' +
            ", x=" + x +
            ", y=" + y +
            ", cachesVisitadas=" + cachesVisitadas +
            ", cachesEscondidas=" + cachesEscondidas +
            '}';
  }
}