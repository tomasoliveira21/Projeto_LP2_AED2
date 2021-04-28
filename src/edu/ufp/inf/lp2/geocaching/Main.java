package edu.ufp.inf.lp2.geocaching;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.ST;

import static edu.ufp.inf.lp2.geocaching.UserBasic.userST;

public class Main {

    private static final String FILE_DELIMETER = ";";

    public static void main(String[] args) {

        //---------[Criação de utilizadores]---------
        UserBasic u1= new UserBasic("40097", "Tomas", 1,2);
        UserBasic u2= new UserBasic("3999", "Ruben", 3,4);
        UserPremium u3= new UserPremium("1904", "Leticia", 5,6);
        UserPremium u4= new UserPremium("5555", "Leonor", 7,8);
        UserAdmin u5= new UserAdmin("1001", "Ivone", 9, 10 );
        UserAdmin u6= new UserAdmin("7004", "Arriscado", 11,12);

        //---------[Inserção de Utilizadores na ST]---------
        u1.insertUser();
        u2.insertUser();
        u3.insertUser();
        u4.insertUser();
        u5.insertUser();
        u6.insertUser();

        //---------[Print Utilizadores]---------
        u1.printUser();

/*
        //---------[Editar Utilizador da ST]---------
        u1.editUser("TomasEditado",12,55);
        u2.editUser("RubenEditado", 66,77);
        u3.editUser("LeticiaEditada", 343, 314);
        u4.editUser("LeonorEditada", 22, 55);
        u5.editUser("IvoneEditada", 66,88);
        u6.editUser("ArriscadoEditada", 78, 32);

        //---------[Print Utilizadores]---------
        u1.printUser();

        //---------[Remover Utilizador]---------
        u6.removeUser("7004");

        //---------[Print Utilizadores]---------
        u1.printUser();

        */

        //---------[Escrever e Ler Utilizadores do ficheiro]---------
        writeUser_txt(userST,".//data/user.txt");
        //readUser_txt(userST, ".//data/user.txt");
        printUsers(userST);


        //---------[Caches de objetos e Caches]---------
        Objeto rato = new Objeto("44","rato");
        Objeto teclado= new Objeto("55", "teclado");
        Objeto monitor = new Objeto("66", "monitor");

        Cache c1= new Cache("1",u1,CacheDiff.Easy,11,22);
        Cache c2= new Cache("2",u2,CacheDiff.Medium,33,44);
        Cache c3= new Cache("3",u3,CacheDiff.Hard,55,66);
        Cache c4= new Cache("4",u4,CacheDiff.Easy,77,88);
        Cache c5= new Cache("5",u5,CacheDiff.Medium,99,110);
        Cache c6= new Cache("6",u6,CacheDiff.Hard,55,66);

        //---------[Inserção de Caches na ST]---------



    }

    private static void readUser_txt(ST<String, UserBasic> userST, String path){
        In in = new In(path);
        in.readLine();

        while (!in.isEmpty()){
            String line = in.readLine();
            String [] fields = line. split(FILE_DELIMETER);

            UserBasic u = new UserBasic(fields[0], fields[1], Integer.parseInt(fields[2]), Integer.parseInt(fields[3]));
            userST.put(u.getName(),u);
        }
    }

    private static void printUsers(ST<String, UserBasic> userST){
        for (String name : userST.keys()){
            UserBasic u = userST.get(name);
            System.out.println(userST.get(name));
        }
        System.out.println("\n");
    }

    private static void writeUser_txt(ST<String, UserBasic> userST, String path){
        Out out = new Out(path);

        for (String u: userST.keys()){
            out.println( userST.get(u).getId() + " " + userST.get(u).getName() + " " + userST.get(u).getX() + " " +userST.get(u).getY());
        }
        System.out.println("\n");
    }


}

