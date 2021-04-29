package edu.ufp.inf.lp2.geocaching;

import edu.princeton.cs.algs4.ST;

public class UserAdmin extends UserPremium {

    public static ST<String, UserBasic> userST = new ST<>();

    public static ST<String, Cache> cacheST = new ST<>();

    public UserAdmin(String id, String name, int x, int y) {
        super(id, name, x, y);
    }



    public void insertUser(UserBasic user){
        userST.put(user.id, user);
    }

    public void editUser(UserBasic user, String name, int x, int y){
        user.name=name;
        user.x=x;
        user.y=y;
        userST.put(user.id,user);
    }

    public void printUser(UserBasic user){
        System.out.println("Lista Utilizadores: ");
        for (String name: userST.keys()){
            System.out.println(userST.get(name));
        }
        System.out.println("\n");
    }

    public void removeUser(UserBasic user,String id){
        userST.remove(user.id);
    }


  public void insertCache(Cache cache){
    cacheST.put(cache.serialNumber,cache);
  }

  public void removeCache(Cache cache){
    cacheST.remove(cache.serialNumber);
  }

    public void printCache(){
        System.out.println("Lista Caches: ");
        for (String cacheName: cacheST.keys()){
            System.out.println(cacheST.get(cacheName));
        }
        System.out.println("\n");
    }

    public void editCache(Cache cache, String serialNumber, CacheDiff type , UserBasic usercreator, int x, int y, String regiao){
        cache.serialNumber = serialNumber;
        cache.type=type;
        cache.userCreator = usercreator;
        cache.x = x;
        cache.y = y;
        cache.regiao=regiao;
        cacheST.put(cache.serialNumber,cache);
    }


    @Override
    public String toString() {
        return "UserAdmin{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", cachesVisitadas=" + cachesVisitadas +
                ", cachesEscondidas=" + cachesEscondidas +
                '}';
    }
}