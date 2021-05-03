package edu.ufp.inf.lp2.geocaching;

import edu.princeton.cs.algs4.BST;
import edu.princeton.cs.algs4.ST;

import java.util.ArrayList;


public class Cache{ // é necessario fazer extends do userBasic (?)

  //public int nUtilizadores;
  public ST<Date, UserBasic> hUsers= new ST<>();
  public ArrayList<MessageLog> messageLogs = new ArrayList<>();
  public ArrayList<CacheLogs> cacheLogs = new ArrayList<>();
  public BST<String,Objeto> meusObjetos =new BST<>();

  public UserPremium userCreator;
  public CacheDiff diff;
  public CacheType type;
  public String serialNumber;



  public int x;
  public int y;
  public String regiao;

  public String getRegiao() {
    return regiao;
  }

  public void setRegiao(String regiao) {
    this.regiao = regiao;
  }

  public String getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
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


  public Cache(String serialNumber, CacheDiff diff ,CacheType type, UserPremium userCreator , int x, int y, String regiao) {
    this.serialNumber = serialNumber;
    this.diff =diff;
    this.userCreator = userCreator;
    this.x = x;
    this.y = y;
    this.regiao=regiao;
    this.type=type;
  }


 /* public void addObjectToArrayList(Objeto objeto) throws AlreadyRegisteredObjectException {
    if (!meusObjetos.contains(objeto)) {
      meusObjetos.add(objeto);
    }
    throw new AlreadyRegisteredObjectException("Object already registered!");
  }

  public boolean removeObjectFromCache(String nameItem) {
    for (int i = 0; i < meusObjetos.size(); i++) {
      meusObjetos.get(i).nameItem.equals(nameItem);
      if (meusObjetos.get(i).nameItem.equals(nameItem)) {
        return meusObjetos.remove(meusObjetos.get(i));
      }
    }
    return false;

  }
*/
  public void printObjetoFromCache(){ //printa todos os objetos da cache
    System.out.println("Item da Lista de objetos: ");
    for (String id :meusObjetos.keys()){
      Objeto obj = meusObjetos.get(id);
      System.out.println(obj.toString());
    }
  }


 /* public void addVisitante(UserBasic u1){ //Receber String de input
    Date d = Calendar.getInstance().getTime();
    hUsers.put(d,u1);
  }
  */

/*
  public void addVisitante(UserBasic u1, String date){ //Receber String de input
  if(date==null){
    addVisitante(u1);
    return;
  }
    Date result = null;
    try{
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      result  = dateFormat.parse(date);
    }

    catch(ParseException e){
      e.printStackTrace();

    }

    hUsers.put(result,u1);
  }

 */

  /* hUsers.put(nUtilizadores,u1);
    nUtilizadores++;

   */

  /*
  public boolean interacaoCache(UserBasic user, ArrayList<Objeto> objetoscolocados, ArrayList<Objeto> objetosretirados,String date, String mensagem){
    addVisitante(user,date);
    boolean encontrouobjeto= false;
    for (Objeto objretirado: objetosretirados){
      for (Objeto obj: arrayListObjeto){
        if(objretirado==obj){
          arrayListObjeto.remove(obj);
          encontrouobjeto=true;
        }
        break;
      }
      if (encontrouobjeto==false){
        return false;
      }else {
        encontrouobjeto=false;
      }
    }

    objetoscolocados.addAll(objetoscolocados);
    MessageLog objlogs=new MessageLog(date,mensagem);
    messageLogs.add(objlogs);
    CacheLogs cachelog= new CacheLogs(date,user,objetoscolocados,objetosretirados);
    cacheLogs.add(cachelog);
    return true;
  }
*/


  @Override
  public String toString() {
    return "Cache{" +
            "userCreator=" + userCreator.name +
            ", type=" + diff +
            ", serialNumber='" + serialNumber + '\'' +
           //precisar do for
            ", x=" + x +
            ", y=" + y +
            ", regiao='" + regiao + '\'' +
            '}';
  }
}

