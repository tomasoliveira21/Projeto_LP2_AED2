package edu.ufp.inf.lp2.geocaching;

import edu.princeton.cs.algs4.RedBlackBST;

public class UserPremium extends UserBasic {

    public double cachesEscondidas;
    public RedBlackBST<String,TravelBugs> meusTravelBugs = new RedBlackBST<>();

    public UserPremium(String name, String id) {
        super(name, id);
    }


    public void criarTravelBug(String id, String nameItem,Cache cacheMissao){
    TravelBugs travelBugs = new TravelBugs(id,nameItem,this,cacheMissao);
    meusTravelBugs.put(travelBugs.nameItem,travelBugs);
    travelBugs.historicoUsers.put(this.id,this);
    this.myObjetos.put(travelBugs.nameItem,travelBugs);
    travelBugs.cacheAtual=null;

    }


    public void printTravelBug(){
        if(meusTravelBugs.size()>0){
            System.out.println("Utilizador " + this.name + "tem os TravelBugs :\n");
            for (String id : meusTravelBugs.keys()){
                TravelBugs travelBugs = meusTravelBugs.get(id);
                System.out.println(travelBugs.toString());
            }
            return;
        }
        System.out.println("Utilizador " + this.name + "nao tem TravelBugs\n");
    }

    public void visitarUmaCache_deixarTravelBug(Cache cache,MessageLog mensagem,Date date,String tb){
        if(!cache.type.equals(CacheType.Premium)){
            System.out.println("Esta cache nao é premium, logo nao e permitido o uso de Travel Bugs\n");
            return;
        }
        TravelBugs travelBugs = (TravelBugs) myObjetos.get(tb);
        myObjetos.delete(tb);

        if (cache.equals(travelBugs.cacheDestino)) {
            System.out.println("O Travel bug : " + travelBugs.nameItem + "conclui a sua missao.\n");
            TravelBugsLogs travelBugsLogs = new TravelBugsLogs(cache.serialNumber,this.id,cache,null);
            travelBugsLogs.destinoConcluido=true;
            travelBugs.historicoTravelBugsLogs.add(travelBugsLogs);

        }else{
            TravelBugsLogs travelBugsLogs = new TravelBugsLogs(cache.serialNumber,this.id,cache,null);
            travelBugsLogs.destinoConcluido=false;
            travelBugs.historicoTravelBugsLogs.add(travelBugsLogs);
        }
        //duvida travelBugs.nameItem pode ser null
        CacheLogs cacheLogs = new CacheLogs(date,this.id,travelBugs.nameItem,null);
        cache.cacheLogs.add(cacheLogs);
        cache.messageLogs.add(mensagem);

        travelBugs.cacheAtual=cache;
        travelBugs.userAtual=null;
        travelBugs.historicoCaches.put(cache.serialNumber,cache);
        cache.meusObjetos.put(travelBugs.nameItem, travelBugs);
        cache.hUsers.put(date,this);

        this.hCaches.put(date,cache);
        this.cachesVisitadas++;
    }

    public void visitarUmaCache_trocarTravelBugs(Cache cache,MessageLog mensagem,Date date,String tb,String tb_retirar){
        if(!cache.type.equals(CacheType.Premium)){
            System.out.println("Esta cache nao é premium, logo nao e permitido o uso de Travel Bugs\n");
            return;
        }
        TravelBugs travelBugs = (TravelBugs) myObjetos.get(tb);
        myObjetos.delete(tb);

        if (cache.equals(travelBugs.cacheDestino)) {
            System.out.println("O Travel bug : " + travelBugs.nameItem + "conclui a sua missao.\n");
            TravelBugsLogs travelBugsLogs = new TravelBugsLogs(cache.serialNumber,this.id,cache,null);
            travelBugsLogs.destinoConcluido=true;
            travelBugs.historicoTravelBugsLogs.add(travelBugsLogs);

        }else{
            TravelBugsLogs travelBugsLogs = new TravelBugsLogs(cache.serialNumber,this.id,cache,null);
            travelBugsLogs.destinoConcluido=false;
            travelBugs.historicoTravelBugsLogs.add(travelBugsLogs);
        }
        //duvida travelBugs.nameItem pode ser null
        TravelBugs tbRetirar = (TravelBugs) cache.meusObjetos.get(tb_retirar);
        CacheLogs cacheLogs = new CacheLogs(date,this.id,travelBugs.nameItem,tb_retirar);

        cache.cacheLogs.add(cacheLogs);
        cache.messageLogs.add(mensagem);
        cache.meusObjetos.delete(tb_retirar);

        travelBugs.historicoCaches.put(cache.serialNumber,cache);
        travelBugs.cacheAtual=cache;
        travelBugs.userAtual=null;
        cache.meusObjetos.put(travelBugs.nameItem,travelBugs);

        TravelBugsLogs travelBugsLogs = new TravelBugsLogs(cache.serialNumber,this.id,cache,this);
        tbRetirar.historicoTravelBugsLogs.add(travelBugsLogs);
        tbRetirar.cacheAtual=null;
        tbRetirar.userAtual=this;
        this.meusTravelBugs.put(tbRetirar.nameItem,tbRetirar);
        tbRetirar.historicoUsers.put(this.id,this);

        this.hCaches.put(date,cache);
        cache.hUsers.put(date,this);
        this.cachesVisitadas++;


    }


    void printLogs_1TravelBug(String travelBug){
            TravelBugs tb = this.meusTravelBugs.get(travelBug);
            for (TravelBugsLogs tbL : tb.historicoTravelBugsLogs){
                System.out.println(tbL.toString());
            }
    }

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