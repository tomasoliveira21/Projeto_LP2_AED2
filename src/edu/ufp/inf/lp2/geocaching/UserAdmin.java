package edu.ufp.inf.lp2.geocaching;

import Graph.Aresta_Projeto;
import Graph.Grafo_Projeto;
import Graph.Grafos_Tabela_Simbolos;
import Graph.Prim_AED2;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;
import edu.ufp.inf.lp2.geocaching.AED2Class.ST_AED2;

import java.io.*;
import java.util.ArrayList;


public class UserAdmin extends UserPremium  {

    public static ST_AED2<String, UserBasic> userST = new ST_AED2<>();

    public static ST_AED2<String, Cache> cacheST = new ST_AED2<>();

    public static Grafos_Tabela_Simbolos grafoTS = new Grafos_Tabela_Simbolos();

    public static Grafos_Tabela_Simbolos subGrafo = new Grafos_Tabela_Simbolos();

    /**
     * Construtor UserAdmin
     *
     * @param name
     * @param id
     */

    public UserAdmin(String name, String id) {
        super(name, id);
    }

    /**
     * O Método Now apresenta o estado de todos os travel bugs naquele instante
     */
    public void now() {
        System.out.println("\nFunção now: Localizacao dos TravelBugs do user " + this.name);
        for (String key : meusTravelBugs.keys()) {
            TravelBugs travelBugs = meusTravelBugs.get(key);
            System.out.println("\tTravel bug -> " + travelBugs.nameItem + " ja esteve nas seguintes localizacoes:");
            int size = travelBugs.historicoTravelBugsLogs.size() - 1; //o size fica com o indice da ultima posição do historico travel bugs logs
            if (travelBugs.historicoTravelBugsLogs.size() > 0) {
                while (size >= 0) {
                    if (size == travelBugs.historicoTravelBugsLogs.size() - 1) { //se for a ultima localizacao, so entra 1x
                        TravelBugsLogs tblog = travelBugs.historicoTravelBugsLogs.get(size);
                        if (tblog.p == null) { //se o tb nao esta no bolso, está na cache
                            System.out.println("\t\tEncontra se neste moemnto na cache " + tblog.c.serialNumber + " e foi la deixada pelo user "
                                    + userST.get(tblog.user).name + " no dia " + tblog.date.print());
                        } else { //se não esta na cache, está no bolso
                            System.out.println("\t\tEncontra se neste moemnto com o o user  " + userST.get(tblog.user).name + " e retirado da cache "
                                    + tblog.cache + " no dia " + tblog.date.print());
                        }

                    } else { //se nao estiver na ultima posicao
                            TravelBugsLogs tblog = travelBugs.historicoTravelBugsLogs.get(size);
                            if (tblog.p == null) {
                                System.out.println("\t\tEsteve na cache " + tblog.c.serialNumber + " e foi la deixada pelo user "
                                        + userST.get(tblog.user).name + " no dia " + tblog.date.print());
                            } else {
                                System.out.println("\t\tEsteve com o user  " + userST.get(tblog.user).name + " e retirado da cache "
                                        + tblog.cache + " no dia " + tblog.date.print());
                            }
                        }
                    size--;
                }
            }
        }
    }

    /**
     * Método que edita o Utilizador
     *
     * @param user
     * @param name
     */
    public void editUser(UserBasic user, String name) {
        user.name = name;
        userST.put(user.id, user);
    }

    /**
     * Método que printa todos os TravelBugs
     */
    public void printALLTravelBug() {
        System.out.println("Lista todos Travel Bugs\n");
        for (String name : userST.keys()) {
            UserBasic userBasic = userST.get(name);
            if (!userBasic.getClass().equals(UserBasic.class)) {
                UserPremium userPremium = (UserPremium) userBasic;
                if (userPremium.meusTravelBugs.size() > 0) {
                    System.out.println("Utilizador " + userPremium.name + " tem os TravelBugs :");
                    for (String id : userPremium.meusTravelBugs.keys()) {
                        TravelBugs travelBugs = userPremium.meusTravelBugs.get(id);
                        System.out.println(travelBugs.toString());
                    }
                    System.out.println("\n");
                } else {
                    System.out.println("Utilizador " + userPremium.name + " nao tem TravelBugs\n");
                }

            }
        }


    }

    /**
     * Método que lista todos os TravelBugs e o seu Historico de Caches
     */
    public void printALLTravelBugHCaches() {
        System.out.println("Lista todos Travel Bugs e o seu Historico de Caches\n");
        for (String name : userST.keys()) {
            UserBasic userBasic = userST.get(name);
            if (!userBasic.getClass().equals(UserBasic.class)) {
                UserPremium userPremium = (UserPremium) userBasic;
                if (userPremium.meusTravelBugs.size() > 0) {
                    System.out.println("Utilizador " + userPremium.name + " tem os TravelBugs :");
                    for (String id : userPremium.meusTravelBugs.keys()) {
                        TravelBugs travelBugs = userPremium.meusTravelBugs.get(id);
                        System.out.println("\t" + travelBugs.toString());
                        for (String key : travelBugs.historicoCaches.keys()) {
                            Cache cache = cacheST.get(key);
                            System.out.println("\t\t Este travelbug ja esteve na cache -> " + cache.serialNumber);

                        }
                    }
                    System.out.println("\n");
                } else {
                    System.out.println("Utilizador " + userPremium.name + " nao tem TravelBugs\n");
                }

            }
        }


    }

    /**
     * Método que lista todos os TravelBugs e o seu historico de Users
     */
    public void printALLTravelBugHUsers() {
        System.out.println("Lista todos Travel Bugs e o seu Historico de Users\n");
        for (String name : userST.keys()) {
            UserBasic userBasic = userST.get(name);
            if (!userBasic.getClass().equals(UserBasic.class)) {
                UserPremium userPremium = (UserPremium) userBasic;
                if (userPremium.meusTravelBugs.size() > 0) {
                    System.out.println("Utilizador " + userPremium.name + " tem os TravelBugs :");
                    for (String id : userPremium.meusTravelBugs.keys()) {
                        TravelBugs travelBugs = userPremium.meusTravelBugs.get(id);
                        System.out.println("\t" + travelBugs.toString());
                        for (String key : travelBugs.historicoUsers.keys()) {
                            UserPremium puser = (UserPremium) userST.get(key);
                            System.out.println("\t\t Este travelbug ja esteve com o user -> " + puser.name);

                        }
                    }
                    System.out.println("\n");
                } else {
                    System.out.println("Utilizador " + userPremium.name + " nao tem TravelBugs\n");
                }

            }
        }


    }

    /**
     * Método que insere uma Cache na Symbol Table
     *
     * @param cache
     */
    public void insertCache(Cache cache) {
        cacheST.put(cache.serialNumber, cache);
        int size = cacheST.size() - 1;
        grafoTS.graph = new Grafo_Projeto(cacheST.size());
        grafoTS.st.put(cache.serialNumber, size);
    }

    /**
     * Método que remove uma Cache da Symbol Table
     *
     * @param cache
     * @throws IOException
     */
    public static void removeCache(Cache cache) throws IOException {
        UserAdmin.ficheiroRemoverCache(cache);
        cacheST.remove(cache.serialNumber);
        int index_cache_rem = grafoTS.st.get(cache.serialNumber);
        for (String nome : grafoTS.st.keys()) {
            int index_cache_atual = grafoTS.st.get(nome);
            if (!nome.equals(cache.serialNumber) && index_cache_atual > index_cache_rem) {
                grafoTS.st.put(nome, index_cache_atual - 1);
            }
        }
        grafoTS.st.remove(cache.serialNumber);
    }

    /**
     * Método que lista as caches
     */
    public static void printCaches() {
        System.out.println("Lista Caches: ");
        for (String cacheName : cacheST.keys()) {
            System.out.println("\t" + cacheST.get(cacheName));
        }
        System.out.println("\n");
    }

