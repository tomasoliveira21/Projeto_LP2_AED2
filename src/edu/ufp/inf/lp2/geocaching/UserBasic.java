package edu.ufp.inf.lp2.geocaching;
import edu.princeton.cs.algs4.ST;

public class UserBasic {

  public static ST<String, UserBasic> userST = new ST<>();
  public static ST<String, Cache> cacheST = new ST<>();


  public String name;

  public String id;

  public int age;

  public double cachesVisitadas;

  public double cachesEscondidas;

  public double coordenadas;

  private String exemplo;

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

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
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

  public double getCoordenadas() {
    return coordenadas;
  }

  public void setCoordenadas(double coordenadas) {
    this.coordenadas = coordenadas;
  }

  public void progress() {
  }

  public void locatetravelBugs() {
  }

  public void insertUser(){
    userST.put(this.id, this);
  }

  public void editUser(String name, int age){
    this.name=name;
    this.age=age;
    this.cachesVisitadas = 2;
    userST.put(this.id,this);
  }

  public void removeUser(String id){
    userST.remove(this.id);
  }

}