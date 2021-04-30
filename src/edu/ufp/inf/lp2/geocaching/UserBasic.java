package edu.ufp.inf.lp2.geocaching;
import edu.princeton.cs.algs4.ST;
import java.util.Date;

public class UserBasic{


  public String name;

  public String id;



  public double cachesVisitadas;

  public double cachesEscondidas;

  public ST<Date , Cache> hCaches = new ST<>();
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


  public void visitCache(Date date, Cache cache, MessageLog log){
    CacheLogs cacheLogs = new CacheLogs(date, this.id,null,null);
    this.cachesVisitadas++;
   // cache.adicionarLog(log);
    this.hCaches.put(date,cache);
    cache.hUsers.put(date,this);
  }

/*public void visitCache(Cache cache,Objeto objeto, ArrayList objetosretirados, ArrayList objetoscolocados){
    hCaches.put(""+System.currentTimeMillis(), cache);
    cache.addVisitante(this);

    objetoscolocados.add(objeto);
    objetosretirados.remove(objeto);

}
 */



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