package edu.ufp.inf.lp2.geocaching;

import Graph.Aresta_Projeto;
import Graph.DijkstraSP_Project;
import edu.princeton.cs.algs4.StdOut;

import java.io.IOException;

import static edu.ufp.inf.lp2.geocaching.UserAdmin.*;


public class Main {



    /**
     * Método Main
     * @param args
     * @throws IOException
     */

    public static void main(String[] args) throws IOException {

        testeprojeto();         //TESTES PEDIDOS PELO PROF
        //testeprojeto2();
        //testeBinarios();
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
        int index_1=grafoTS.st.get("geocache1");
        int index_2=grafoTS.st.get("geocache2");
        int index_3=grafoTS.st.get("geocache3");
        int index_4=grafoTS.st.get("geocache4");
        int index_5=grafoTS.st.get("geocache5");
        int index_6=grafoTS.st.get("geocache6");
        int index_7=grafoTS.st.get("geocache7");
        int index_8=grafoTS.st.get("geocache8");
        int index_9=grafoTS.st.get("geocache9");
        int index_10=grafoTS.st.get("geocache10");
        int index_11=grafoTS.st.get("geocache11");
        int index_12=grafoTS.st.get("geocache12");
        int index_13=grafoTS.st.get("geocache13");
        int index_14=grafoTS.st.get("geocache14");
        int index_15=grafoTS.st.get("geocache15");
        int index_16=grafoTS.st.get("geocache16");
        int index_17=grafoTS.st.get("geocache17");
        int index_18=grafoTS.st.get("geocache18");

        /*
        //ligacoes 1
        Aresta_Projeto e0 =new Aresta_Projeto(index_1,index_2,5.2,60f);
        Aresta_Projeto e1 =new Aresta_Projeto(index_1,index_3,8.2,102f);
        Aresta_Projeto e2 =new Aresta_Projeto(index_1,index_4,6.2,70f);
        Aresta_Projeto e3 =new Aresta_Projeto(index_1,index_5,4.2,40f);
        Aresta_Projeto e4 =new Aresta_Projeto(index_1,index_6,3.2,35f);
        Aresta_Projeto e5 =new Aresta_Projeto(index_1,index_7,5.2,66f);
        //ligacoes 2
        Aresta_Projeto e6 =new Aresta_Projeto(index_2,index_3,8.5,102f);
        Aresta_Projeto e7 =new Aresta_Projeto(index_2,index_4, 5.8,65f);
        Aresta_Projeto e8 =new Aresta_Projeto(index_2,index_5, 7.2,72f);
        Aresta_Projeto e9 =new Aresta_Projeto(index_2,index_6, 5.4,53f);
        Aresta_Projeto e10 =new Aresta_Projeto(index_2,index_7,4.5,51f);
        //ligacoes 3
        Aresta_Projeto e11 =new Aresta_Projeto(index_3,index_4,2.7,30f);
        Aresta_Projeto e12 =new Aresta_Projeto(index_3,index_5, 3.2,35f);
        Aresta_Projeto e13 =new Aresta_Projeto(index_3,index_6,4.1,43f);
        Aresta_Projeto e14 =new Aresta_Projeto(index_3,index_7,8.5,89f);
        //ligacoes 4
        Aresta_Projeto e15 =new Aresta_Projeto(index_4,index_5,3.7,41f);
        Aresta_Projeto e16 =new Aresta_Projeto(index_4,index_6,4.3,49f);
        Aresta_Projeto e17 =new Aresta_Projeto(index_4,index_7,7.4,72f);
        //ligacoes 5
        Aresta_Projeto e18 =new Aresta_Projeto(index_5,index_6,7.4,71f);
        Aresta_Projeto e19 =new Aresta_Projeto(index_5,index_7,5.2,53f);
        //ligacoes 6
        Aresta_Projeto e20 =new Aresta_Projeto(index_6,index_7,7.4,73f);
        //ligacoes 7
        Aresta_Projeto e21 =new Aresta_Projeto(index_7,index_8,130,1500f);
        //ligacoes 8
        Aresta_Projeto e22 =new Aresta_Projeto(index_8,index_9,7.2,72f);
        Aresta_Projeto e23 =new Aresta_Projeto(index_8,index_10,4.7,51f);
        Aresta_Projeto e24 =new Aresta_Projeto(index_8,index_11, 3.4,41f);
        Aresta_Projeto e25 =new Aresta_Projeto(index_8,index_12,5.3,55f);
        //ligacoes 9
        Aresta_Projeto e26=new Aresta_Projeto(index_9,index_10,2.2,24f);
        Aresta_Projeto e27 =new Aresta_Projeto(index_9,index_11,1.7,21f);
        Aresta_Projeto e28 =new Aresta_Projeto(index_9,index_12, 6.4,71f);
        //ligacoes 10
        Aresta_Projeto e29 =new Aresta_Projeto(index_10,index_11,4.7,52f);
        Aresta_Projeto e30 =new Aresta_Projeto(index_10,index_12,3.5,36f);
        Aresta_Projeto e31 =new Aresta_Projeto(index_10,index_13,6.2,67f);
        //ligacoes 11
        Aresta_Projeto e32 =new Aresta_Projeto(index_11,index_12,2.8,32f);
        //ligacoes 12
        Aresta_Projeto e33 =new Aresta_Projeto(index_12,index_13,197,2460f);
        //ligacoes 13
        Aresta_Projeto e34 =new Aresta_Projeto(index_13,index_14,2.6,31f);
        Aresta_Projeto e35 =new Aresta_Projeto(index_13,index_15,4.5,51f);
        Aresta_Projeto e36 =new Aresta_Projeto(index_13,index_16,3.8,45f);
        Aresta_Projeto e37 =new Aresta_Projeto(index_13,index_17,4.2,51f);
        Aresta_Projeto e38 =new Aresta_Projeto(index_13,index_18,2.8,32f);
        //ligacoes 14
        Aresta_Projeto e39 =new Aresta_Projeto(index_14,index_15,3.3,41f);
        Aresta_Projeto e40 =new Aresta_Projeto(index_14,index_16,4.8,58f);
        Aresta_Projeto e41 =new Aresta_Projeto(index_14,index_17,5.2,62f);
        Aresta_Projeto e42=new Aresta_Projeto(index_14,index_18,3.7,41f);
        //ligacoes 15
        Aresta_Projeto e43 =new Aresta_Projeto(index_15,index_16,4.4,53f);
        Aresta_Projeto e44 =new Aresta_Projeto(index_15,index_17, 5.3,64f);
        Aresta_Projeto e45 =new Aresta_Projeto(index_15,index_18,3.8,43f);
        //ligacoes 16
        Aresta_Projeto e46 =new Aresta_Projeto(index_16,index_17,1.2,22f);
        Aresta_Projeto e47 =new Aresta_Projeto(index_16,index_18, 2.1,35f);
        //ligacoes 17
        Aresta_Projeto e48 =new Aresta_Projeto(index_17,index_18,3.8,44f);
        Aresta_Projeto e49 =new Aresta_Projeto(index_17,index_15,330,45f);

        grafoTS.graph.addEdge(e0);grafoTS.graph.addEdge(e1);grafoTS.graph.addEdge(e2);grafoTS.graph.addEdge(e3);grafoTS.graph.addEdge(e4);grafoTS.graph.addEdge(e5);grafoTS.graph.addEdge(e6);
        grafoTS.graph.addEdge(e7);grafoTS.graph.addEdge(e8);grafoTS.graph.addEdge(e9);grafoTS.graph.addEdge(e10);grafoTS.graph.addEdge(e11);grafoTS.graph.addEdge(e12);grafoTS.graph.addEdge(e13);
        grafoTS.graph.addEdge(e14);grafoTS.graph.addEdge(e15);grafoTS.graph.addEdge(e16);grafoTS.graph.addEdge(e17);grafoTS.graph.addEdge(e18);grafoTS.graph.addEdge(e19);grafoTS.graph.addEdge(e20);
        grafoTS.graph.addEdge(e21);grafoTS.graph.addEdge(e22);grafoTS.graph.addEdge(e23);grafoTS.graph.addEdge(e24);grafoTS.graph.addEdge(e25);grafoTS.graph.addEdge(e26);grafoTS.graph.addEdge(e27);
        grafoTS.graph.addEdge(e28);grafoTS.graph.addEdge(e29);grafoTS.graph.addEdge(e30);grafoTS.graph.addEdge(e31);grafoTS.graph.addEdge(e32);grafoTS.graph.addEdge(e33);grafoTS.graph.addEdge(e34);
        grafoTS.graph.addEdge(e35);grafoTS.graph.addEdge(e36);grafoTS.graph.addEdge(e37);grafoTS.graph.addEdge(e38);grafoTS.graph.addEdge(e39);grafoTS.graph.addEdge(e40);grafoTS.graph.addEdge(e41);
        grafoTS.graph.addEdge(e42);grafoTS.graph.addEdge(e43);grafoTS.graph.addEdge(e44);grafoTS.graph.addEdge(e45);grafoTS.graph.addEdge(e46);grafoTS.graph.addEdge(e47);grafoTS.graph.addEdge(e48);
        grafoTS.graph.addEdge(e49);

        System.out.println(UserAdmin.grafoTS.graph.toString());
        UserAdmin.saveGraphEdges();

       // pedro.removerUser();
        //UserAdmin.removeCache(cache2);
        //UserAdmin.saveAll();

        */
        System.out.println("\t\t\t\t\t\t\t\tGRAFO GERAL DAS CACHES\t\t");
        System.out.println("\n---------------------------------------------------------------------------------\n");
        System.out.println("\nGraph Geral:\n");
        UserAdmin.readGraphEdges();
        System.out.println(UserAdmin.grafoTS.graph.toString());

        System.out.println("\n---------------------------------------------------------------------------------\n");
        System.out.println("\t\t\t\t\t\t\t\tGRAFO CACHES CENTRO\t\t");
        System.out.println("\n---------------------------------------------------------------------------------\n");
        System.out.println("\nGraph Centro:\n");
        UserAdmin.SubGraphZona("centro",false);
        System.out.println(subGrafo.graph.toString());

        System.out.println("\n---------------------------------------------------------------------------------\n");
        System.out.println("\t\t\t\t\t\t\t\tGRAFO CACHES DIFICULDADE EASY\t\t");
        System.out.println("\n---------------------------------------------------------------------------------\n");

        System.out.println("\nGraph Dif Easy:\n");
        UserAdmin.SubGraphDificuldade(CacheDiff.Easy,false);
        System.out.println(subGrafo.graph.toString());

        System.out.println("\n---------------------------------------------------------------------------------\n");
        System.out.println("\t\t\t\t\t\t\t\tGRAFO CACHES NUMERO VISITAS\t\t");
        System.out.println("\n---------------------------------------------------------------------------------\n");

        System.out.println("\nGraph Visitas menor 2:\n");
        UserAdmin.SubGraphNrVisitasmenor(2,false);
        System.out.println(subGrafo.graph.toString());

        System.out.println("\nGraph Visitas maior 2:\n");
        UserAdmin.SubGraphNrVisitasmaior(2,false);
        System.out.println(subGrafo.graph.toString());

        System.out.println("\nGraph Visitas entre 2 e 10:\n");
        UserAdmin.SubGraphNrVisitasMenorMaior(2,10,false);
        System.out.println(subGrafo.graph.toString());





        System.out.println("------------ GRAPH Geral----------------");
       DijkstraSP_Project sp = new DijkstraSP_Project(grafoTS.graph, 0);
        int s=0;

        // print shortest path
        for (int t = 0; t < grafoTS.graph.V(); t++) {

            if (sp.hasPathTo(t)) {
                StdOut.printf("%d to %d (%.2f)  ", s, t, sp.distTo(t));
                for (Aresta_Projeto e : sp.pathTo(t)) {
                    StdOut.print(e + "   ");
                }
                StdOut.println();
            }
            else {
                StdOut.printf("%d to %d         no path\n", s, t);
            }
        }


        System.out.println("\n-------------- SUBGRAPH NORTE ------\n");

        UserAdmin.SubGraphZona("norte",true);
        DijkstraSP_Project spnorte = new DijkstraSP_Project(subGrafo.graph, 0);
        int snorte=0;

        // print shortest path
        for (int t = 0; t < subGrafo.graph.V(); t++) {

            if (spnorte.hasPathTo(t)) {
                StdOut.printf("%d to %d (%.2f)  ", snorte, t, spnorte.distTo(t));
                for (Aresta_Projeto e : spnorte.pathTo(t)) {
                    StdOut.print(e + "   ");
                }
                StdOut.println();
            }
            else {
                StdOut.printf("%d to %d         no path\n", snorte, t);
            }
        }

        System.out.println("\n-------------- SUBGRAPH HARD ------\n");

        UserAdmin.SubGraphDificuldade(CacheDiff.Hard,true);
        DijkstraSP_Project sphard = new DijkstraSP_Project(subGrafo.graph, 0);
        int shard=0;

        // print shortest path
        for (int t = 0; t < subGrafo.graph.V(); t++) {

            if (sphard.hasPathTo(t)) {
                StdOut.printf("%d to %d (%.2f)  ", shard, t, sphard.distTo(t));
                for (Aresta_Projeto e : sphard.pathTo(t)) {
                    StdOut.print(e + "   ");
                }
                StdOut.println();
            }
            else {
                StdOut.printf("%d to %d         no path\n", shard, t);
            }
        }






        UserAdmin.saveUsersBin();
        UserAdmin.saveCachesBin();
        UserAdmin.saveGraphBin();





    }
    /*
    0 to 0 (0.00)
0 to 1 (5.20)  0->1  5,20 - 60,00 |
0 to 2 (8.20)  0->2  8,20 - 102,00 |
0 to 3 (6.20)  0->3  6,20 - 70,00 |
0 to 4 (4.20)  0->4  4,20 - 40,00 |
0 to 5 (3.20)  0->5  3,20 - 35,00 |
0 to 6 (5.20)  0->6  5,20 - 66,00 |
0 to 7 (135.20)  0->6  5,20 - 66,00 |    6->7 130,00 - 1500,00 |
0 to 8 (142.40)  0->6  5,20 - 66,00 |    6->7 130,00 - 1500,00 |    7->8  7,20 - 72,00 |
0 to 9 (139.90)  0->6  5,20 - 66,00 |    6->7 130,00 - 1500,00 |    7->9  4,70 - 51,00 |
0 to 10 (138.60)  0->6  5,20 - 66,00 |    6->7 130,00 - 1500,00 |    7->10  3,40 - 41,00 |
0 to 11 (140.50)  0->6  5,20 - 66,00 |    6->7 130,00 - 1500,00 |    7->11  5,30 - 55,00 |
0 to 12 (146.10)  0->6  5,20 - 66,00 |    6->7 130,00 - 1500,00 |    7->9  4,70 - 51,00 |    9->12  6,20 - 67,00 |
0 to 13 (148.70)  0->6  5,20 - 66,00 |    6->7 130,00 - 1500,00 |    7->9  4,70 - 51,00 |    9->12  6,20 - 67,00 |    12->13  2,60 - 31,00 |
0 to 14 (150.60)  0->6  5,20 - 66,00 |    6->7 130,00 - 1500,00 |    7->9  4,70 - 51,00 |    9->12  6,20 - 67,00 |    12->14  4,50 - 51,00 |
0 to 15 (149.90)  0->6  5,20 - 66,00 |    6->7 130,00 - 1500,00 |    7->9  4,70 - 51,00 |    9->12  6,20 - 67,00 |    12->15  3,80 - 45,00 |
0 to 16 (150.30)  0->6  5,20 - 66,00 |    6->7 130,00 - 1500,00 |    7->9  4,70 - 51,00 |    9->12  6,20 - 67,00 |    12->16  4,20 - 51,00 |
0 to 17 (148.90)  0->6  5,20 - 66,00 |    6->7 130,00 - 1500,00 |    7->9  4,70 - 51,00 |    9->12  6,20 - 67,00 |    12->17  2,80 - 32,00 |

     */

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


    public static  void testeBinarios(){
        UserAdmin.readUsersBin();
        UserAdmin.readCachesBin();
        UserAdmin.readGraphBin();

        UserAdmin.printUser();
        UserAdmin.printCaches();
        System.out.println(grafoTS.graph.toString());

       UserAdmin.r18(21.4);

    }

}

