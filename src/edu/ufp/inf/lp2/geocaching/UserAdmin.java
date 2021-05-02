package edu.ufp.inf.lp2.geocaching;

import edu.princeton.cs.algs4.ST;




public class UserAdmin extends UserPremium {

    public static ST<String, UserBasic> userST = new ST<>();

    public static   ST<String, Cache> cacheST = new ST<>();

    public UserAdmin(String id, String name) {
        super(id, name);
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

    private static void insertCache(Cache cache){
        cacheST.put(cache.serialNumber,cache);
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

    private static void editCache(Cache cache, String serialNumber, CacheDiff type , UserPremium usercreator, int x, int y, String regiao){
        cache.serialNumber = serialNumber;
        cache.type=type;
        cache.userCreator = usercreator;
        cache.x = x;
        cache.y = y;
        cache.regiao=regiao;
    }


    @Override
    public String toString() {
        return "UserAdmin{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", cachesVisitadas=" + cachesVisitadas +
                ", cachesEscondidas=" + cachesEscondidas +
                '}';
    }
}