    /**
     * Método que lista os utilizadores
     */
    public static void printUser() {

        System.out.println("Lista Utilizadores: ");
        for (String name : userST.keys()) {
            System.out.println("\t"+userST.get(name).toString());
        }
        System.out.println("\n");
    }

    /**
     * Requisito 8A
     * Devem implementar-se diversas pesquisas sobre a base de informação como, por
     * exemplo, determinar:
     * a) Todas as caches visitadas por um utilizador. Global
     *
     * @param userBasic
     */
    public void print_r8a_global(UserBasic userBasic) {
        System.out.println();
        userBasic.printhCaches();
    }

    /**
     * Requisito 8A
     * Devem implementar-se diversas pesquisas sobre a base de informação como, por
     * exemplo, determinar:
     * a) Todas as caches visitadas por um utilizador. Região;
     *
     * @param userBasic
     * @param regiao
     */
    public void print_r8a_regiao(UserBasic userBasic, String regiao) {
        if (userBasic.hCaches.size() > 0) {
            System.out.println("\nUtilizador " + userBasic.name + " visitou as seguintes caches em " + regiao + "\n");
            for (Date d : userBasic.hCaches.keys()) {
                Cache c = userBasic.hCaches.get(d);
                if (c.regiao.equals(regiao)) System.out.println(c.toString() + " no dia " + d.print());
            }
            return;
        }
        System.out.println("\nUtilizador " + userBasic.name + " ainda nao visitou nenhuma cache em " + regiao + "\n");
    }

    /**
     * Requisito 8B
     * Devem implementar-se diversas pesquisas sobre a base de informação como, por
     * exemplo, determinar:
     * b) Todas as caches não visitadas por um utilizador. Global
     *
     * @param userBasic
     */
    public static void printr8b(UserBasic userBasic) {
        System.out.println("O user " + userBasic.name + " nao visitou as seguintes caches:");
        Cache visitada = new Cache();
        for (String key : cacheST.keys()) {
            visitada = cacheST.get(key);
            boolean visitado = false;
            for (Date date : userBasic.hCaches.keys()) {
                Cache cache = userBasic.hCaches.get(date);

                if (cache.serialNumber.equals(visitada.serialNumber)) {
                    visitado = true;
                    break;
                }
            }
            if (!visitado) System.out.println("-> " + visitada.serialNumber + "\n");
        }
        System.out.println();

    }

    /**
     * Requisito 8B
     * Devem implementar-se diversas pesquisas sobre a base de informação como, por
     * exemplo, determinar:
     * b) Todas as caches não visitadas por um utilizador. região;
     *
     * @param userBasic
     * @param regiao
     */
    public static void print_r8b_regiao(UserBasic userBasic, String regiao) {
        System.out.println("O user " + userBasic.name + " nao visitou as seguintes caches na regiao " + regiao);
        Cache cache = new Cache();
        for (String key : cacheST.keys()) {
            cache = cacheST.get(key);
            boolean visitado = false;
            for (Date date : userBasic.hCaches.keys()) {
                Cache visitada = userBasic.hCaches.get(date);

                if (cache.serialNumber.equals(visitada.serialNumber)) {
                    visitado = true;
                    break;
                }
            }
            if (!visitado && cache.regiao.equals(regiao)) System.out.println("-> " + cache.serialNumber + "\n");
        }
        System.out.println();

    }

    /**
     * Requisito 8C
     * Devem implementar-se diversas pesquisas sobre a base de informação como, por
     * exemplo, determinar:
     * c) Todos os utilizadores que já visitaram uma dada cache;
     *
     * @param cache
     */
    public void printr8c(Cache cache) {
        System.out.println(cache.serialNumber + " -> Utilizadores que visitaram esta cache:");
        for (Date date : cache.hUsers.keys()) {
            UserBasic userBasic = cache.hUsers.get(date);
            System.out.println("\t" + userBasic.name + " visitou esta cache no dia no dia " + date.print() + ".");
        }
        System.out.println();
    }

    /**
     * Requisito 8D
     * Devem implementar-se diversas pesquisas sobre a base de informação como, por
     * exemplo, determinar:
     * d) Todas as caches premium que têm pelo menos um objecto;
     */
    public static void printr8d() {//Todas as caches premium que têm pelo menos um objecto;
        System.out.println("Caches premium que tem objetos:");
        for (String key : cacheST) {
            Cache cache = cacheST.get(key);
            if (cache.type.equals(CacheType.Premium) && cache.meusObjetos.size() > 0) {
                System.out.println("\t" + cache.serialNumber);
            }

        }
    }

    /**
     * Requisito 8E
     * Devem implementar-se diversas pesquisas sobre a base de informação como, por
     * exemplo, determinar:
     * e) Top-5 de utilizadores que visitaram maior nº de caches num dado período
     * temporal;
     *
     * @param dinicial
     * @param dfinal
     */
    public static void printr8e(Date dinicial, Date dfinal) {//Top-5 de utilizadores que visitaram maior nº de caches num dado períodotemporal;
        ST<String, Integer> totalvisitas = new ST<>();
        for (String key : cacheST) {
            Cache cache = cacheST.get(key);
            for (CacheLogs clogs : cache.cacheLogs) {
                //se visitou entre as datas
                if (clogs.data.afterDate(dinicial) && clogs.data.beforeDate(dfinal) || clogs.data.equals(dinicial) || clogs.data.equals(dfinal)) {
                    String userid = clogs.userID;
                    if (totalvisitas.contains(userid)) {//se o user ja estiver na st
                        totalvisitas.put(userid, totalvisitas.get(userid) + 1);//incremento 1 visita
                    } else totalvisitas.put(userid, 1);//se nao visitas = 1
                }
            }
        }

        int top5 = 0, topvisiter = 0;
        String user = "";
        while (top5 < 5 && totalvisitas.size() > 0) {//caso nao haja mais que 5
            for (String id : totalvisitas.keys()) {

                if (top5 == 0 && totalvisitas.get(id) >= topvisiter) {
                    topvisiter = totalvisitas.get(id);
                    user = id;
                }
                else if (top5 > 0 && totalvisitas.get(id) > topvisiter ) {
                    topvisiter = totalvisitas.get(id);
                    user = id;
                }

            }
            if (top5 == 0) System.out.println("Top 5 utilizadores mais ativos:");
            System.out.println("Top " + (top5 + 1) + "-> " + userST.get(user).name + " com um total de visitas de: " + topvisiter);

            topvisiter = 0;
            top5++;
            totalvisitas.delete(user);
        }


    }

    /**
     * Requisito 8F
     * Devem implementar-se diversas pesquisas sobre a base de informação como, por
     * exemplo, determinar:
     * f) travel bugs com maior número de localizações percorridas no seu histórico
     */
    public static void printr8f() {
        ArrayList<TravelBugs> travelBugs = new ArrayList<>();
        for (String id : userST) {
            if (userST.get(id).getClass().equals(UserPremium.class) || userST.get(id).getClass().equals(UserAdmin.class)) {
                UserPremium userPremium = (UserPremium) userST.get(id);
                for (String key : userPremium.meusTravelBugs.keys()) {
                    if (userPremium.meusTravelBugs.get(key).historicoCaches.size() > 0)
                        travelBugs.add(userPremium.meusTravelBugs.get(key));

                }
            }
        }
        if (travelBugs.size() == 0) {
            System.out.println("\nNao existem TravelBugs que tenham historico de cache.");
            return;
        }
        System.out.println("\nTop TravelBugs mais ativos:");

        int max = 0, top = 0;
        while (travelBugs.size() > 0) {
            TravelBugs auxiliar = new TravelBugs();
            for (TravelBugs travelBugs1 : travelBugs) {
                if (travelBugs1.historicoCaches.size() > max) {
                    auxiliar = travelBugs1;
                    max = travelBugs1.historicoCaches.size();
                }
            }
            System.out.println("\tTop" + (top + 1) + ": Travel Bug " + auxiliar.nameItem + " ja percorreu um total de locais de " + auxiliar.historicoCaches.size() + ".\n");
            max = 0;
            travelBugs.remove(auxiliar);
            top++;
        }

    }

