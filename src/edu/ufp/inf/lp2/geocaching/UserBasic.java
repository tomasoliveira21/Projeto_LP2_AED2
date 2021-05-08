package edu.ufp.inf.lp2.geocaching;
import edu.princeton.cs.algs4.BST;
import edu.princeton.cs.algs4.LinearProbingHashST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.io.IOException;

import static edu.ufp.inf.lp2.geocaching.UserAdmin.userST;


public class UserBasic{


  public String name;

  public String id;

  public double cachesVisitadas;


  public BST<String,Objeto> myObjetos = new BST<>();

  public LinearProbingHashST<Date , Cache> hCaches = new LinearProbingHashST<>();//sempre que um user visitar uma cache adiciono na Hcache

  public SeparateChainingHashST<Date , UserLogs> userLogs = new SeparateChainingHashST<>();//sempre que um user visitar uma cache adiciono na Hcache


  public UserBasic(String name, String id) {
    this.name = name;
    this.id = id;
    this.cachesVisitadas = 0;
    this.insertUser();
  }



  public void insertUser(){
    userST.put(this.id, this);
  }

  public void removerUser() throws IOException {
    UserAdmin.ficheiroRemoverUser(this);
    userST.remove(this.id);
  }

  public void removerUser(String id){
    userST.remove(id);
  }

  public void editarUser(String nome,String id){
    userST.remove(this.id);
    this.name=nome;
    this.id=id;
    userST.put(this.id,this);
  }

  public void criarObjeto(String id , String nameItem){
      Objeto objeto = new Objeto(id,nameItem,this);
      objeto.criadorObjeto=this;
      myObjetos.put(objeto.id,objeto);
      objeto.cacheAtual=null;
      objeto.userAtual=this;


  }



  public void visitarUmaCache(Cache cache,MessageLog mensagem,Date date){
    for (CacheLogs cacheLogs :cache.cacheLogs){
      if(cacheLogs.data.equals(date) && cacheLogs.userID.equals(this.id)){
        System.out.println("Erro! User " + this.name + " ja visitou esta cache neste dia " + date.print());
        return;
      }
    }

    CacheLogs cl = new CacheLogs(date,this.id,null,null);
    UserLogs ul = new UserLogs(date,cache.serialNumber,null,null);


    cache.cacheLogs.add(cl);
    this.userLogs.put(date,ul);
    this.cachesVisitadas++;

    cache.messageLogs.add(mensagem);
    //Adcionar Logs

    this.hCaches.put(date,cache);
    cache.hUsers.put(date,this);
  }

  public void visitarUmaCache_deixarObjeto(Cache cache,MessageLog mensagem,Date date,String obj){

    for (CacheLogs cacheLogs :cache.cacheLogs){
      if(cacheLogs.data.equals(date) && cacheLogs.userID.equals(this.id)){
        System.out.println("Erro! User " + this.name + " ja visitou esta cache neste dia " + date.print());
        return;
      }
    }
    //procurar objeto no bolso e  remove lo
    Objeto objeto = this.myObjetos.get(obj);
    this.myObjetos.delete(obj);

    //criar cacheLog
    CacheLogs cl = new CacheLogs(date,this.id,objeto.id,null);
    cache.cacheLogs.add(cl);
    UserLogs ul = new UserLogs(date,cache.serialNumber,objeto.id,null);
    this.userLogs.put(date,ul);



    //Colocar objeto na Cache
    cache.meusObjetos.put(objeto.id,objeto);
    objeto.cacheAtual=cache;
    objeto.userAtual=null;
  //Deixar mensagem
    cache.messageLogs.add(mensagem);

    //aumenta visitas, colocar no historico de caches e historico de users
    this.cachesVisitadas++;
    this.hCaches.put(date,cache);
    cache.hUsers.put(date,this);

  }

