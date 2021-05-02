package edu.ufp.inf.lp2.geocaching;

import static edu.ufp.inf.lp2.geocaching.UserAdmin.cacheST;
import static edu.ufp.inf.lp2.geocaching.UserAdmin.userST;

public class Main {


    private static final String FILE_DELIMETER = ";";

    public static void main(String[] args) {
        System.out.println(userST.size());
        System.out.println(cacheST.size());


        //---------[Criação de utilizadores]---------
        UserBasic u1= new UserBasic("40097", "Tomas");
        UserBasic u2= new UserBasic("39917", "Ruben");
        UserPremium u3= new UserPremium("1904", "Leticia");
        UserPremium u4= new UserPremium("5555", "Leonor");
        UserAdmin u5= new UserAdmin("1001", "Ivone");
        UserAdmin u6= new UserAdmin("7004", "Arriscado");

        //---------[Inserção de Utilizadores na ST]---------




        //---------[Print Utilizadores]---------


//        //---------[Editar Utilizador da ST]---------
//        editUser(u1,"TomasEditado");
//        editUser(u3,"LeticiaEditado");
//
//        //---------[Remover Utilizador]---------
//        removeUser(u3);
//
//        printUsers();
//
//       // ---------[Escrever e Ler Utilizadores do ficheiro]---------
//        writeUser_txt(".//data/user.txt");
//        readUser_txt(".//data/user.txt");
//        printUsers();


        //---------[Caches de objetos e Caches]---------
      /*  Objeto rato = new Objeto("44","rato");
        Objeto teclado= new Objeto("55", "teclado");
        Objeto monitor = new Objeto("66", "monitor");
        ArrayList<Objeto> lista1= new ArrayList<>();
        lista1.add(rato);
        lista1.add(teclado);

        ArrayList<Objeto> lista2= new ArrayList<>();
        lista2.add(rato);
        lista2.add(monitor);

        Cache c1= new Cache("11",CacheDiff.Easy,u3, lista1 ,1,3,"Lisboa");
        Cache c2= new Cache("21",CacheDiff.Medium,u3, lista2 ,6,8,"Porto");
        Cache c3= new Cache("31",CacheDiff.Hard,u4, lista1 ,7,4,"Cardielos");
        Cache c4= new Cache("33",CacheDiff.Medium,u4, lista2 ,9,6,"Torre");
        Cache c5= new Cache("55",CacheDiff.Hard,u5, lista1 ,12,55,"Ponte de Lima");
        Cache c6= new Cache("66",CacheDiff.Easy,u6, lista2 ,43,76,"Braga");
*/
        //---------[Inserção na ST de Caches]---------
       /* insertCache(c3,"Carlos");
        insertCache(c4,"Leonor");
        insertCache(c5,"Ivone");
        insertCache(c6,"Arriscado");
        printCaches();
        */

//        //---------[Inserção de Caches no ArrayList de UserAdmin --> Caches Premium]---------
//        u5.insertCache(c1);
//        u6.insertCache(c2);
//        u5.printCaches();
//        u6.printCaches();
//
//
//        //---------[Editar Caches da ST]---------
//        editCache(c3,"99",CacheDiff.Easy,u3,8,55,"Viana");
//        printCaches();
//
//        //---------[Remover Caches da ST]---------
//        removeCache(c5);
//        removeCache(c6);
//        printCaches();
//        c3.printObjetoFromCache();
//        c4.printObjetoFromCache();
//
//
//     /*  //---------[Escrever e Ler Caches e Objetos do ficheiro]---------
//        writeCache_txt(".//data/cache.txt");
//        writeObjeto_txt(".//data/objeto.txt");
//        //falta ler da cache e do objeto
//        u5.printCache();
//*/
//           ---------[Inserção de Caches no ArrayList de UserAdmin --> Caches Premium]---------
//        u5.insertCache(c1);
//        u6.insertCache(c2);
//        u5.printCaches();
//        u6.printCaches();




    }

    /*

    private static void readUser_txt(String path){
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

    private static void printUsers(){
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

    private static void writeUser_txt(String path){
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
    }

    private static void interacao(Cache cache, UserBasic user, ArrayList objetosRetirados, ArrayList objetosColocados, String mensagem,String date){
        //cache.interacaoCache(user,objetosColocados,objetosRetirados,date,mensagem);
    }


     */
}