    /**
     * Método que lista todos os objetos das caches
     */
    public static void printObjetosAllCaches() {
        System.out.println("Lista todos Objetos das Caches\n");
        for (String key : cacheST.keys()) {
            Cache c = cacheST.get(key);
            if (c.meusObjetos.size() > 0) {
                System.out.println("Objetos da cache " + c.serialNumber + ":");
                for (String obj : c.meusObjetos.keys()) {
                    System.out.println("\t" + c.meusObjetos.get(obj).toString() + "\n");
                }
            }

        }
        System.out.println("\n");
    }

    /**
     * Método que lista todos os objetos dos Users
     */
    public void printObjetosAllUsers() {
        System.out.println("Lista todos Objetos dos Users\n");
        for (String key : userST.keys()) {
            UserBasic user = userST.get(key);
            if (user.myObjetos.size() > 0) {
                System.out.println("Objetos do User " + user.name + ":");
                for (String obj : user.myObjetos.keys()) {
                    System.out.println("\t" + user.myObjetos.get(obj).toString());
                }
            }
            System.out.println("\n");
        }
    }

    /**
     * Método para printar o Historico de caches do user
     */
    public void printUsers_historicoCaches() {
        System.out.println("Historico de Caches do Utilizadores:\n");
        for (String key : userST.keys()) {
            UserBasic userBasic = userST.get(key);
            if (userBasic.hCaches.size() > 0) {
                System.out.println("\tUtilizador " + userBasic.name + " visitou as seguintes caches:\n");
                for (Date d : userBasic.hCaches.keys()) {
                    Cache cache = userBasic.hCaches.get(d);
                    System.out.println("\t\tCache: " + cache.serialNumber + " , no dia -> " + d.print() + "\n");
                }
            } else System.out.println("\tUtilizador " + userBasic.name + " nao visitou caches.\n");
        }

    }

    /**
     * Método para printar o Historico de users das caches
     */
    public void printCaches_historicoUsers() {
        System.out.println("Historico de Utilizadores das Caches:\n");
        for (String key : cacheST.keys()) {
            Cache c = cacheST.get(key);
            if (c.hUsers.size() > 0) {
                System.out.println("\tCache " + c.serialNumber + " recebeu as visitas dos seguintes utilizadores:\n");
                for (Date d : c.hUsers.keys()) {
                    UserBasic user = c.hUsers.get(d);
                    System.out.println("\t\tUser: " + user.name + " , no dia -> " + d.print() + "\n");
                }
            } else System.out.println("\tCache " + c.serialNumber + " nao recebeu as visitas.\n");

        }
    }

    /**
     * Método para printar o Historico de Users da cache
     *
     * @param cache
     */
    public static void printCaches_historicoUsers(String cache) {

        Cache c = cacheST.get(cache);
        if (c.hUsers.size() > 0) {
            System.out.println("Historico de Utilizadores da Cache " + c.serialNumber + ":\n");
            System.out.println("\tCache " + c.serialNumber + " recebeu as visitas dos seguintes utilizadores:\n");
            for (Date d : c.hUsers.keys()) {
                UserBasic user = c.hUsers.get(d);
                System.out.println("\t\tUser: " + user.name + " , no dia -> " + d.print() + "\n");
            }
        } else System.out.println("\tCache " + c.serialNumber + " nao recebeu as visitas.\n");


    }

    /**
     * Método para printar o Logs das Caches
     */
    public void printCacheLogs() {
        System.out.println("\n\nLogs das Caches:\n");
        for (String serial : cacheST.keys()) {
            Cache cache = cacheST.get(serial);
            if (cache.cacheLogs.size() > 0) {
                System.out.println("\tCache ->" + cache.serialNumber + " Logs:");
                for (CacheLogs clogs : cache.cacheLogs) {
                    System.out.println("\t\t->" + clogs.toString());
                }
            }

        }
    }

    /**
     * Método para printar os Logs de uma determinada Cache
     *
     * @param c
     */
    public static void printCacheLogs(String c) {
        Cache cache = cacheST.get(c);
        if (cache.cacheLogs.size() > 0) {
            System.out.println("\tCache ->" + cache.serialNumber + " Logs:");
            for (CacheLogs clogs : cache.cacheLogs) {
                System.out.println("\t\t->" + clogs.toString());
            }
        }

    }

    /**
     * Método para printar as Logs dos Users
     */
    public static void printUserLogs() {
        System.out.println("\n\nLogs dos Users:\n");
        for (String id : userST.keys()) {
            UserBasic userBasic = userST.get(id);
            if (userBasic.userLogs.size() > 0) {
                System.out.println("\tUser -> " + userBasic.name + " Logs:");
                for (Date date : userBasic.userLogs.keys()) {
                    UserLogs userLogs = userBasic.userLogs.get(date);
                    System.out.println("\t\t->" + userLogs.toString());
                }
            }

        }
    }

    /**
     * Método que printa as logs de um determinado User
     *
     * @param u
     */
    public static void printUserLogs(String u) {

        UserBasic userBasic = userST.get(u);
        if (userBasic.userLogs.size() > 0) {
            System.out.println("\tUser -> " + userBasic.name + " Logs:");
            for (Date date : userBasic.userLogs.keys()) {
                UserLogs userLogs = userBasic.userLogs.get(date);
                System.out.println("\t\t->" + userLogs.toString());
            }
        }
    }

    /**
     * Método que printa as Message Logs
     */
    public void printMessageLogs() {
        System.out.println("\nMessage Logs de todas as caches:\n");
        for (String key : cacheST.keys()) {
            Cache cache = cacheST.get(key);
            if (cache.messageLogs.size() > 0) System.out.println("Cache " + cache.serialNumber + ":\n");
            for (MessageLog messageLog : cache.messageLogs) {
                System.out.println("\t-> " + messageLog.mensagem + ".\n");
            }
        }
    }

    /**
     * Método que encontra um TravelBug
     *
     * @param idTB
     * @return
     */
    private static TravelBugs findTravelBug(String idTB) {
        for (String name : userST.keys()) {
            UserBasic userBasic = userST.get(name);
            if (!userBasic.getClass().equals(UserBasic.class)) {
                UserPremium userPremium = (UserPremium) userBasic;
                if (userPremium.meusTravelBugs.size() > 0) {
                    for (String id : userPremium.meusTravelBugs.keys()) {
                        TravelBugs travelBugs = userPremium.meusTravelBugs.get(id);
                        if (travelBugs.id.equals(idTB)) return travelBugs;

                    }
                }
            }
        }
        return null;
    }

    /**
     * Método que edita uma Cache
     *
     * @param cache
     * @param serialNumber
     * @param type
     * @param usercreator
     * @param x
     * @param y
     * @param regiao
     */
    public void editCache(Cache cache, String serialNumber, CacheDiff type, UserPremium usercreator, int x, int y, String regiao) {
        cache.serialNumber = serialNumber;
        cache.diff = type;
        cache.userCreator = usercreator;
        cache.x = x;
        cache.y = y;
        cache.regiao = regiao;
    }

