package edu.ufp.inf.lp2.geocaching;

import edu.ufp.inf.lp2.geocaching.AED2Class.RedBlackBST_AED2;

import java.io.Serializable;

public class UserPremium extends UserBasic implements Serializable {

    public double cachesEscondidas;
    public RedBlackBST_AED2<String,TravelBugs> meusTravelBugs = new RedBlackBST_AED2<>();

    /**
     * Construtor do UserPremium
     * @param name
     * @param id
     */

    public UserPremium(String name, String id) {
        super(name, id);
    }


    /**
     * Método para criar Travel Bug
     * @param id
     * @param nameItem
     * @param cacheMissao
     */
    public void criarTravelBug(String id, String nameItem,Cache cacheMissao){
    TravelBugs travelBugs = new TravelBugs(id,nameItem,this,cacheMissao);
    travelBugs.userAtual=this;
    travelBugs.cacheAtual=null;
    meusTravelBugs.put(travelBugs.nameItem,travelBugs);
    travelBugs.historicoUsers.put(this.id,this);
    this.myObjetos.put(travelBugs.nameItem,travelBugs);

    }

    /**
     * Método para printar Travel Bug dos Users
     */
    public void printTravelBug(){
        if(meusTravelBugs.size()>0){
            System.out.println("Utilizador " + this.name + " tem os TravelBugs :");
            for (String id : meusTravelBugs.keys()){
                TravelBugs travelBugs = meusTravelBugs.get(id);
                System.out.println(travelBugs.toString());
            }
            System.out.println("\n");
            return;
        }
        System.out.println("Utilizador " + this.name + " nao tem TravelBugs\n");
    }

    /**
     * Método visita uma cache -> deixa um travel bug
     * @param cache
     * @param mensagem
     * @param date
     * @param tb
     */
    public void visitarUmaCache_deixarTravelBug(Cache cache,MessageLog mensagem,Date date,String tb){
        if(!cache.type.equals(CacheType.Premium)){
            System.out.println("Esta cache nao é premium, logo nao e permitido o uso de Travel Bugs\n");
            return;
        }
        //Buscar travelBug ao bolso,remover do bolso
        TravelBugs travelBugs = (TravelBugs) myObjetos.get(tb);
        myObjetos.delete(tb);

        //se a cache onde vou chegar for o destino de travelbug
        if (cache.equals(travelBugs.cacheDestino)) {
            System.out.println("O Travel bug " + travelBugs.nameItem + " conclui a sua missao ao ser colocado pelo "+ this.name+ " na cache "
                    +cache.serialNumber +" no dia "+date.print() +".\n");
            TravelBugsLogs travelBugsLogs = new TravelBugsLogs(cache.serialNumber,this.id,cache,null,date);
            travelBugsLogs.destinoConcluido=true;
            travelBugs.historicoTravelBugsLogs.add(travelBugsLogs);

        }else{
            TravelBugsLogs travelBugsLogs = new TravelBugsLogs(cache.serialNumber,this.id,cache,null,date);
            travelBugsLogs.destinoConcluido=false;
            travelBugs.historicoTravelBugsLogs.add(travelBugsLogs);
        }
        //Adcionar Logs/mensagem
        CacheLogs cacheLogs = new CacheLogs(date,this.id,travelBugs.nameItem,null);
        cache.cacheLogs.add(cacheLogs);
        UserLogs userLogs = new UserLogs(date, cache.serialNumber, travelBugs.nameItem,null);
        this.userLogs.put(date,userLogs);
        cache.messageLogs.add(mensagem);

        travelBugs.cacheAtual=cache;
        travelBugs.userAtual=null;
        travelBugs.historicoCaches.put(cache.serialNumber,cache);
        cache.meusObjetos.put(travelBugs.id, travelBugs);
        cache.hUsers.put(date,this);

        this.hCaches.put(date,cache);
        this.cachesVisitadas++;
    }


