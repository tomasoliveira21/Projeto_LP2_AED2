package edu.ufp.inf.lp2.geocaching;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.ST;

import java.util.ArrayList;


public class UserAdmin extends UserPremium {

    public static ST<String, UserBasic> userST = new ST<>();

    public static ST<String, Cache> cacheST = new ST<>();

    public UserAdmin(String name, String id) {
        super(name, id);
    }


    public void editUser(UserBasic user, String name) {
        user.name = name;
        userST.put(user.id, user);
    }


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


    public void insertCache(Cache cache) {
        cacheST.put(cache.serialNumber, cache);
    }

    public void removeCache(Cache cache) {
        cacheST.remove(cache.serialNumber);
    }


    public void printCache() {
        System.out.println("Lista Caches: ");
        for (String cacheName : cacheST.keys()) {
            System.out.println(cacheST.get(cacheName));
        }
        System.out.println("\n");
    }

    public void printUser() {

        System.out.println("Lista Utilizadores: ");
        for (String name : userST.keys()) {
            System.out.println(userST.get(name));
        }
        System.out.println("\n");
    }

    public void print_r8a_global(UserBasic userBasic) {
        System.out.println();
        userBasic.printhCaches();
    }

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

    public void printr8b(UserBasic userBasic) {
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

    public void print_r8b_regiao(UserBasic userBasic, String regiao) {
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


    public void printr8c(Cache cache) {
        System.out.println(cache.serialNumber + " -> Utilizadores que visitaram esta cache:");
        for (Date date : cache.hUsers.keys()) {
            UserBasic userBasic = cache.hUsers.get(date);
            System.out.println("\t" + userBasic.name + " visitou esta cache no dia no dia " + date.print() + ".");
        }
        System.out.println();
    }

    public void printr8d() {//Todas as caches premium que têm pelo menos um objecto;
        System.out.println("Caches primium que tem objetos:");
        for (String key : cacheST) {
            Cache cache = cacheST.get(key);
            if (cache.type.equals(CacheType.Premium) && cache.meusObjetos.size() > 0) {
                System.out.println("\t" + cache.serialNumber);
            }

        }
    }

    public void printr8e(Date dinicial, Date dfinal) {//Top-5 de utilizadores que visitaram maior nº de caches num dado períodotemporal;
        ST<String, Integer> totalvisitas = new ST<>();
        for (String key : cacheST) {
            Cache cache = cacheST.get(key);
            for (CacheLogs clogs : cache.cacheLogs) {
                //se visitou entre as datas
                if (clogs.data.afterDate(dinicial) && clogs.data.beforeDate(dfinal) || clogs.data.equals(dinicial) || clogs.data.equals(dfinal)) {
                    String userid = clogs.userID;
                    if (totalvisitas.contains(userid)) {//se ser ja estiver na bst
                        totalvisitas.put(userid, totalvisitas.get(userid) + 1);//incremento 1 visita
                    } else totalvisitas.put(userid, 1);//se nao visitas = 1
                }
            }
        }

        int top5 = 0, topvisiter = 0, lastvisiter = 0;
        String user = "", lastusername = "";
        while (top5 < 5 && totalvisitas.size() > 0) {//caso nao haja mais que 5
            for (String id : totalvisitas.keys()) {

                if (top5 == 0 && totalvisitas.get(id) >= topvisiter) {
                    topvisiter = totalvisitas.get(id);
                    user = id;
                } else if (top5 > 0 && totalvisitas.get(id) > topvisiter && totalvisitas.get(id) <= lastvisiter && !lastusername.equals(id)) {
                    topvisiter = totalvisitas.get(id);
                    user = id;
                }

            }
            if (top5 == 0) System.out.println("Top 5 utilizadores mais ativos:");
            System.out.println("Top " + (top5 + 1) + "-> " + userST.get(user).name + " com um total de visitas de: " + topvisiter);
            lastusername = user;
            lastvisiter = topvisiter;
            topvisiter = 0;
            top5++;
            totalvisitas.delete(user);
        }


    }

    public void printr8f() {
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

    public void printObjetosAllCaches() {
        System.out.println("Lista todos Objetos das Caches\n");
        for (String key : cacheST.keys()) {
            Cache c = cacheST.get(key);
            if (c.meusObjetos.size() > 0) {
                System.out.println("Objetos da cache " + c.serialNumber + ":");
                for (String obj : c.meusObjetos.keys()) {
                    System.out.println("\t" + c.meusObjetos.get(obj).toString());
                }
            }
            System.out.println("\n");
        }
    }

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

    public void printCacheLogs() {
        System.out.println("\n\nLogs das Caches:\n");
        for (String serial : cacheST.keys()) {
            Cache cache = cacheST.get(serial);
            if (cache.cacheLogs.size() > 0) {
                System.out.println("\tCache ->" + cache.serialNumber + "Logs:");
                for (CacheLogs clogs : cache.cacheLogs) {
                    System.out.println("\t\t->" + clogs.toString());
                }
            }

        }
    }

    public void printUserLogs() {
        System.out.println("\n\nLogs das Users:\n");
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


    public void editCache(Cache cache, String serialNumber, CacheDiff type, UserPremium usercreator, int x, int y, String regiao) {
        cache.serialNumber = serialNumber;
        cache.diff = type;
        cache.userCreator = usercreator;
        cache.x = x;
        cache.y = y;
        cache.regiao = regiao;
    }


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


    @Override
    public String toString() {
        return "UserAdmin{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", cachesVisitadas=" + cachesVisitadas +
                '}';
    }
}