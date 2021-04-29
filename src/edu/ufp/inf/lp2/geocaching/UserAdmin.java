package edu.ufp.inf.lp2.geocaching;

import java.util.ArrayList;

public class UserAdmin extends UserPremium {

   private ArrayList<Cache> arrayListCache= new ArrayList<>();

    public UserAdmin(String id, String name) {
        super(id, name);
    }

    
    public UserBasic createUser(String id, String name, UserType t){
        switch (t){
            case Basic:  return new UserBasic(id,name);
            case Premium: return new UserPremium(id,name);
            case Admin: return new UserAdmin(id,name);
        }
        return null;
    }

    public void editUser(UserBasic user, String name){
        user.name=name;
    }


  public void insertCache(Cache cache){
    arrayListCache.add(cache);
  }

  public void removeCache(Cache cache){
    arrayListCache.remove(cache);
  }

    public void printCaches(){
        System.out.println("Lista Caches: ");
        for (Cache cache: arrayListCache){
            System.out.println(cache.toString());
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