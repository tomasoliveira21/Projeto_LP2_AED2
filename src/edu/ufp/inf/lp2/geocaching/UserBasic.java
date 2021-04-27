package edu.ufp.inf.lp2.geocaching;
import edu.princeton.cs.algs4.ST;

public class UserBasic {

  public static ST<String, UserBasic> userST = new ST<>();



  public String name;

  public String id;

  public int x;

  public int y;


  public double cachesVisitadas;

  public double cachesEscondidas;


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

  public void insertUser(){
    userST.put(this.id, this);
  }

  public void editUser(String name, int x, int y){
    this.name=name;
    this.x=x;
    this.y=y;
    userST.put(this.id,this);
  }

  public void printUser(){
    System.out.println("Lista Utilizadores: ");
    for (String name: userST.keys()){
      UserBasic user = userST.get(name);
      System.out.println(userST.get(name));
    }
    System.out.println("\n");
  }

  public void removeUser(String id){
    userST.remove(this.id);
  }

  @Override
  public String toString() {
    return "Aventureiro{" +
            "name='" + name + '\'' +
            ", id='" + id + '\'' +
            ", x=" + x +
            ", y=" + y +
            ", cachesVisitadas=" + cachesVisitadas +
            ", cachesEscondidas=" + cachesEscondidas +
            '}';
  }
}