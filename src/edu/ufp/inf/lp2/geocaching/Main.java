package edu.ufp.inf.lp2.geocaching;

import static edu.ufp.inf.lp2.geocaching.UserAdmin.cacheST;
import static edu.ufp.inf.lp2.geocaching.UserAdmin.userST;

public class Main {


    private static final String FILE_DELIMETER = ";";

    public static void main(String[] args) {
        teste1();

        //teste2();

    }


    public static void teste1(){
        System.out.println(userST.size());
        System.out.println(cacheST.size());


        //---------[Criação de utilizadores]---------
        UserBasic manuel= new UserBasic("Manuel", "1");
        UserBasic pedro= new UserBasic("Pedro", "2");
        UserAdmin fernando= new UserAdmin("Fernando", "3");
        UserBasic joana= new UserBasic("Joana", "4");
        UserPremium maria= new UserPremium("Maria", "5");
        UserAdmin filomena = new UserAdmin("Filomena", "6");

        //---------[Inserção de Utilizadores na ST]--------

        manuel.insertUser();
        pedro.insertUser();
        fernando.insertUser();
        joana.insertUser();
        maria.insertUser();
        filomena.insertUser();

        //---------[Print Utilizadores]---------

        fernando.printUser();


        //---------[Editar Utilizador da ST]---------
        //fernando.editarUser("LeticiaEditada","0000");
        //filomena.printUser();

//        //---------[Remover Utilizador]---------
        //u4.removerUser();
        //filomena.printUser();



//caches norte
        Cache c1= new Cache("1",CacheDiff.Easy,CacheType.Basic,maria,4117,-8614,"norte");
        Cache c2= new Cache("2",CacheDiff.Medium,CacheType.Basic,filomena,4116,-8585,"norte");
        Cache c3= new Cache("3",CacheDiff.Hard,CacheType.Basic,maria,4116,-8675,"norte");
        Cache c4= new Cache("4",CacheDiff.Easy,CacheType.Basic,filomena,4115,-8633,"norte");
        Cache c5= new Cache("5",CacheDiff.Easy,CacheType.Premium,maria,4114,-8612,"norte");
        Cache c6= new Cache("6",CacheDiff.Easy,CacheType.Basic,maria,4115,-8665,"norte");
        Cache c7= new Cache("7",CacheDiff.Easy,CacheType.Basic,maria,4124,-8680,"norte");


        //---------[Inserção na ST de Caches]---------
        fernando.insertCache(c1);
        filomena.insertCache(c2);
        fernando.insertCache(c3);
        filomena.insertCache(c4);
        filomena.insertCache(c5);
        filomena.insertCache(c6);
        filomena.insertCache(c7);


        fernando.printCache();

        maria.printhCaches();


        Date d1 = new Date(12,10,2021);
        Date d2 = new Date(15,11,2021);
        Date d3 = new Date(1,12,2021);
        Date d4 = new Date(27,12,2021);



//        //---------[Editar Caches da ST]---------
//       ivone.editCache(c4,"44",CacheDiff.Hard,tichinha,10,11,"PerreParisLondres");
//       ivone.printCache();
//
//        //---------[Remover Caches da ST]---------
//        ivone.removeCache(c1);
//        ivone.printCache();
//        c3.printObjetoFromCache();
//        c4.printObjetoFromCache();
//
//
//
        MessageLog log1 = new MessageLog("Estive aqui -1");
        MessageLog log2 = new MessageLog("Estive aqui -2");
        MessageLog log3 = new MessageLog("Estive aqui -3");
        MessageLog log4 = new MessageLog("Estive aqui -4");

        manuel.criarObjeto("ob1","BabyFace");
        manuel.criarObjeto("ob2","faca");
        manuel.criarObjeto("ob3","espada");

        pedro.criarObjeto("ob4","Tiagovski");
        fernando.criarObjeto("ob5","Miss");



        c3.criarObjeto("ob4","LEGENDBOY",filomena);
        c4.criarObjeto("ob5","CHENTRIC",filomena);


        fernando.criarTravelBug("22","TravelBug1",c1);
        maria.criarTravelBug("33","TravelBug2",c2);
        filomena.criarTravelBug("44","TravelBug3",c3);

        //tomas.printObjetos();

        manuel.visitarUmaCache_deixarObjeto(c1,log1,d1,"ob2");
        manuel.visitarUmaCache(c1,log2,d2);

        manuel.visitarUmaCache(c2,log2,d3);

        fernando.visitarUmaCache(c1,log2,d3);
        maria.visitarUmaCache(c1,log2,d3);
        maria.visitarUmaCache_deixarTravelBug(c3,log1,d1,"TravelBug2");
        //ruben.visitarUmaCache_TirarObjeto(c1,log2,d2,"ob2");

        System.out.println("\n------------------------------------------------------------------\n");




        fernando.printALLTravelBug();


        fernando.printObjetosAllUsers();

        fernando.printObjetosAllCaches();

        fernando.printUsers_historicoCaches();

        fernando.printCaches_historicoUsers();


        System.out.println("\n------------------------------------------------------------------\n");

        fernando.printALLTravelBug();


        fernando.printUserLogs();

        fernando.printCacheLogs();

        System.out.println("\n------------------------------------------------------------------\n");

        fernando.print_r8a_global(manuel);

        fernando.print_r8a_regiao(manuel,"AltoMinho");

        System.out.println("\n------------------------------------------------------------------\n");

        fernando.printr8b(manuel);

        fernando.print_r8b_regiao(manuel,"AltoMinho");

        fernando.printr8c(c1);

        fernando.printr8d();

        System.out.println("\n------------------------------------------------------------------\n");

        fernando.printr8e(d1,d4);

        fernando.printr8f();

        UserAdmin.saveUsers();

        UserAdmin.saveCaches();

        UserAdmin.saveObjetosCache();

        UserAdmin.saveObjetosUsers();

        UserAdmin.savehCachesehUsers();

        UserAdmin.saveLogsCache();

        UserAdmin.saveLogsUser();

        UserAdmin.saveMessageLogs();

        UserAdmin.saveTravelBugsHCaches();

        UserAdmin.saveTravelBugsHCUsers();

        UserAdmin.saveTravelBugsLogs();


        System.out.println("\n------------------------------------------------------------------\n");

        fernando.printMessageLogs();

        fernando.printALLTravelBugHCaches();
        fernando.printALLTravelBugHUsers();
        fernando.printAllTravelBugsLogs();

        fernando.now();

    }