    /**
     * Método visita uma cache -> tira um travel bug
     * @param cache
     * @param mensagem
     * @param date
     * @param tb
     */
    public void visitarUmaCache_TirarTravelBug(Cache cache,MessageLog mensagem,Date date,String tb){
        if(!cache.type.equals(CacheType.Premium)){
            System.out.println("Esta cache nao é premium, logo nao e permitido o uso de Travel Bugs\n");
            return;
        }
        //Vou buscar a cache, removo da cache,coloco no meu bolso
        TravelBugs tbCache = (TravelBugs) cache.meusObjetos.get(tb);
        tbCache.cacheAtual=null;
        tbCache.userAtual=this;
        cache.meusObjetos.delete(tb);
        this.myObjetos.put(tbCache.id,tbCache);

        TravelBugsLogs travelBugsLogs = new TravelBugsLogs(cache.serialNumber,this.id,null,this,date);
        travelBugsLogs.destinoConcluido=false;
        tbCache.historicoTravelBugsLogs.add(travelBugsLogs);


        //Adcionar Logs/mensagem
        CacheLogs cacheLogs = new CacheLogs(date,this.id,null,tbCache.nameItem);
        UserLogs userLogs = new UserLogs(date, cache.serialNumber, null,tbCache.nameItem);
        cache.cacheLogs.add(cacheLogs);
        this.userLogs.put(date,userLogs);
        cache.messageLogs.add(mensagem);


        tbCache.historicoUsers.put(this.id,this);
        cache.hUsers.put(date,this);

        this.hCaches.put(date,cache);
        this.cachesVisitadas++;
    }

    /**
     * Método visita uma cache -> troca um travel bug
     * @param cache
     * @param mensagem
     * @param date
     * @param tb
     * @param tb_retirar
     */
    public void visitarUmaCache_trocarTravelBugs(Cache cache,MessageLog mensagem,Date date,String tb,String tb_retirar){
        if(!cache.type.equals(CacheType.Premium)){
            System.out.println("Esta cache nao é premium, logo nao e permitido o uso de Travel Bugs\n");
            return;
        }
        //Removo travelbug do bolso , adciona a cache, removo tb da cache,adciono no bolso
        TravelBugs tbColocar = (TravelBugs) myObjetos.get(tb);
        myObjetos.delete(tb);
        TravelBugs tbRetirar = (TravelBugs) cache.meusObjetos.get(tb_retirar);
        cache.meusObjetos.delete(tb_retirar);

        tbColocar.userAtual=null;
        tbColocar.cacheAtual=cache;
        tbRetirar.userAtual=this;
        tbRetirar.cacheAtual=null;




        if (cache.equals(tbColocar.cacheDestino)) {
            System.out.println("O Travel bug : " + tbColocar.nameItem + "conclui a sua missao.\n");
            TravelBugsLogs travelBugsLogs = new TravelBugsLogs(cache.serialNumber,this.id,cache,null,date);
            travelBugsLogs.destinoConcluido=true;
            tbColocar.historicoTravelBugsLogs.add(travelBugsLogs);

        }else{
            TravelBugsLogs travelBugsLogs = new TravelBugsLogs(cache.serialNumber,this.id,cache,null,date);
            travelBugsLogs.destinoConcluido=false;
            tbColocar.historicoTravelBugsLogs.add(travelBugsLogs);
        }


        CacheLogs cacheLogs = new CacheLogs(date,this.id,tbColocar.nameItem,tb_retirar);
        UserLogs userLogs = new UserLogs(date,cache.serialNumber,tbColocar.nameItem,tbRetirar.nameItem);

        this.userLogs.put(date,userLogs);
        cache.cacheLogs.add(cacheLogs);
        cache.messageLogs.add(mensagem);

        tbColocar.historicoCaches.put(cache.serialNumber,cache);
        tbRetirar.historicoUsers.put(this.id,this);
        cache.meusObjetos.put(tbColocar.id,tbColocar);
        this.meusTravelBugs.put(tbRetirar.id,tbRetirar);

        //logs tb retirar
        TravelBugsLogs travelBugsLogs = new TravelBugsLogs(cache.serialNumber,this.id,null,this,date);
        tbRetirar.historicoTravelBugsLogs.add(travelBugsLogs);
        tbRetirar.cacheAtual=null;
        tbRetirar.userAtual=this;


        this.hCaches.put(date,cache);
        cache.hUsers.put(date,this);
        this.cachesVisitadas++;


    }

    /**
     * Método printa Logs de um determinado travel bug
     * @param travelBug
     */
    void printLogs_1TravelBug(String travelBug){
            TravelBugs tb = this.meusTravelBugs.get(travelBug);
            for (TravelBugsLogs tbL : tb.historicoTravelBugsLogs){
                System.out.println(tbL.toString());
            }
    }

    /**
     * Método printa Logs de travel bugs
     */
    void printLogs_TravelBugs(){
        if(this.meusTravelBugs.size()>0){
            for (String key : meusTravelBugs.keys()){
                TravelBugs travelBugs = meusTravelBugs.get(key);
                for (TravelBugsLogs tbL : travelBugs.historicoTravelBugsLogs){
                    System.out.println(tbL.toString());
                }
            }
        }

    }


    @Override
    public String toString() {
        return "UserPremium{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", cachesVisitadas=" + cachesVisitadas +
                '}';
    }
}