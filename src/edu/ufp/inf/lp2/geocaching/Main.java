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
        UserBasic u1= new UserBasic("Tomas", "40097");
        UserBasic u2= new UserBasic("Ruben", "39917");
        UserPremium u3= new UserPremium("Leticia", "1904");
        UserPremium u4= new UserPremium("Leonor", "5555");
        UserAdmin u5= new UserAdmin("Ivone", "1001");
        UserAdmin u6= new UserAdmin("Tichinha", "7004");

        //---------[Inserção de Utilizadores na ST]--------

        u1.insertUser();
        u2.insertUser();
        u3.insertUser();
        u4.insertUser();
        u5.insertUser();
        u6.insertUser();

        //---------[Print Utilizadores]---------
        u5.printUser();


        //---------[Editar Utilizador da ST]---------
        u3.editarUser("LeticiaEditada","0000");
        u5.printUser();

//        //---------[Remover Utilizador]---------
        //u4.removerUser();
        u5.printUser();

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

        Cache c1= new Cache("00",CacheDiff.Easy,CacheType.Basic,u5,2,4,"AltoMinho");
        Cache c12= new Cache("01",CacheDiff.Easy,CacheType.Basic,u5,2,4,"AltoMinho");
        Cache c13= new Cache("02",CacheDiff.Easy,CacheType.Basic,u5,2,4,"AltoMinho");
        Cache c2= new Cache("11",CacheDiff.Medium,CacheType.Basic,u6,7,7,"Cardielos");
        Cache c3= new Cache("22",CacheDiff.Hard,CacheType.Premium,u5,1,3,"Viana");
        Cache c4= new Cache("33",CacheDiff.Easy,CacheType.Premium,u6,8,9,"Perre");


        //---------[Inserção na ST de Caches]---------
        u5.insertCache(c1);
        u6.insertCache(c2);
        u5.insertCache(c3);
        u6.insertCache(c4);

        u6.insertCache(c12);
        u6.insertCache(c13);


        u5.printCache();

        u5.printhCaches();


        Date d1 = new Date(12,10,2021);
        Date d2 = new Date(15,11,2021);
        Date d3 = new Date(1,12,2021);
        Date d4 = new Date(27,12,2021);



//        //---------[Editar Caches da ST]---------
//       u5.editCache(c4,"44",CacheDiff.Hard,u6,10,11,"PerreParisLondres");
//       u5.printCache();
//
//        //---------[Remover Caches da ST]---------
//        u5.removeCache(c1);
//        u5.printCache();
//        c3.printObjetoFromCache();
//        c4.printObjetoFromCache();
//
//
//      //---------[Escrever e Ler Caches e Objetos do ficheiro]---------
//        writeCache_txt(".//data/cache.txt");
//        writeObjeto_txt(".//data/objeto.txt");
//        //falta ler da cache e do objeto
//        u5.printCache();
//





        MessageLog log1 = new MessageLog("Estive aqui -1");
        MessageLog log2 = new MessageLog("Estive aqui -2");
        MessageLog log3 = new MessageLog("Estive aqui -3");
        MessageLog log4 = new MessageLog("Estive aqui -4");

        u1.criarObjeto("ob1","BabyFace");
        u1.criarObjeto("ob2","faca");
        u1.criarObjeto("ob3","espada");

        u2.criarObjeto("ob4","Tiagovski");
        u3.criarObjeto("ob5","Miss");



        c3.criarObjeto("ob4","LEGENDBOY",u6);
        c4.criarObjeto("ob5","CHENTRIC",u6);


        u3.criarTravelBug("22","TravelBug1",c1);
        u5.criarTravelBug("33","TravelBug2",c2);
        u6.criarTravelBug("44","TravelBug3",c3);

        //u1.printObjetos();

        u1.visitarUmaCache_deixarObjeto(c1,log1,d1,"ob2");
        u1.visitarUmaCache(c1,log2,d2);

        u1.visitarUmaCache(c2,log2,d3);

        u3.visitarUmaCache(c1,log2,d3);
        u5.visitarUmaCache(c1,log2,d3);
        u5.visitarUmaCache_deixarTravelBug(c3,log1,d1,"TravelBug2");
        //u2.visitarUmaCache_TirarObjeto(c1,log2,d2,"ob2");

        System.out.println("\n------------------------------------------------------------------\n");




        u5.printALLTravelBug();


        u5.printObjetosAllUsers();

        u5.printObjetosAllCaches();

        u5.printUsers_historicoCaches();

        u5.printCaches_historicoUsers();


        System.out.println("\n------------------------------------------------------------------\n");

        u5.printALLTravelBug();


        u5.printUserLogs();

        u5.printCacheLogs();

        System.out.println("\n------------------------------------------------------------------\n");

        u5.print_r8a_global(u1);

        u5.print_r8a_regiao(u1,"AltoMinho");

        System.out.println("\n------------------------------------------------------------------\n");

        u5.printr8b(u1);

        u5.print_r8b_regiao(u1,"AltoMinho");

        u5.printr8c(c1);

        u5.printr8d();

        System.out.println("\n------------------------------------------------------------------\n");

        u5.printr8e(d1,d4);

        u5.printr8f();

        UserAdmin.saveUsers();

        UserAdmin.saveCaches();

        UserAdmin.saveObjetos();
    }

    public static void teste2(){ //ler users

        System.out.println(userST.size());
        System.out.println(cacheST.size());

        UserAdmin.readUsers();

        UserBasic u1= userST.get("40097");
        UserBasic u2= userST.get("39917");
        UserPremium u3= (UserPremium) userST.get("0000");
        UserPremium u4= (UserPremium) userST.get("5555");
        UserAdmin u5= (UserAdmin) userST.get("1001");
        UserAdmin u6= (UserAdmin) userST.get("7004");



        u5.printUser();



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