    public static void teste2(){ //ler users

        System.out.println(userST.size());
        System.out.println(cacheST.size());

        UserAdmin.readUsers();
        UserAdmin.readCaches();
        UserAdmin.readObjetosCache();
        UserAdmin.readObjetosUsers();
        UserAdmin.readhCacheshUsers();
        UserAdmin.readLogsCache();
        UserAdmin.readLogsUsers();
        UserAdmin.readMessageLogs();
        UserAdmin.readTravelBugsHUsers();
        UserAdmin.readTravelBugsHCaches();
        UserAdmin.readTravelBugsLogs();



        UserBasic u1= userST.get("40097");
        UserBasic u2= userST.get("39917");
        UserPremium u3= (UserPremium) userST.get("0000");
        UserPremium u4= (UserPremium) userST.get("5555");
        UserAdmin u5= (UserAdmin) userST.get("1001");
        UserAdmin u6= (UserAdmin) userST.get("7004");



        u5.printUser();
        u5.printCache();
        u5.printObjetosAllCaches();
        u5.printObjetosAllUsers();
        u5.printUsers_historicoCaches();
        u5.printTravelBug();
        System.out.println("------------------------");
        u5.printCacheLogs();
        u5.printUserLogs();
        u5.printCacheLogs();
        u5.printMessageLogs();
        u5.printALLTravelBugHCaches();
        u5.printALLTravelBugHUsers();
        u5.printAllTravelBugsLogs();


    }

    public static void teste3(){

    }

    public static void teste4(){

    }

    public static void teste5(){

    }

    public static void teste6(){

    }

    public static void teste7(){

    }



}

