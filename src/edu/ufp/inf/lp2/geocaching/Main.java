package edu.ufp.inf.lp2.geocaching;

import java.io.IOException;

import static edu.ufp.inf.lp2.geocaching.UserAdmin.cacheST;
import static edu.ufp.inf.lp2.geocaching.UserAdmin.userST;

public class Main {




    public static void main(String[] args) throws IOException {
        //teste1();
        //teste2();

        testeprojeto();
        //testeprojeto2();
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

        UserAdmin.printUser();


        //---------[Editar Utilizador da ST]---------
        //fernando.editarUser("LeticiaEditada","0000");
        //filomena.printUser();

//        //---------[Remover Utilizador]---------
        //u4.removerUser();
        //filomena.printUser();



        //caches norte
        Cache c1= new Cache("1",CacheDiff.Easy,CacheType.Basic,maria,41.1720859,-8.6148178,"norte");
        Cache c2= new Cache("2",CacheDiff.Medium,CacheType.Basic,filomena,41.1605747,-8.5855818,"norte");
        Cache c3= new Cache("3",CacheDiff.Hard,CacheType.Basic,maria,41.1666825,-8.6751895,"norte");
        Cache c4= new Cache("4",CacheDiff.Easy,CacheType.Basic,filomena,41.158881,-8.6337921,"norte");
        Cache c5= new Cache("5",CacheDiff.Easy,CacheType.Premium,maria,41.1492281,-8.6120275,"norte");
        Cache c6= new Cache("6",CacheDiff.Easy,CacheType.Basic,maria,41.1504982,-8.6654695,"norte");
        Cache c7= new Cache("7",CacheDiff.Easy,CacheType.Basic,maria,41.2421226,-8.6807401,"norte");

        //caches centro
        Cache c8= new Cache("8",CacheDiff.Easy,CacheType.Basic,maria,40.2094433,-8.4208601,"centro");
        Cache c9= new Cache("9",CacheDiff.Medium,CacheType.Basic,filomena,40.2027321,-8.4333746,"centro");
        Cache c10= new Cache("10",CacheDiff.Hard,CacheType.Premium,maria,40.188891,-8.410378,"centro");
        Cache c11= new Cache("11",CacheDiff.Easy,CacheType.Basic,filomena,40.6394116,-8.6621375,"centro");
        Cache c12= new Cache("12",CacheDiff.Easy,CacheType.Basic,maria,40.6597787,-7.9136921,"centro");

        //caches sul
        Cache c13= new Cache("13",CacheDiff.Easy,CacheType.Basic,maria,38.6942546,-9.2129457,"sul");
        Cache c14= new Cache("14",CacheDiff.Medium,CacheType.Basic,filomena,38.7288464,-9.1481854,"sul");
        Cache c15= new Cache("15",CacheDiff.Hard,CacheType.Basic,maria,38.7756417,-9.1325313,"sul");
        Cache c16= new Cache("16",CacheDiff.Easy,CacheType.Premium,filomena,38.7527152,-9.1869627,"sul");
        Cache c17= new Cache("17",CacheDiff.Easy,CacheType.Basic,maria,38.7612341,-9.1639843,"sul");
        Cache c18= new Cache("18",CacheDiff.Easy,CacheType.Basic,maria,38.9369329,-9.3290594,"sul");

        //---------[Inserção na ST de Caches]---------
        filomena.insertCache(c1);
        filomena.insertCache(c2);
        fernando.insertCache(c3);
        filomena.insertCache(c4);
        filomena.insertCache(c5);
        filomena.insertCache(c6);
        filomena.insertCache(c7);
        filomena.insertCache(c8);
        filomena.insertCache(c9);
        filomena.insertCache(c10);
        filomena.insertCache(c11);
        filomena.insertCache(c12);
        filomena.insertCache(c13);
        filomena.insertCache(c14);
        filomena.insertCache(c15);
        filomena.insertCache(c16);
        filomena.insertCache(c17);
        filomena.insertCache(c18);


        UserAdmin.printCaches();

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


        //objetos caches
        c1.criarObjeto("ob1","canudo",filomena);
        c1.criarObjeto("ob2","livro",filomena);
        c1.criarObjeto("ob3","oculos",filomena);

        c2.criarObjeto("ob4","bola",filomena);
        c2.criarObjeto("ob5","brinquedo",filomena);
        c2.criarObjeto("ob6","camisola",filomena);

        c3.criarObjeto("ob7","pedra",filomena);
        c3.criarObjeto("ob8","flor",filomena);
        c3.criarObjeto("ob9","areia",filomena);

        c4.criarObjeto("ob10","flauta",filomena);

        c7.criarObjeto("ob11","bilhetes_aviao",filomena);

        c8.criarObjeto("ob12","canudo",filomena);
        c8.criarObjeto("ob13","capa",filomena);

        c10.criarObjeto("ob14","borracha",filomena);
        c10.criarObjeto("ob15","chaves",filomena);

        c11.criarObjeto("ob16","ovos_moles",filomena);

        c12.criarObjeto("ob17","espada",filomena);

        c15.criarObjeto("ob18","bilhetes_aviao",filomena);





        //travel bugs
        //filomena.criarTravelBug("1","travelbug1",c15);
        //filomena.criarTravelBug("2","travelbug2",c17);
        //filomena.criarTravelBug("3","travelbug3",c12);

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

        UserAdmin.printObjetosAllCaches();

        fernando.printUsers_historicoCaches();

        fernando.printCaches_historicoUsers();


        System.out.println("\n------------------------------------------------------------------\n");

        fernando.printALLTravelBug();


        UserAdmin.printUserLogs();

        fernando.printCacheLogs();

        System.out.println("\n------------------------------------------------------------------\n");

        fernando.print_r8a_global(manuel);

        fernando.print_r8a_regiao(manuel,"norte");

        System.out.println("\n------------------------------------------------------------------\n");

        fernando.printr8b(manuel);

        fernando.print_r8b_regiao(manuel,"norte");

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

        UserAdmin.saveTravelBugsHUsers();

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
        UserAdmin.readLogsUser();
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



        UserAdmin.printUser();
        UserAdmin.printCaches();
        UserAdmin.printObjetosAllCaches();
        u5.printObjetosAllUsers();
        u5.printUsers_historicoCaches();
        u5.printTravelBug();
        System.out.println("------------------------");
        u5.printCacheLogs();
        UserAdmin.printUserLogs();
        u5.printCacheLogs();
        u5.printMessageLogs();
        u5.printALLTravelBugHCaches();
        u5.printALLTravelBugHUsers();
        u5.printAllTravelBugsLogs();


    }


