package edu.ufp.inf.lp2.geocaching;
import edu.princeton.cs.algs4.ST;

import java.util.ArrayList;

public class UserBasic{


  public String name;

  public String id;



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


  public UserBasic(String id, String name) {
    this.id = id;
    this.name = name;

  }

  public void progress() {
  }

  public void locatetravelBugs() {
  }

public void visitCache(Cache cache, ArrayList objetosretirados, ArrayList objetoscolocados){
    hCaches.put(""+System.currentTimeMillis(), cache);
    cache.addVisitante(this);
}



  @Override
  public String toString() {
    return "UserBasic{" +
            "name='" + name + '\'' +
            ", id='" + id + '\'' +
            ", cachesVisitadas=" + cachesVisitadas +
            ", cachesEscondidas=" + cachesEscondidas +
            '}';
  }
}