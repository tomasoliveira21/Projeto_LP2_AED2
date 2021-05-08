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
        UserBasic tomas= new UserBasic("Tomas", "40097");
        UserBasic ruben= new UserBasic("Ruben", "39917");
        UserPremium leticia= new UserPremium("Leticia", "1904");
        UserPremium leonor= new UserPremium("Leonor", "5555");
        UserAdmin ivone= new UserAdmin("Ivone", "1001");
        UserAdmin tichinha = new UserAdmin("Tichinha", "7004");

        //---------[Inserção de Utilizadores na ST]--------

        tomas.insertUser();
        ruben.insertUser();
        leticia.insertUser();
        leonor.insertUser();
        ivone.insertUser();
        tichinha.insertUser();

        //---------[Print Utilizadores]---------
        ivone.printUser();


        //---------[Editar Utilizador da ST]---------
        leticia.editarUser("LeticiaEditada","0000");
        ivone.printUser();

//        //---------[Remover Utilizador]---------
        //u4.removerUser();
        ivone.printUser();

//
//       // ---------[Escrever e Ler Utilizadores do ficheiro]---------
//        writeUser_txt(".//data/user.txt");
//        readUser_txt(".//data/user.txt");
//        printUsers();


        //---------[Caches de objetos e Caches]---------
        /*Objeto rato = new Objeto("44","rato");
        Objeto teclado= new Objeto("55", "teclado");
        Objeto monitor = new Objeto("66", "monitor");
        ArrayList<Objeto> lista1= new ArrayList<>();
        lista1.add(rato);
        lista1.add(teclado);

        ArrayList<Objeto> lista2= new ArrayList<>();
        lista2.add(rato);
        lista2.add(monitor);
         */

        Cache c1= new Cache("00",CacheDiff.Easy,CacheType.Basic,ivone,2,4,"AltoMinho");
        Cache c12= new Cache("01",CacheDiff.Easy,CacheType.Basic,ivone,2,4,"AltoMinho");
        Cache c13= new Cache("02",CacheDiff.Easy,CacheType.Basic,ivone,2,4,"AltoMinho");
        Cache c2= new Cache("11",CacheDiff.Medium,CacheType.Basic,tichinha,7,7,"Cardielos");
        Cache c3= new Cache("22",CacheDiff.Hard,CacheType.Premium,ivone,1,3,"Viana");
        Cache c4= new Cache("33",CacheDiff.Easy,CacheType.Premium,tichinha,8,9,"Perre");


        //---------[Inserção na ST de Caches]---------
        ivone.insertCache(c1);
        tichinha.insertCache(c2);
        ivone.insertCache(c3);
        tichinha.insertCache(c4);

        tichinha.insertCache(c12);
        tichinha.insertCache(c13);


        ivone.printCache();

        ivone.printhCaches();


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
//      //---------[Escrever e Ler Caches e Objetos do ficheiro]---------
//        writeCache_txt(".//data/cache.txt");
//        writeObjeto_txt(".//data/objeto.txt");
//        //falta ler da cache e do objeto
//        ivone.printCache();
//





        MessageLog log1 = new MessageLog("Estive aqui -1");
        MessageLog log2 = new MessageLog("Estive aqui -2");
        MessageLog log3 = new MessageLog("Estive aqui -3");
        MessageLog log4 = new MessageLog("Estive aqui -4");

        tomas.criarObjeto("ob1","BabyFace");
        tomas.criarObjeto("ob2","faca");
        tomas.criarObjeto("ob3","espada");

        ruben.criarObjeto("ob4","Tiagovski");
        leticia.criarObjeto("ob5","Miss");



        c3.criarObjeto("ob4","LEGENDBOY",tichinha);
        c4.criarObjeto("ob5","CHENTRIC",tichinha);


        leticia.criarTravelBug("22","TravelBug1",c1);
        ivone.criarTravelBug("33","TravelBug2",c2);
        tichinha.criarTravelBug("44","TravelBug3",c3);

        //tomas.printObjetos();

        tomas.visitarUmaCache_deixarObjeto(c1,log1,d1,"ob2");
        tomas.visitarUmaCache(c1,log2,d2);

        tomas.visitarUmaCache(c2,log2,d3);

        leticia.visitarUmaCache(c1,log2,d3);
        ivone.visitarUmaCache(c1,log2,d3);
        ivone.visitarUmaCache_deixarTravelBug(c3,log1,d1,"TravelBug2");
        //ruben.visitarUmaCache_TirarObjeto(c1,log2,d2,"ob2");

        System.out.println("\n------------------------------------------------------------------\n");




        ivone.printALLTravelBug();


        ivone.printObjetosAllUsers();

        ivone.printObjetosAllCaches();

        ivone.printUsers_historicoCaches();

        ivone.printCaches_historicoUsers();


        System.out.println("\n------------------------------------------------------------------\n");

        ivone.printALLTravelBug();


        ivone.printUserLogs();

        ivone.printCacheLogs();

        System.out.println("\n------------------------------------------------------------------\n");

        ivone.print_r8a_global(tomas);

        ivone.print_r8a_regiao(tomas,"AltoMinho");

        System.out.println("\n------------------------------------------------------------------\n");

        ivone.printr8b(tomas);

        ivone.print_r8b_regiao(tomas,"AltoMinho");

        ivone.printr8c(c1);

        ivone.printr8d();

        System.out.println("\n------------------------------------------------------------------\n");

        ivone.printr8e(d1,d4);

        ivone.printr8f();

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

        ivone.printMessageLogs();

        ivone.printALLTravelBugHCaches();
        ivone.printALLTravelBugHUsers();
        ivone.printAllTravelBugsLogs();

        ivone.now();

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

