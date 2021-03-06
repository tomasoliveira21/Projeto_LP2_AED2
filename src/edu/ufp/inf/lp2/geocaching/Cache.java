package edu.ufp.inf.lp2.geocaching;

import edu.ufp.inf.lp2.geocaching.AED2Class.BST_AED2;
import edu.ufp.inf.lp2.geocaching.AED2Class.ST_AED2;

import java.io.Serializable;
import java.util.ArrayList;


public class Cache implements Serializable {

  public ST_AED2<Date, UserBasic> hUsers= new ST_AED2<>();
  public ArrayList<MessageLog> messageLogs = new ArrayList<>();
  public ArrayList<CacheLogs> cacheLogs = new ArrayList<>();
  public BST_AED2<String,Objeto> meusObjetos =new BST_AED2<>();

  public UserPremium userCreator;
  public CacheDiff diff;
  public CacheType type;
  public String serialNumber;

  public double x;
  public double y;
  public String regiao;



/**
 * Construtor Cache
 */
  public Cache(String serialNumber, CacheDiff diff ,CacheType type, UserPremium userCreator , double x, double y, String regiao) {
    this.serialNumber = serialNumber;
    this.diff =diff;
    this.userCreator = userCreator;
    this.x = x;
    this.y = y;
    this.regiao=regiao;
    this.type=type;
  }


  /**
   * Método que cria um Objeto inserindo-o na BST dos meusObjetos
   * @param id
   * @param nameItem
   * @param creatorID
   */
   public void criarObjeto(String id , String nameItem,UserBasic creatorID){
    Objeto objeto = new Objeto(id,nameItem,creatorID);
    objeto.criadorObjeto=creatorID;
    meusObjetos.put(objeto.id,objeto);
    objeto.cacheAtual=this;
    objeto.userAtual=null;
  }



  public Cache() {

  }


  /**
   * Método que printa todos os objetos da cache
   */
  public void printObjetoFromCache(){
    for (String id :meusObjetos.keys()){
      Objeto obj = meusObjetos.get(id);
      System.out.println(obj.toString());
    }
  }


  @Override
  public String toString() {
    return "\tCache{" +
            "userCreator=" + userCreator.name +
            ", type=" + diff +
            ", serialNumber='" + serialNumber + '\'' +
            ", x=" + x +
            ", y=" + y +
            ", regiao='" + regiao + '\'' +
            '}';
  }







  public String getUserCreator() {
    String userCreator = this.userCreator.name;
    return userCreator;
  }

  public String getDiff() {
    String diff = "Easy";
    if(this.diff.equals(CacheDiff.Medium))diff = "Medium";
    else if(this.diff.equals(CacheDiff.Hard))diff = "Hard";
    return diff;
  }

  public String getType() {
    String type = "Basic";
    if(this.type.equals(CacheType.Premium))type = "Premium";
    return type;
  }



  public String getCoordenadas(){
    String coordenadas = x + " | " + y;
    return coordenadas;
  }

  public String getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  public String getRegiao() {
    return regiao;
  }

  public void setRegiao(String regiao) {
    this.regiao = regiao;
  }
}


//codigo antigo (Prof.Diogo Machado)
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

  public void addVisitante(UserBasic u1){ //Receber String de input
    Date d = Calendar.getInstance().getTime();
    hUsers.put(d,u1);
  }



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



   hUsers.put(nUtilizadores,u1);
    nUtilizadores++;




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