    /**
     * Método que printa todos os TravelBugs Logs
     */
    public static void printAllTravelBugsLogs() {
        System.out.println("\nLogs dos Travel Bugs:");
        for (String id : userST.keys()) {
            UserBasic userBasic = userST.get(id);
            if (!userBasic.getClass().equals(UserBasic.class)) {
                UserPremium userPremium = (UserPremium) userBasic;
                if (userPremium.meusTravelBugs.size() > 0) {
                    System.out.println("User " + userPremium.name + " tem os seguintos travelBugs:");
                    for (String id2 : userPremium.meusTravelBugs.keys()) {
                        TravelBugs travelBugs = userPremium.meusTravelBugs.get(id2);
                        System.out.println("\t-> " + travelBugs.nameItem);
                        for (TravelBugsLogs travelBugsLogs : travelBugs.historicoTravelBugsLogs) {
                            if (travelBugsLogs.p == null) {
                                System.out.println("\t\t O user " + travelBugsLogs.user + " colocou me na cache " + travelBugsLogs.cache + " no dia " +
                                        travelBugsLogs.date.print() + " Cache destino: " + travelBugsLogs.destinoConcluido);
                            } else if (travelBugsLogs.c == null) {
                                System.out.println("\t\t O user " + travelBugsLogs.user + " retirou me da cache " + travelBugsLogs.cache + " no dia " +
                                        travelBugsLogs.date.print() + " Cache destino: " + travelBugsLogs.destinoConcluido);
                            }
                        }
                    }
                }
            }
        }

    }

    /**
     * Método que printa todos os TravelBugs de um determinado User
     *
     * @param puser
     * @param tb
     */
    public void printAllTravelBugsLogs(UserPremium puser, String tb) {

        TravelBugs travelBugs = puser.meusTravelBugs.get(tb);
        System.out.println("\t-> " + travelBugs.nameItem);
        for (TravelBugsLogs travelBugsLogs : travelBugs.historicoTravelBugsLogs) {
            if (travelBugsLogs.p == null) {
                System.out.println("\t\t O user " + travelBugsLogs.user + " colocou me na cache " + travelBugsLogs.cache + " no dia " +
                        travelBugsLogs.date.print() + " Cache destino: " + travelBugsLogs.destinoConcluido);
            } else if (travelBugsLogs.c == null) {
                System.out.println("\t\t O user " + travelBugsLogs.user + " retirou me na cache " + travelBugsLogs.cache + " no dia " +
                        travelBugsLogs.date.print() + " Cache destino: " + travelBugsLogs.destinoConcluido);
            }
        }


    }


    ///////////////////////////////////////////                   FICHEIROS                 //////////////////////////////////////////

    /**
     * Método que dá save aos Users num ficheiro de texto
     */
    public static void saveUsers() {
        Out out = new Out(".//data//user.txt");
        for (String id : userST) {
            UserBasic user = userST.get(id);
            if (user.getClass().equals(UserBasic.class))
                out.print(user.name + "," + user.id + "," + user.cachesVisitadas + "," + "BASIC\n");
            else if (user.getClass().equals(UserPremium.class))
                out.print(user.name + "," + user.id + "," + user.cachesVisitadas + "," + "PREMIUM\n");
            else out.print(user.name + "," + user.id + "," + user.cachesVisitadas + "," + "ADMIN\n");
        }
        out.close();

    }