    public static void testeprojeto() throws IOException {

        UserAdmin.readUsers();
        UserAdmin.readCaches();
        UserAdmin.readObjetosCache();

        System.out.println("Tamanho de users " + userST.size());
        System.out.println("Tamanho de caches " +cacheST.size());

        //UserBasic manuel = userST.get("1");
        UserPremium manuel = (UserPremium) userST.get("1");
        //UserBasic pedro = userST.get("2");
        UserPremium pedro = (UserPremium) userST.get("2");
        UserAdmin fernando = (UserAdmin) userST.get("3");
        UserBasic joana = userST.get("4");
        UserPremium maria = (UserPremium) userST.get("5");
        UserAdmin filomena = (UserAdmin) userST.get("6");


        Cache cache1= cacheST.get("geocache1");
        Cache cache2= cacheST.get("geocache2");
        Cache cache3= cacheST.get("geocache3");
        Cache cache4= cacheST.get("geocache4");
        Cache cache5= cacheST.get("geocache5");
        Cache cache6= cacheST.get("geocache6");
        Cache cache7= cacheST.get("geocache7");
        Cache cache8= cacheST.get("geocache8");
        Cache cache9= cacheST.get("geocache9");
        Cache cache10= cacheST.get("geocache10");
        Cache cache11= cacheST.get("geocache11");
        Cache cache12= cacheST.get("geocache12");
        Cache cache13= cacheST.get("geocache13");
        Cache cache14= cacheST.get("geocache14");
        Cache cache15= cacheST.get("geocache15");
        Cache cache16= cacheST.get("geocache16");
        Cache cache17= cacheST.get("geocache17");
        Cache cache18= cacheST.get("geocache18");


        Date d1 = new Date(1,1,2021);
        Date d2 = new Date(2,1,2021);
        Date d3 = new Date(3,1,2021);
        Date d4 = new Date(4,1,2021);
        Date d5 = new Date(5,1,2021);
        Date d6 = new Date(6,1,2021);
        Date d7 = new Date(7,1,2021);
        Date d8 = new Date(8,1,2021);
        Date d9 = new Date(9,1,2021);
        Date d10 = new Date(10,1,2021);
        Date d11 = new Date(11,1,2021);
        Date d12 = new Date(12,1,2021);
        Date d13 = new Date(13,1,2021);
        Date d14 = new Date(14,1,2021);
        Date d15 = new Date(15,1,2021);
        Date d16 = new Date(16,1,2021);

        MessageLog logsManuel = new MessageLog("Logs do manuel");
        MessageLog logsPedro = new MessageLog("Logs do pedro");
        MessageLog logsFernando = new MessageLog("Logs do fernando");
        MessageLog logsJoana = new MessageLog("Logs do joana");
        MessageLog logsMaria = new MessageLog("Logs do maria");
        MessageLog logsFilomena = new MessageLog("Logs do filomena");


        System.out.println("Percuso do Manuel:");
        //1, 2, 6, 8, 13, 16, 17
        manuel.visitarUmaCache(cache1,logsManuel,d1);
        manuel.visitarUmaCache_TirarTravelBug(cache2,logsManuel,d2,"tb2");
        manuel.visitarUmaCache(cache6,logsManuel,d3);
        manuel.visitarUmaCache(cache8,logsManuel,d4);
        manuel.visitarUmaCache(cache13,logsManuel,d5);
        manuel.visitarUmaCache(cache16,logsManuel,d6);
        manuel.visitarUmaCache_deixarTravelBug(cache17,logsManuel,d7,"tb2");


        UserAdmin.printCacheLogs("geocache2");

        UserAdmin.printCacheLogs("geocache17");

        UserAdmin.printUserLogs();

        filomena.printAllTravelBugsLogs(pedro,"tb2");

        System.out.println("\n---------------------------------------------------------------------------------\n");

        System.out.println("Percuso do Pedro:");
        //18, 13, 8
        pedro.visitarUmaCache(cache18,logsPedro,d1);
        pedro.visitarUmaCache(cache13,logsPedro,d2);
        pedro.visitarUmaCache_TirarObjeto(cache8,logsPedro,d3,"ob13");

        UserAdmin.printCacheLogs("geocache8");

        UserAdmin.printUserLogs("2");



        System.out.println("\n---------------------------------------------------------------------------------\n");

        System.out.println("Percurso do Fernando:");
        //o Fernando visita as geocaches 12, 11, 10, 8, 9, 5, 6, 4, 3, 2, 1, 7, 15, 17, 18, 13.
        // Ao passar na geocache1 tirou o travelbug1. Ao passar na geocache 15 deixou ficar o travelbug1.

        fernando.visitarUmaCache(cache12,logsFernando,d1);
        fernando.visitarUmaCache(cache11,logsFernando,d2);
        fernando.visitarUmaCache(cache10,logsFernando,d3);
        fernando.visitarUmaCache(cache8,logsFernando,d4);
        fernando.visitarUmaCache(cache9,logsFernando,d5);
        fernando.visitarUmaCache(cache5,logsFernando,d6);
        fernando.visitarUmaCache(cache6,logsFernando,d7);
        fernando.visitarUmaCache(cache4,logsFernando,d8);
        fernando.visitarUmaCache(cache3,logsFernando,d9);
        fernando.visitarUmaCache(cache2,logsFernando,d10);
        fernando.visitarUmaCache_TirarTravelBug(cache1,logsFernando,d11,"tb1");
        fernando.visitarUmaCache(cache7,logsFernando,d12);
        fernando.visitarUmaCache_deixarTravelBug(cache15,logsFernando,d13,"tb1");
        fernando.visitarUmaCache(cache17,logsFernando,d14);
        fernando.visitarUmaCache(cache18,logsFernando,d15);
        fernando.visitarUmaCache(cache13,logsFernando,d16);

        UserAdmin.printCacheLogs("geocache1");

        UserAdmin.printCacheLogs("geocache15");

        UserAdmin.printUserLogs("3");





        System.out.println("\n---------------------------------------------------------------------------------\n");

        System.out.println("Percurso da Joana:");
        //a Joana visita as geocaches 14, 15, 18, 17, 13

        joana.visitarUmaCache(cache14,logsJoana,d1);
        joana.visitarUmaCache(cache15,logsJoana,d2);
        joana.visitarUmaCache(cache18,logsJoana,d3);
        joana.visitarUmaCache(cache17,logsJoana,d4);
        joana.visitarUmaCache(cache13,logsJoana,d5);

        UserAdmin.printUserLogs("4");


        System.out.println("\n---------------------------------------------------------------------------------\n");

        System.out.println("Percurso da Maria:");
        //a Maria visita as geocaches 3, 8, 9, 10, 16, 11, 12.
        // Ao passar na geocache 3 tirou o travelbug3. Ao passar na geocache12 deixou ficar o travelbug3.

        maria.visitarUmaCache_TirarTravelBug(cache3,logsMaria,d1,"tb3");
        maria.visitarUmaCache(cache8,logsMaria,d2);
        maria.visitarUmaCache(cache9,logsMaria,d3);
        maria.visitarUmaCache(cache10,logsMaria,d4);
        maria.visitarUmaCache(cache16,logsMaria,d5);
        maria.visitarUmaCache(cache11,logsMaria,d6);
        maria.visitarUmaCache_deixarTravelBug(cache12,logsMaria,d7,"tb3");


        UserAdmin.printCacheLogs("geocache3");

        UserAdmin.printCacheLogs("geocache12");

        UserAdmin.printUserLogs("5");



        System.out.println("\n---------------------------------------------------------------------------------\n");

        System.out.println("Percurso da Filomena:");
        //a Filomena visita as geocaches 5, 6, 7, 3, 2, 1, 8, 13

        filomena.visitarUmaCache(cache5,logsFilomena,d1);
        filomena.visitarUmaCache(cache6,logsFilomena,d2);
        filomena.visitarUmaCache(cache7,logsFilomena,d3);
        filomena.visitarUmaCache(cache3,logsFilomena,d4);
        filomena.visitarUmaCache(cache2,logsFilomena,d5);
        filomena.visitarUmaCache(cache1,logsFilomena,d6);
        filomena.visitarUmaCache(cache8,logsFilomena,d7);
        filomena.visitarUmaCache(cache13,logsFilomena,d8);

        UserAdmin.printUserLogs("6");


        System.out.println("\n---------------------------------------------------------------------------------\n");

        UserAdmin.printCaches();

        System.out.println("\n---------------------------------------------------------------------------------\n");

        UserAdmin.printObjetosAllCaches();

        System.out.println("\n---------------------------------------------------------------------------------\n");

        UserAdmin.printUser();

        System.out.println("\n---------------------------------------------------------------------------------\n");

        UserAdmin.printhCachesAllUsers();

        System.out.println("\n---------------------------------------------------------------------------------\n");

        UserAdmin.printr8b(pedro);

        UserAdmin.print_r8b_regiao(pedro,"centro");

        System.out.println("\n---------------------------------------------------------------------------------\n");

        UserAdmin.printCaches_historicoUsers("geocache6");

        System.out.println("\n---------------------------------------------------------------------------------\n");

        UserAdmin.printr8d();

        System.out.println("\n---------------------------------------------------------------------------------\n");

        UserAdmin.printr8e(d1,d16);

        System.out.println("\n---------------------------------------------------------------------------------\n");

        UserAdmin.printAllTravelBugsLogs();

        System.out.println("\n---------------------------------------------------------------------------------\n");



       // pedro.removerUser();
        //UserAdmin.removeCache(cache2);
        //UserAdmin.saveAll();


    }

