package edu.ufp.inf.lp2.geocaching;
import edu.princeton.cs.algs4.BST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.util.Date;

import static edu.ufp.inf.lp2.geocaching.UserAdmin.userST;


public class UserBasic{


  public String name;

  public String id;

  public double cachesVisitadas;


  public BST<String,Objeto> myObjetos = new BST<>();

  public SeparateChainingHashST<Date , Cache> hCaches = new SeparateChainingHashST<>();//sempre que um user visitar uma cache adiciono na Hcache


  public UserBasic(String name, String id) {
    this.name = name;
    this.id = id;
    this.cachesVisitadas = 0;
    this.insertUser();
  }



  public void insertUser(){
    userST.put(this.id, this);
  }

  public void removerUser(){
    userST.remove(this.id);
  }

  public void removerUser(String id){
    userST.remove(id);
  }

  public void editarUser(String nome,String id){
    this.name=nome;
    this.id=id;
  }

  public void criarObjeto(String id , String nameItem){
      Objeto objeto = new Objeto(id,nameItem);
      objeto.criadorObjeto=this;
      myObjetos.put(objeto.id,objeto);

  }



  public void visitarUmaCache(Cache cache,MessageLog mensagem,Date date){
    CacheLogs cl = new CacheLogs(date,this.id,null,null);
    cache.cacheLogs.add(cl);
    this.cachesVisitadas++;
    this.hCaches.put(date,cache);
    cache.messageLogs.add(mensagem);
    cache.hUsers.put(date,this);
  }

  public void visitarUmaCache_deixarObjeto(Cache cache,MessageLog mensagem,Date date,String obj){
    Objeto objeto = this.myObjetos.get(obj);
    this.myObjetos.delete(obj);

    CacheLogs cl = new CacheLogs(date,this.id,objeto.id,null);
    cache.cacheLogs.add(cl);

    cache.meusObjetos.put(objeto.id,objeto);

    cache.messageLogs.add(mensagem);

    this.cachesVisitadas++;
    this.hCaches.put(date,cache);
    cache.hUsers.put(date,this);
  }



  public void visitarUmaCache_trocarObjeto(Cache cache,MessageLog mensagem,Date date,String obj,Objeto objCache){
    Objeto objetoColocar = this.myObjetos.get(obj);
    this.myObjetos.delete(obj);


    cache.meusObjetos.delete(objCache.id);

    CacheLogs cl = new CacheLogs(date,this.id,objetoColocar.id,objCache.id);
    cache.cacheLogs.add(cl);

    cache.meusObjetos.put(objetoColocar.id,objetoColocar);


    cache.messageLogs.add(mensagem);

    this.cachesVisitadas++;
    this.hCaches.put(date,cache);
    cache.hUsers.put(date,this);
  }


public void printObjetos(){

    if(myObjetos.size()>0){
      System.out.println("Utilizador " + this.name + "tem os objetos :\n");
      for (String id : myObjetos.keys()){
        Objeto objeto = myObjetos.get(id);
        System.out.println(objeto.toString());
      }
      return;
    }
    System.out.println("Utilizador " + this.name + "nao tem objetos :\n");
  }



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



  @Override
  public String toString() {
    return "UserBasic{" +
            "name='" + name + '\'' +
            ", id='" + id + '\'' +
            ", cachesVisitadas=" + cachesVisitadas +
            '}';
  }
}