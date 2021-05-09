package edu.ufp.inf.lp2.geocaching;

import java.io.IOException;

import static edu.ufp.inf.lp2.geocaching.UserAdmin.cacheST;
import static edu.ufp.inf.lp2.geocaching.UserAdmin.userST;

public class Main {


    /**
     * Método Main
     * @param args
     * @throws IOException
     */

    public static void main(String[] args) throws IOException {

        testeprojeto();         //TESTES PEDIDOS PELO PROF
        //testeprojeto2();
    }


    /**
     * Função teste dos inputs do prof
     * @throws IOException
     */

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

    /**
     * Função teste de ler dos inputs
     */
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