    public static void testeprojeto2(){

        UserAdmin.readAll();
        UserPremium manuel = (UserPremium) userST.get("1");

        Date d1 = new Date(1,1,2021);
        Date d16 = new Date(16,1,2021);


        System.out.println("\n---------------------------------------------------------------------------------\n");

        UserAdmin.printCaches();

        System.out.println("\n---------------------------------------------------------------------------------\n");

        UserAdmin.printObjetosAllCaches();

        System.out.println("\n---------------------------------------------------------------------------------\n");

        UserAdmin.printUser();

        System.out.println("\n---------------------------------------------------------------------------------\n");

        UserAdmin.printhCachesAllUsers();

        System.out.println("\n---------------------------------------------------------------------------------\n");

        UserAdmin.printr8b(manuel);

        UserAdmin.print_r8b_regiao(manuel,"centro");

        System.out.println("\n---------------------------------------------------------------------------------\n");

        UserAdmin.printCaches_historicoUsers("geocache6");

        System.out.println("\n---------------------------------------------------------------------------------\n");

        UserAdmin.printr8d();

        System.out.println("\n---------------------------------------------------------------------------------\n");

        UserAdmin.printr8e(d1,d16);

        System.out.println("\n---------------------------------------------------------------------------------\n");

        UserAdmin.printAllTravelBugsLogs();

    }

}

