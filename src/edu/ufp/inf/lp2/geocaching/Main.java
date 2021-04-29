package edu.ufp.inf.lp2.geocaching;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.ST;

import java.util.ArrayList;


public class Main {

    private static ST<String, UserBasic> userST = new ST<>();

    private static   ST<String, Cache> cacheST = new ST<>();

    private static final String FILE_DELIMETER = ";";

    public static void main(String[] args) {

        //---------[Criação de utilizadores]---------
        UserBasic u1= new UserBasic("40097", "Tomas");
        UserBasic u2= new UserBasic("39917", "Ruben");
        UserPremium u3= new UserPremium("1904", "Leticia");
        UserPremium u4= new UserPremium("5555", "Leonor");
        UserAdmin u5= new UserAdmin("1001", "Ivone");
        UserAdmin u6= new UserAdmin("7004", "Arriscado");

        //---------[Inserção de Utilizadores na ST]---------

        insertUser(u1);
        insertUser(u3);
        insertUser(u5);


//        //---------[Print Utilizadores]---------
//        printUsers();
//
//
//        //---------[Editar Utilizador da ST]---------
//        editUser(u1,"TomasEditado");
//        editUser(u3,"LeticiaEditado");
//
//        //---------[Remover Utilizador]---------
//        removeUser(u3);
//
//        printUsers();
//
//        //---------[Escrever e Ler Utilizadores do ficheiro]---------
//        //writeUser_txt(".//data/user.txt");
//        //readUser_txt(userST, ".//data/user.txt");
//        //printUsers();


        //---------[Caches de objetos e Caches]---------
        Objeto rato = new Objeto("44","rato");
        Objeto teclado= new Objeto("55", "teclado");
        Objeto monitor = new Objeto("66", "monitor");
        ArrayList<Objeto> lista1= new ArrayList<>();
        lista1.add(rato);
        lista1.add(teclado);

        ArrayList<Objeto> lista2= new ArrayList<>();
        lista2.add(rato);
        lista2.add(monitor);

        Cache c1= new Cache("11",CacheDiff.Easy,u1, lista1 ,1,3,"Lisboa");
        Cache c2= new Cache("21",CacheDiff.Medium,u2, lista2 ,6,8,"Porto");
        Cache c3= new Cache("31",CacheDiff.Hard,u3, lista1 ,7,4,"Cardielos");

        //---------[Inserção de Cache na ST]---------
        u5.insertCache(c1);
        //u5.insertCache(c2);
        u6.insertCache(c2);

        //---------[Print Caches]---------
        u5.printCaches();
        u6.printCaches();
        printCaches();

        //---------[Editar Caches da ST]---------
        //u5.editCache(c1,"33",CacheDiff.Hard,u1,8,9,"Viana");
        //u5.printCache();

        //---------[Remover Caches da ST]---------
        u5.removeCache(c1);
        u5.removeCache(c2);
        u5.printCaches();
        c1.printObjetoFromCache();


       /* //---------[Escrever e Ler Caches e Objetos do ficheiro]---------
        writeCache_txt(".//data/cache.txt");
        writeObjeto_txt(".//data/objeto.txt");
        //falta ler da cache e do objeto
        u5.printCache();
*/

    }

    private void readUser_txt(String path){
        In in = new In(path);
        in.readLine();

        while (!in.isEmpty()){
            String line = in.readLine();
            String [] fields = line. split(FILE_DELIMETER);

            String userType= fields[0];
            String id = fields[1];
            String username= fields[2];

            switch (userType){
                case "Basic": UserBasic u = new UserBasic(id,username);
                    userST.put(u.getName(),u);
                    break;
                case "Premium": UserPremium u2= new UserPremium(id,username);
                    userST.put(u2.getName(),u2);
                    break;

                case "Admin": UserAdmin u3= new UserAdmin(id,username);
                    userST.put(u3.getName(),u3);
            }


        }
    }

     private static   void printUsers(){
        for (String name : userST.keys()){
            UserBasic u = userST.get(name);
            System.out.println(userST.get(name));
        }
        System.out.println("\n");
    }

    public static void printCaches(){
        for (String cacheName: cacheST.keys()){
            System.out.println(cacheST.get(cacheName));
        }
        System.out.println("\n");
    }

    private  void writeUser_txt(String path){
        Out out = new Out(path);

        for (String u: userST.keys()){
            out.println( userST.get(u).getId() + " " + userST.get(u).getName() + " " );
        }
        System.out.println("\n");
    }

//    private  void writeCache_txt(String path){
//        Out out = new Out(path);
//
//        for (String u: cacheST.keys()){
//            out.println(cacheST.get(u).getSerialNumber() + " " + cacheST.get(u).type + " " + cacheST.get(u).obj.nameItem + " " + cacheST.get(u).getX() + " " + cacheST.get(u).getY() + " " + cacheST.get(u).getRegiao() );
//        }
//        System.out.println("\n");
//    }
//
//    private  void writeObjeto_txt(String path){
//        Out out = new Out(path);
//
//        for (String u: cacheST.keys()){
//            out.println(cacheST.get(u).getSerialNumber() + " " + cacheST.get(u).obj.nameItem );
//        }
//        System.out.println("\n");
//    }

    private static void insertUser(UserBasic user){
        userST.put(user.id, user);
    }

    private static void editUser(UserBasic user, String name){
        user.name=name;
        userST.put(user.id,user);
    }

    private static void printUser(UserBasic user){
        System.out.println("Lista Utilizadores: ");
        for (String name: userST.keys()){
            System.out.println(userST.get(name));
        }
        System.out.println("\n");
    }

    private static void removeUser(UserBasic user){
        userST.remove(user.id);
    }

    private static void insertCache(Cache cache, String criador){
        cacheST.put(cache.serialNumber,cache);
        if ((userST.get(criador) instanceof UserAdmin))
         {
             ((UserAdmin)(userST.get(criador))).insertCache(cache);
        }

    }

    private static void removeCache(Cache cache){
        cacheST.remove(cache.serialNumber);
    }

    private static void printCache(){
        System.out.println("Lista Caches: ");
        for (String cacheName: cacheST.keys()){
            System.out.println(cacheST.get(cacheName));
        }
        System.out.println("\n");
    }

    private static void editCache(Cache cache, String serialNumber, CacheDiff type , UserBasic usercreator, int x, int y, String regiao){
        cache.serialNumber = serialNumber;
        cache.type=type;
        cache.userCreator = usercreator;
        cache.x = x;
        cache.y = y;
        cache.regiao=regiao;
        cacheST.put(cache.serialNumber,cache);
    }

}