  public void visitarUmaCache_TirarObjeto(Cache cache,MessageLog mensagem,Date date,String obj){
    for (CacheLogs cacheLogs :cache.cacheLogs){
      if(cacheLogs.data.equals(date) && cacheLogs.userID.equals(this.id)){
        System.out.println("Erro! User " + this.name + " ja visitou esta cache neste dia " + date.print());
        return;
      }
    }
    //procurar objeto na cache, removelo da cache,adciona lo no meu bolso
    Objeto objeto = cache.meusObjetos.get(obj);
    objeto.cacheAtual=null;
    objeto.userAtual=this;
    this.myObjetos.put(objeto.id,objeto);
    cache.meusObjetos.delete(objeto.id);

    //criar cacheLog
    CacheLogs cl = new CacheLogs(date,this.id,null,objeto.id);
    cache.cacheLogs.add(cl);
    UserLogs ul = new UserLogs(date,cache.serialNumber,null,objeto.id);
    this.userLogs.put(date,ul);


    //Deixar mensagem
    cache.messageLogs.add(mensagem);

    //aumenta visitas, colocar no historico de caches e historico de users
    this.cachesVisitadas++;
    this.hCaches.put(date,cache);
    cache.hUsers.put(date,this);

  }



  public void visitarUmaCache_trocarObjeto(Cache cache,MessageLog mensagem,Date date,String obj,Objeto objCache){
    for (CacheLogs cacheLogs :cache.cacheLogs){
      if(cacheLogs.data.equals(date) && cacheLogs.userID.equals(this.id)){
        System.out.println("Erro! User " + this.name + " ja visitou esta cache neste dia " + date.print());
        return;
      }
    }
    Objeto objetoColocar = this.myObjetos.get(obj);
    this.myObjetos.delete(obj);
    this.myObjetos.put(objCache.id,objCache);
    cache.meusObjetos.put(objetoColocar.id,objetoColocar);

    cache.meusObjetos.delete(objCache.id);

    CacheLogs cl = new CacheLogs(date,this.id,objetoColocar.id,objCache.id);
    cache.cacheLogs.add(cl);
    UserLogs ul = new UserLogs(date,cache.serialNumber,objetoColocar.id,objCache.id);
    this.userLogs.put(date,ul);

    objetoColocar.userAtual=null;
    objetoColocar.cacheAtual=cache;
    objCache.userAtual=this;
    objCache.cacheAtual=null;




    cache.messageLogs.add(mensagem);

    this.cachesVisitadas++;
    this.hCaches.put(date,cache);
    cache.hUsers.put(date,this);
  }


  public void printObjetos(){

    if(myObjetos.size()>0){
      System.out.println("Utilizador " + this.name + " tem os objetos :");
      for (String id : myObjetos.keys()){
        Objeto objeto = myObjetos.get(id);
        System.out.println(objeto.toString());
      }
      System.out.println("\n");
      return;
    }
    System.out.println("Utilizador " + this.name + "nao tem objetos\n");
  }


  public  void printhCaches(){
    if(hCaches.size()>0){
      System.out.println("Utilizador " + name + " visitou as seguintes caches :\n");
      for (Date d : hCaches.keys()){
        Cache c = hCaches.get(d);
        System.out.println(c.toString() + " no dia " + d.print());
      }
      return;
    }
    System.out.println("Utilizador " + this.name + " ainda nao visitou nenhuma cache\n");
  }


  public static void printhCachesAllUsers(){
    System.out.println("Caches visitadas pelos utilizadores");
    for (String id : userST.keys()){
      UserBasic basic = userST.get(id);
      if(!basic.getClass().equals(UserBasic.class)){
        UserPremium premium = (UserPremium) userST.get(id);
        if(premium.hCaches.size()>0){
          System.out.println("\tUtilizador " + premium.name + " visitou as seguintes caches :\n");
          for (Date d : premium.hCaches.keys()){
            Cache c = premium.hCaches.get(d);
            System.out.println("\t\t" +c.toString() + " no dia " + d.print());
          }
        }else{ System.out.println("\tUtilizador " + premium.name + " ainda nao visitou nenhuma cache\n");

        }
      }

      System.out.println();
    }


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