    /**
     * Método que lê os Users do ficheiro de texto
     */
    public static void readUsers() {
        In in = new In(".//data//user.txt");

        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] words = line.split(",");
            switch (words[3]) {
                case "BASIC":
                    UserBasic user = new UserBasic(words[0], words[1]);
                    user.cachesVisitadas = Double.parseDouble(words[2]);
                    user.insertUser();
                    break;
                case "PREMIUM":
                    UserPremium puser = new UserPremium(words[0], words[1]);
                    puser.cachesVisitadas = Double.parseDouble(words[2]);
                    puser.insertUser();
                    break;
                case "ADMIN":
                    UserAdmin auser = new UserAdmin(words[0], words[1]);
                    auser.cachesVisitadas = Double.parseDouble(words[2]);
                    auser.insertUser();
                    break;
            }

        }
        in.close();

    }


    /**
     * Método que dá save às caches num ficheiro de texto
     */
    public static void saveCaches() {
        Out out = new Out(".//data//cache.txt");
        for (String serialNumber : cacheST) {
            Cache cache = cacheST.get(serialNumber);
            out.print(cache.userCreator.id + "," + cache.type + "," + cache.diff + "," + cache.serialNumber + "," + cache.x + "," + cache.y + "," + cache.regiao + "\n");
        }
        out.close();
    }

    /**
     * Método que lê as caches de um ficheiro de texto
     */
    public static void readCaches() {
        In in = new In(".//data//cache.txt");
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] words = line.split(",");
            CacheDiff cdif = CacheDiff.Easy;
            CacheType ctype = CacheType.Basic;
            if (words[1].equals("Premium")) ctype = CacheType.Premium;
            if (words[2].equals("Medium")) cdif = CacheDiff.Medium;
            else if (words[2].equals("Hard")) cdif = CacheDiff.Hard;

            UserPremium creator = (UserPremium) userST.get(words[0]);
            if (creator != null) {
                double x = Double.parseDouble(words[4]);
                double y = Double.parseDouble(words[5]);
                Cache cache = new Cache(words[3], cdif, ctype, creator, x, y, words[6]);

                cacheST.put(cache.serialNumber, cache);
                int size_cache = cacheST.size() - 1;
                grafoTS.st.put(cache.serialNumber, size_cache);
            }


        }
        in.close();
        //grafoTS.graph=new Grafo_Projeto(cacheST.size());
    }

    /**
     * Método que guarda os objetos e travel bugs das caches num ficheiro de texto
     */
    public static void saveObjetosCache() {
        Out out = new Out(".//data//objetosCaches.txt");
        for (String key : cacheST.keys()) {
            Cache c = cacheST.get(key);
            if (c.meusObjetos.size() > 0) {
                for (String key2 : c.meusObjetos.keys()) {
                    Objeto obj = c.meusObjetos.get(key2);
                    if (obj.getClass().equals(Objeto.class)) {
                        out.print("objeto" + "," + obj.nameItem + "," + obj.id + "," + obj.criadorObjeto.id + "," + obj.cacheAtual.serialNumber + "\n");
                    } else {
                        TravelBugs tb = (TravelBugs) c.meusObjetos.get(key2);
                        out.print("travelbug" + "," + tb.nameItem + "," + tb.id + "," + tb.criadorObjeto.id + "," + tb.cacheAtual.serialNumber + "," + tb.cacheDestino.serialNumber + "\n");

                    }

                }
            }
        }
        out.close();
    }

    /**
     * Método que lê os objetos e travel bugs das caches de um ficheiro de texto
     */
    public static void readObjetosCache() {
        In in = new In(".//data//objetosCaches.txt");
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] words = line.split(",");
            if (words[0].equals("objeto")) {
                UserBasic userCeator = userST.get(words[3]);
                Cache cacheAtual = cacheST.get(words[4]);
                Objeto objeto = new Objeto(words[2], words[1], userCeator);
                objeto.cacheAtual = cacheAtual;
                objeto.userAtual = null;
                cacheAtual.meusObjetos.put(objeto.id, objeto);

            } else {
                UserPremium userCeator = (UserPremium) userST.get(words[3]);
                Cache cacheAtual = cacheST.get(words[4]);
                Cache cacheDestino = cacheST.get(words[5]);
                if (cacheAtual != null && cacheDestino != null && userCeator != null) {
                    TravelBugs travelBugs = new TravelBugs(words[2], words[1], userCeator, cacheDestino);
                    travelBugs.cacheAtual = cacheAtual;
                    travelBugs.userAtual = null;
                    cacheAtual.meusObjetos.put(travelBugs.id, travelBugs);
                    userCeator.meusTravelBugs.put(travelBugs.id, travelBugs);

                }
            }

        }
        in.close();
    }

    /**
     * Método que guarda os objetos e travel bugs dos Users num ficheiro de texto
     */
    public static void saveObjetosUsers() {
        Out out = new Out(".//data//objetosUsers.txt");
        for (String key : userST.keys()) {
            UserBasic user = userST.get(key);
            if (user.myObjetos.size() > 0) {
                for (String key2 : user.myObjetos.keys()) {
                    Objeto obj = user.myObjetos.get(key2);
                    if (obj.getClass().equals(Objeto.class)) {
                        out.print("objeto" + "," + obj.nameItem + "," + obj.id + "," + obj.criadorObjeto.id + "," + obj.userAtual.id + "\n");
                    } else {
                        TravelBugs tb = (TravelBugs) user.myObjetos.get(key2);
                        out.print("travelbug" + "," + tb.nameItem + "," + tb.id + "," + tb.criadorObjeto.id + "," + tb.userAtual.id + "," + tb.cacheDestino.serialNumber + "\n");

                    }

                }
            }
        }
        out.close();
    }

    /**
     * Método que lê os objetos e travel bugs de um ficheiro de texto
     */
    public static void readObjetosUsers() {
        In in = new In(".//data//objetosUsers.txt");
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] words = line.split(",");
            if (words[0].equals("objeto")) {
                UserBasic userCeator = userST.get(words[3]);
                UserBasic userAtual = userST.get(words[4]);
                Objeto objeto = new Objeto(words[2], words[1], userCeator);
                objeto.cacheAtual = null;
                objeto.userAtual = userAtual;
                userAtual.myObjetos.put(objeto.id, objeto);

            } else {
                UserPremium userCeator = (UserPremium) userST.get(words[3]);
                UserPremium userAtual = (UserPremium) userST.get(words[4]);
                Cache cacheDestino = cacheST.get(words[5]);
                if (userCeator != null && userAtual != null && cacheDestino != null) {
                    TravelBugs travelBugs = new TravelBugs(words[2], words[1], userCeator, cacheDestino);
                    travelBugs.cacheAtual = null;
                    travelBugs.userAtual = userAtual;
                    userAtual.myObjetos.put(travelBugs.id, travelBugs);
                    userCeator.meusTravelBugs.put(travelBugs.id, travelBugs);
                }
            }
        }
        in.close();
    }

    /**
     * Método que guarda o Historico de Users e caches num ficheiro de texto
     */
    public static void savehCachesehUsers() {
        Out out = new Out(".//data//hCacheshUsers.txt");
        for (String key : userST.keys()) {
            UserBasic userBasic = userST.get(key);
            if (userBasic.hCaches.size() > 0) {
                for (Date d : userBasic.hCaches.keys()) {
                    Cache cache = userBasic.hCaches.get(d);
                    out.print(userBasic.id + "," + cache.serialNumber + "," + d.day + "," + d.month + "," + d.year + "\n");
                }
            }
        }
        out.close();
    }

    /**
     * Método que lê o Historico de Users e Caches de um ficheiro de texto
     */
    public static void readhCacheshUsers() {
        In in = new In(".//data//hCacheshUsers.txt");
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] words = line.split(",");
            Cache cache = cacheST.get(words[1]);
            UserBasic user = userST.get(words[0]);
            if (cache != null && user != null) {
                int day = Integer.parseInt(words[2]);
                int month = Integer.parseInt(words[3]);
                int year = Integer.parseInt(words[4]);
                Date date = new Date(day, month, year);
                cache.hUsers.put(date, user);
                user.hCaches.put(date, cache);
                user.cachesVisitadas++;
            }

        }
    }

    /**
     * Método que guarda os Logs das Caches num ficheiro de texto
     */
    public static void saveLogsCache() {
        Out out = new Out(".//data//LogsCache.txt");
        for (String serial : cacheST.keys()) {
            Cache cache = cacheST.get(serial);
            if (cache.cacheLogs.size() > 0) {
                for (CacheLogs clogs : cache.cacheLogs) {
                    out.print(cache.serialNumber + "," + clogs.userID + "," + clogs.objetocolocado + "," + clogs.objetoretirado +
                            "," + clogs.data.day + "," + clogs.data.month + "," + clogs.data.year + "\n");
                }
            }
        }
        out.close();
    }

    /**
     * Método que lê os Logs das Caches num ficheiro de texto
     */
    public static void readLogsCache() {
        In in = new In(".//data//LogsCache.txt");
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] words = line.split(",");
            Cache cache = cacheST.get(words[0]);
            int dia = Integer.parseInt(words[4]), mes = Integer.parseInt(words[5]), ano = Integer.parseInt(words[6]);
            Date date = new Date(dia, mes, ano);
            CacheLogs clogs = new CacheLogs(date, words[1], words[2], words[3]);
            if (clogs.objetoretirado.equals("null")) clogs.objetoretirado = null;
            if (clogs.objetocolocado.equals("null")) clogs.objetocolocado = null;
            if (cache != null) cache.cacheLogs.add(clogs);
        }
        in.close();
    }

    /**
     * Método que guarda os Logs dos users num ficheiro texto
     */
    public static void saveLogsUser() {
        Out out = new Out(".//data//LogsUser.txt");
        for (String id : userST.keys()) {
            UserBasic userBasic = userST.get(id);
            if (userBasic.userLogs.size() > 0) {
                for (Date date : userBasic.userLogs.keys()) {
                    UserLogs userLogs = userBasic.userLogs.get(date);
                    out.print(userBasic.id + "," + userLogs.serialNumber + "," + userLogs.objetocolocado + "," + userLogs.objetoretirado
                            + "," + date.day + "," + date.month + "," + date.year + "\n");
                }
            }
        }
        out.close();
    }

    /**
     * Método que lê os Logs dos users de um ficheiro de texto
     */
    public static void readLogsUser() {
        In in = new In(".//data//LogsUser.txt");
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] words = line.split(",");
            UserBasic user = userST.get(words[0]);
            int dia = Integer.parseInt(words[4]), mes = Integer.parseInt(words[5]), ano = Integer.parseInt(words[6]);
            Date date = new Date(dia, mes, ano);
            UserLogs userLogs = new UserLogs(date, words[1], words[2], words[3]);
            if (userLogs.objetoretirado.equals("null")) userLogs.objetoretirado = null;
            if (userLogs.objetocolocado.equals("null")) userLogs.objetocolocado = null;
            if (user != null) user.userLogs.put(date, userLogs);
        }
        in.close();
    }

    /**
     * Método que guarda os MessageLogs num ficheiro de texto
     */
    public static void saveMessageLogs() {
        Out out = new Out(".//data//LogsMessage.txt");
        for (String key : cacheST.keys()) {
            Cache cache = cacheST.get(key);
            for (MessageLog messageLog : cache.messageLogs) {
                out.print(cache.serialNumber + "," + messageLog.mensagem + "\n");
            }
        }
        out.close();
    }

    /**
     * Método que lê os MessageLogs de um ficheiro de texto
     */
    public static void readMessageLogs() {
        In in = new In(".//data//LogsMessage.txt");
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] words = line.split(",");
            Cache cache = cacheST.get(words[0]);
            MessageLog messageLog = new MessageLog(words[1]);
            if (cache != null) cache.messageLogs.add(messageLog);
        }
        in.close();
    }

    /**
     * Método que guarda  os travel bugs e historico de caches
     */
    public static void saveTravelBugsHCaches() {
        Out out = new Out(".//data//TravelBugsHCaches.txt");
        for (String name : userST.keys()) {
            UserBasic userBasic = userST.get(name);
            if (!userBasic.getClass().equals(UserBasic.class)) {
                UserPremium userPremium = (UserPremium) userBasic;
                if (userPremium.meusTravelBugs.size() > 0) {
                    for (String id : userPremium.meusTravelBugs.keys()) {
                        TravelBugs travelBugs = userPremium.meusTravelBugs.get(id);
                        for (String key : travelBugs.historicoCaches.keys()) {
                            Cache cache = cacheST.get(key);
                            out.print(travelBugs.id + "," + cache.serialNumber + "\n");

                        }
                    }
                }
            }
        }
        out.close();

    }

    /**
     * Método que lê os travel bugs e historico de caches
     */
    public static void readTravelBugsHCaches() {
        In in = new In(".//data//TravelBugsHCaches.txt");
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] words = line.split(",");
            TravelBugs travelBugs = UserAdmin.findTravelBug(words[0]);
            Cache cache = cacheST.get(words[1]);
            if (cache != null && travelBugs != null) {
                travelBugs.historicoCaches.put(cache.serialNumber, cache);
            }

        }
        in.close();
    }

    /**
     * Método que guarda os travelBugs e historico de Users
     */
    public static void saveTravelBugsHUsers() {
        Out out = new Out(".//data//TravelBugsHUsers.txt");
        for (String id : userST.keys()) {
            UserBasic userBasic = userST.get(id);
            if (!userBasic.getClass().equals(UserBasic.class)) {
                UserPremium userPremium = (UserPremium) userBasic;
                if (userPremium.meusTravelBugs.size() > 0) {
                    for (String id2 : userPremium.meusTravelBugs.keys()) {
                        TravelBugs travelBugs = userPremium.meusTravelBugs.get(id2);
                        for (String key : travelBugs.historicoUsers.keys()) {
                            UserPremium puser = (UserPremium) userST.get(key);
                            out.print(travelBugs.id + "," + puser.id + "\n");

                        }
                    }
                }
            }
        }
        out.close();
    }

    /**
     * Método que lê os travelBugs e historico de Users
     */
    public static void readTravelBugsHUsers() {
        In in = new In(".//data//TravelBugsHUsers.txt");
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] words = line.split(",");
            TravelBugs travelBugs = UserAdmin.findTravelBug(words[0]);
            UserPremium puser = (UserPremium) userST.get(words[1]);
            if (travelBugs != null && puser != null) {
                travelBugs.historicoUsers.put(puser.id, puser);
            }

        }
        in.close();
    }

    /**
     * Método que guarda os travel bugs Logs de um ficheiro de texto
     */
    public static void saveTravelBugsLogs() {
        Out out = new Out(".//data//TravelBugsLogs.txt");
        for (String id : userST.keys()) {
            UserBasic userBasic = userST.get(id);
            if (!userBasic.getClass().equals(UserBasic.class)) {
                UserPremium userPremium = (UserPremium) userBasic;
                if (userPremium.meusTravelBugs.size() > 0) {
                    for (String id2 : userPremium.meusTravelBugs.keys()) {
                        TravelBugs travelBugs = userPremium.meusTravelBugs.get(id2);
                        for (TravelBugsLogs tblogs : travelBugs.historicoTravelBugsLogs) {
                            if (tblogs.p == null) {
                                out.print(travelBugs.criadorObjeto.id + "," + travelBugs.id + "," + tblogs.user + "," + tblogs.cache + "," +
                                        tblogs.date.day + "," + tblogs.date.month + "," + tblogs.date.year + "," + tblogs.c.serialNumber + "," + tblogs.destinoConcluido + ",CACHE\n");
                            } else {
                                out.print(travelBugs.criadorObjeto.id + "," + travelBugs.id + "," + tblogs.user + "," + tblogs.cache + "," +
                                        tblogs.date.day + "," + tblogs.date.month + "," + tblogs.date.year + "," + tblogs.p.id + "," + tblogs.destinoConcluido + ",USER\n");
                            }
                        }
                    }
                }
            }
        }
        out.close();
    }

    /**
     * Método que le os travel bugs logs de um ficheiro de texto
     */
    public static void readTravelBugsLogs() {
        In in = new In(".//data//TravelBugsLogs.txt");
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] words = line.split(",");
            UserPremium puser = (UserPremium) userST.get(words[0]);
            if (puser != null) {
                TravelBugs tb = puser.meusTravelBugs.get(words[1]);
                if (tb != null) {
                    if (words[9].equals("CACHE")) {//logs esta numa cache
                        Cache cache = cacheST.get(words[7]);
                        if (cache != null) {
                            int dia = Integer.parseInt(words[4]), mes = Integer.parseInt(words[5]), ano = Integer.parseInt(words[6]);
                            Date date = new Date(dia, mes, ano);
                            TravelBugsLogs tblogs = new TravelBugsLogs(words[3], words[2], cache, null, date);
                            if (words[8].equals("true")) tblogs.destinoConcluido = true;
                            else tblogs.destinoConcluido = false;
                            tb.historicoTravelBugsLogs.add(tblogs);
                        }

                    } else {//logs esta num user
                        UserPremium user = (UserPremium) userST.get(words[2]);
                        if (user != null) {
                            int dia = Integer.parseInt(words[4]), mes = Integer.parseInt(words[5]), ano = Integer.parseInt(words[6]);
                            Date date = new Date(dia, mes, ano);
                            TravelBugsLogs tblogs = new TravelBugsLogs(words[3], words[2], null, user, date);
                            tblogs.destinoConcluido = false;
                            tb.historicoTravelBugsLogs.add(tblogs);
                        }

                    }
                }

            }

        }
        in.close();
    }

    /**
     * Método que guarda os edges do graph
     */
    public static void saveGraphEdges() {
        Out out = new Out(".//data//EdgesGraph.txt");

        for (int v = 0; v < grafoTS.graph.V(); v++) {
            for (Aresta_Projeto edge : grafoTS.graph.adj(v)) {
                out.print(edge.from() + "-" + edge.to() + ";" + edge.km() + ";" + edge.getTime() + "\n");
            }

        }
        out.close();
    }

    /**
     * Método que le os edges do graph
     */

    public static void readGraphEdges() {
        In in = new In(".//data//EdgesGraph.txt");
        //grafoTS.graph=new Grafo_Projeto(grafoTS.st.size());
        grafoTS.graph = new Grafo_Projeto(grafoTS.st.size());
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] words = line.split(";");
            String[] edges = words[0].split("-");
            Aresta_Projeto edge = new Aresta_Projeto(Integer.parseInt(edges[0]), Integer.parseInt(edges[1]), Double.parseDouble(words[1]), Double.parseDouble(words[2]));
            grafoTS.graph.addEdge(edge);


        }
        in.close();
    }


    /**
     * Método que guarda os edges do graph
     */
    public static void saver16(String info,Date d) throws IOException {
        if(subGrafo.st.size()==0){
            System.err.println("Erro subgrafo vazio.\n");
            return;
        }
        FileWriter fileWriter = new FileWriter(".//data//r16.txt", true);
        BufferedWriter out = new BufferedWriter(fileWriter);
        out.write("Subgrafo -> " + info+"\n");
        out.write("Guardado no dia : " +d.print_upgrade()+"\n");
        out.write("Numero de Arestas: " +subGrafo.graph.E()+"\n");
        for (int v = 0; v < subGrafo.graph.V(); v++) {
            for (Aresta_Projeto edge : subGrafo.graph.adj(v)) {
                out.write(edge.from() + "-" + edge.to() + ";" + edge.km() + ";" + edge.getTime() + "\n");
            }

        }
        out.write("---------------------------------------------------------------------------\n");
        out.close();
    }

    public static void readr16(String info) {
        In in = new In(".//data//r16.txt");
        //grafoTS.graph=new Grafo_Projeto(grafoTS.st.size());
        grafoTS.graph = new Grafo_Projeto(grafoTS.st.size());
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] words = line.split(";");
            String[] edges = words[0].split("-");
            Aresta_Projeto edge = new Aresta_Projeto(Integer.parseInt(edges[0]), Integer.parseInt(edges[1]), Double.parseDouble(words[1]), Double.parseDouble(words[2]));
            grafoTS.graph.addEdge(edge);


        }
        in.close();
    }


    /**
     * Função que chama todas a funcoes save
     */
    public static void saveAll() {
        saveUsers();
        saveCaches();
        saveObjetosCache();
        saveObjetosUsers();
        savehCachesehUsers();
        saveTravelBugsHCaches();
        saveLogsCache();
        saveLogsUser();
        saveMessageLogs();
        saveTravelBugsHCaches();
        saveTravelBugsHUsers();
        saveTravelBugsLogs();
        saveGraphEdges();


    }

    /**
     * Função que chama todas a funcoes read
     */
    public static void readAll() {
        readUsers();
        readCaches();
        readObjetosCache();
        readObjetosUsers();
        readhCacheshUsers();
        readTravelBugsHCaches();
        readLogsCache();
        readLogsUser();
        readMessageLogs();
        readTravelBugsHCaches();
        readTravelBugsHUsers();
        readTravelBugsLogs();
        readGraphEdges();

    }


    /**
     * Método para arquivar um utilizador num ficheiro de texto
     *
     * @param user
     * @throws IOException
     */
    public static void ficheiroRemoverUser(UserBasic user) throws IOException {
        FileWriter fileWriter = new FileWriter(".//data//UsersRemovidos.txt", true);
        BufferedWriter ficheiro = new BufferedWriter(fileWriter);

        if (user.getClass().equals(UserBasic.class)) {
            ficheiro.write("(BASIC)Utilizador " + user.name +
                    ", ID " + user.id + "\n");
            if (user.myObjetos.size() > 0) {
                ficheiro.write("\t- tinha os seguintes objetos:\n");
                for (String obj : user.myObjetos.keys()) {
                    Objeto objeto = user.myObjetos.get(obj);
                    ficheiro.write("\t\tObjeto " + objeto.nameItem + "\n");
                }
            } else {
                ficheiro.write("\t- foi removido sem objetos objetos:\n");
            }

            if (user.userLogs.size() > 0) {
                ficheiro.write("\t- visitou as seguintes caches :\n");
                for (Date date : user.userLogs.keys()) {
                    UserLogs ulog = user.userLogs.get(date);
                    ficheiro.write("\t\t- visitou a cache " + ulog.serialNumber + "no dia " + date.print() +
                            "obj retirado " + ulog.objetoretirado + ",obj colocado " + ulog.objetocolocado + "\n");
                }
            } else {
                ficheiro.write("\t- foi removido sem visitar nenhuma cache:\n");
            }

        } else {
            UserPremium new_user = (UserPremium) user;
            if (user.getClass().equals(UserPremium.class)) {
                ficheiro.write("(PREMIUM)Utilizador " + user.name +
                        ", ID " + user.id + "\n");
            } else {
                ficheiro.write("(ADMIN)Utilizador " + user.name +
                        ", ID " + user.id + "\n");
            }

            if (new_user.myObjetos.size() > 0) {
                ficheiro.write("\t- tinha os seguintes objetos:\n");
                for (String obj : new_user.myObjetos.keys()) {
                    Objeto objeto = new_user.myObjetos.get(obj);
                    ficheiro.write("\t\tObjeto " + objeto.nameItem + "\n");
                }
            } else {
                ficheiro.write("\t- foi removido sem objetos objetos:\n");
            }

            if (new_user.userLogs.size() > 0) {
                ficheiro.write("\t- visitou as seguintes caches :\n");
                for (Date date : new_user.userLogs.keys()) {
                    UserLogs ulog = new_user.userLogs.get(date);
                    ficheiro.write("\t\t- visitou a cache " + ulog.serialNumber + "no dia " + date.print() +
                            "obj retirado " + ulog.objetoretirado + ",obj colocado " + ulog.objetocolocado + "\n");
                }
            } else {
                ficheiro.write("\t- foi removido sem visitar nenhuma cache:\n");
            }

            if (new_user.meusTravelBugs.size() > 0) {
                ficheiro.write("\t- tinha o seguintes TravelBugs :\n");
                for (String key : new_user.meusTravelBugs.keys()) {
                    TravelBugs tb = new_user.meusTravelBugs.get(key);
                    ficheiro.write("\t\t- " + tb.nameItem + " ,ID" + tb.id + ",Cache destino" + tb.cacheDestino.serialNumber + "\n");
                }
            }
        }
        ficheiro.write("--------------------------------------------------------------------------------\n");
        ficheiro.close();
        fileWriter.close();


    }

    /**
     * Método para arquivar uma cache num ficheiro de texto
     *
     * @param cache
     * @throws IOException
     */
    public static void ficheiroRemoverCache(Cache cache) throws IOException {
        FileWriter fileWriter = new FileWriter(".//data//CacheRemovidos.txt", true);
        BufferedWriter ficheiro = new BufferedWriter(fileWriter);


        ficheiro.write("Cache " + cache.serialNumber + ",Tipo " + cache.type.name() + ",Dificuldade " +
                cache.diff.name() + "\n");
        if (cache.meusObjetos.size() > 0) {
            ficheiro.write("\t- tinha os seguintes objetos:\n");
            for (String obj : cache.meusObjetos.keys()) {
                Objeto objeto = cache.meusObjetos.get(obj);
                ficheiro.write("\t\tObjeto " + objeto.nameItem + "\n");
            }
        } else {
            ficheiro.write("\t- foi removido sem objetos objetos:\n");
        }

        if (cache.cacheLogs.size() > 0) {
            ficheiro.write("\t- recebeu as seguintes visitas :\n");
            for (CacheLogs clogs : cache.cacheLogs) {
                Date d = clogs.data;
                ficheiro.write("\t\t- recebeu o user " + userST.get(clogs.userID).name + " no dia " + d.print() +
                        "obj retirado " + clogs.objetoretirado + ",obj colocado " + clogs.objetocolocado + "\n");
            }
        } else {
            ficheiro.write("\t- foi removido sem receber visitas:\n");
        }


        ficheiro.write("--------------------------------------------------------------------------------\n");
        ficheiro.close();
        fileWriter.close();
    }

    @Override
    public String toString() {
        return "UserAdmin{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", cachesVisitadas=" + cachesVisitadas +
                '}';
    }


    //////////////////////////////////////////////////////////   BINARIOS  //////////////////////////////////////////////////////////////////

    public static void saveUsersBin() {

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(".//data//userBin.bin"))){
            oos.writeObject(userST);
            /*oos.writeInt(userST.size());
            for (String key :userST.keys()){
                UserBasic user = userST.get(key);
                oos.writeObject(user);
            }

             */
        }catch(IOException e){
            System.out.println(e);
        }
    }

    public static void readUsersBin(){
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(".//data//userBin.bin"));
            userST=(ST_AED2<String, UserBasic>) ois.readObject();
            /*int size = ois.readInt();
            for(int i =0;i<size;i++){
                UserBasic user = (UserBasic) ois.readObject();
                userST.put(user.id,user);
            }
*/
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public static void saveCachesBin() {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(".//data//cachesBin.bin"))){
            oos.writeObject(cacheST);
            /*oos.writeInt(cacheST.size());
            for (String key : cacheST.keys()){
                Cache c = cacheST.get(key);
                oos.writeObject(c);
            }

             */
        }catch(IOException e){
            System.out.println(e);
        }

    }

    public static void readCachesBin(){
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(".//data//cachesBin.bin"));
            cacheST=(ST_AED2<String, Cache>) ois.readObject();
            /*int size = ois.readInt();
            for (int i =0;i<size;i++){
                Cache c = (Cache) ois.readObject();
                cacheST.put(c.serialNumber,c);
            }

             */
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }


    public static void saveGraphBin() {

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(".//data//graphBin.bin"))){
            oos.writeObject(grafoTS);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    public static void readGraphBin(){
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(".//data//graphBin.bin"));
            grafoTS=(Grafos_Tabela_Simbolos) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }



    //////////////////////////////////////////////////////////   GRAPHS //////////////////////////////////////////////////////////////////

    public static void SubGraphZona(String zona,boolean writeFile) throws IOException {
        zona = zona.toLowerCase();

        //caso seja zona invalida
        if (!zona.equals("norte") && !zona.equals("centro") && !zona.equals("sul")) {
            System.err.println("Zona invalida");
        }
        //caso zona for norte centro ou sul
        else {
            //Preencher ST do subgraph
            subGrafo.st = new ST_AED2<>();
            for (String key : cacheST.keys()) {
                Cache c = cacheST.get(key);
                if (c.regiao.equals(zona)) subGrafo.st.put(c.serialNumber, subGrafo.st.size());
            }

            //Preencher Graph do subgraph
            subGrafo.graph = new Grafo_Projeto(subGrafo.st.size(), false);
            for (String key : subGrafo.st) {
                int index = grafoTS.st.get(key);
                for (Aresta_Projeto a : grafoTS.graph.adj(index)) {
                    if (cacheST.get(findIndexCacheName(grafoTS, a.to())).regiao.equals(zona)) {
                        int idx1 = subGrafo.st.get(findIndexCacheName(grafoTS, a.from()));
                        int idx2 = subGrafo.st.get(findIndexCacheName(grafoTS, a.to()));
                        subGrafo.graph.addEdge(new Aresta_Projeto(idx1, idx2, a.km(), a.getTime()));
                    }
                }
            }
            if(writeFile){
                StringBuilder info = new StringBuilder();
                info.append("Zona:" + zona);
                String aux = info.toString();
                UserAdmin.saver16(aux,new Date());
            }

        }
    }

    public static void SubGraphDificuldade(CacheDiff cacheDiff,boolean writeFile) throws IOException {
        //Preencher ST do subgraph
        subGrafo.st = new ST_AED2<>();
        for (String key : cacheST.keys()) {
            Cache c = cacheST.get(key);
            if (c.diff.equals(cacheDiff)) subGrafo.st.put(c.serialNumber, subGrafo.st.size());
        }

        //Preencher Graph do subgraph
        subGrafo.graph = new Grafo_Projeto(subGrafo.st.size(), false);
        for (String key : subGrafo.st) {
            int index = grafoTS.st.get(key);
            for (Aresta_Projeto a : grafoTS.graph.adj(index)) {
                if (cacheST.get(findIndexCacheName(grafoTS, a.to())).diff.equals(cacheDiff)) {
                    int idx1 = subGrafo.st.get(findIndexCacheName(grafoTS, a.from()));
                    int idx2 = subGrafo.st.get(findIndexCacheName(grafoTS, a.to()));
                    subGrafo.graph.addEdge(new Aresta_Projeto(idx1, idx2, a.km(), a.getTime()));
                }
            }
        }
        if(writeFile){
            String dif = "Easy";
            if(cacheDiff.equals(CacheDiff.Medium))dif="Medium";
            else if(cacheDiff.equals(CacheDiff.Hard))dif="Hard";
            UserAdmin.saver16(dif,new Date());
        }
    }

    public static void SubGraphNrVisitasmaior(int visitas,boolean writeFile) {
        if (visitas <= 0) {
            System.err.println("Nr visitas invalido.\n");
            return;
        }
        //Preencher ST do subgraph
        subGrafo.st = new ST_AED2<>();
        for (String key : cacheST.keys()) {
            Cache c = cacheST.get(key);
            if (c.hUsers.size() >= visitas) subGrafo.st.put(c.serialNumber, subGrafo.st.size());
        }

        //Preencher Graph do subgraph
        subGrafo.graph = new Grafo_Projeto(subGrafo.st.size(), false);
        for (String key : subGrafo.st) {
            int index = grafoTS.st.get(key);
            for (Aresta_Projeto a : grafoTS.graph.adj(index)) {
                if (cacheST.get(findIndexCacheName(grafoTS, a.to())).hUsers.size() >= visitas) {
                    int idx1 = subGrafo.st.get(findIndexCacheName(grafoTS, a.from()));
                    int idx2 = subGrafo.st.get(findIndexCacheName(grafoTS, a.to()));
                    subGrafo.graph.addEdge(new Aresta_Projeto(idx1, idx2, a.km(), a.getTime()));
                }
            }
        }


    }

    public static void SubGraphNrVisitasmenor(int visitas,boolean writeFile) {
        if (visitas <= 0) {
            System.err.println("Nr visitas invalido.\n");
            return;
        }
        //Preencher ST do subgraph
        subGrafo.st = new ST_AED2<>();
        for (String key : cacheST.keys()) {
            Cache c = cacheST.get(key);

            if (c.hUsers.size() <= visitas) subGrafo.st.put(c.serialNumber, subGrafo.st.size());
        }

        //Preencher Graph do subgraph
        subGrafo.graph = new Grafo_Projeto(subGrafo.st.size(), false);
        for (String key : subGrafo.st) {
            int index = grafoTS.st.get(key);
            for (Aresta_Projeto a : grafoTS.graph.adj(index)) {
                if (cacheST.get(findIndexCacheName(grafoTS, a.to())).hUsers.size() <= visitas) {
                    int idx1 = subGrafo.st.get(findIndexCacheName(grafoTS, a.from()));
                    int idx2 = subGrafo.st.get(findIndexCacheName(grafoTS, a.to()));
                    subGrafo.graph.addEdge(new Aresta_Projeto(idx1, idx2, a.km(), a.getTime()));
                }
            }
        }


    }

    public static void SubGraphNrVisitasMenorMaior(int minVisitas, int maxVisitas,boolean writeFile) {
        if (minVisitas <= 0 || maxVisitas <= 0) {
            System.err.println("Nr visitas invalido.\n");
            return;
        }
        //Preencher ST do subgraph
        subGrafo.st = new ST_AED2<>();
        for (String key : cacheST.keys()) {
            Cache c = cacheST.get(key);

            if (c.hUsers.size() >= minVisitas && c.hUsers.size() <= maxVisitas)
                subGrafo.st.put(c.serialNumber, subGrafo.st.size());
        }

        //Preencher Graph do subgraph
        subGrafo.graph = new Grafo_Projeto(subGrafo.st.size(), false);
        for (String key : subGrafo.st) {
            int index = grafoTS.st.get(key);
            for (Aresta_Projeto a : grafoTS.graph.adj(index)) {
                if (cacheST.get(findIndexCacheName(grafoTS, a.to())).hUsers.size() >= minVisitas && cacheST.get(findIndexCacheName(grafoTS, a.to())).hUsers.size() <= maxVisitas) {
                    int idx1 = subGrafo.st.get(findIndexCacheName(grafoTS, a.from()));
                    int idx2 = subGrafo.st.get(findIndexCacheName(grafoTS, a.to()));
                    subGrafo.graph.addEdge(new Aresta_Projeto(idx1, idx2, a.km(), a.getTime()));
                }
            }
        }


    }


    public static void r18(double km){
        System.out.println("r18 - Caixeiro viajante\n");
        int index=0;
        double totalkm=0.0;
        Grafo_Projeto graph = grafoTS.graph;
        for (int v =0;v<graph.V();v++){
            System.out.println("Da cache " + findIndexCacheName(grafoTS,v) + " pode-se chegar com um total de " +km +" km as seguintes caches:\n");
            Prim_AED2 prim = new Prim_AED2(graph,v,km);
            boolean hasone= false;
            for (Aresta_Projeto edge: prim.edges()){
                hasone=true;
                System.out.println("\t"+edge);
            }
            if(prim.weight()>totalkm){
                totalkm=prim.weight();
                index=v;
            }
            if(!hasone) System.out.println("Esta cache nao consegue ir para nenhuma outra cache.");
            StdOut.printf("Caches percorridas com um total de km de %.3f\n",prim.weight());
            System.out.println("----------------------------------");
        }
        String cache = findIndexCacheName(grafoTS,index);
        System.out.println("\nA cache que percorreu mais km foi a " + cache + " com um total de km de :" + totalkm + "\n");

    }


    public static String findIndexCacheName(Grafos_Tabela_Simbolos G, int index) {
        for (String key : G.st) {
            if (G.st.get(key).equals(index)) return key;
        }

        return null;
    }


}
