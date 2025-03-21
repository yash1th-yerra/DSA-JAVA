package src.prototypecase;

import java.util.HashMap;
import java.util.Map;

public class DatabaseCache {

    private static Map<Integer,DatabaseRecord> cache = new HashMap<>();
    public static void loadCache(){
        UserRecord user1 = new UserRecord("Yashwanth");
        user1.setId(1);
        cache.put(user1.getId(),user1);
    }

    public static DatabaseRecord getRecord(int id) {
        return cache.get(id).clone();
    }
}
