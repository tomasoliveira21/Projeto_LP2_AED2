package edu.ufp.inf.lp2.geocaching;

public class Main {

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

        //---------[Caches]---------
        Objeto rato = new Objeto("44","rato");
        Objeto teclado= new Objeto("55", "teclado");
        Objeto monitor = new Objeto("66", "monitor");


    }

}
