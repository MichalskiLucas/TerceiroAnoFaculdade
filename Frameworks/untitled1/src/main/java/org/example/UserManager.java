package org.example;

import java.util.HashMap;
import java.util.Map;

public class UserManager {

    private Map<String, Object> user = new HashMap<>();
    private static UserManager instance = new UserManager();

    public UserManager() {
    }

    public static UserManager getInstance(){
        return instance;
    }

    public void set(String key, Object value){
        user.put(key, value);
    }

    public Object get(String key){
        return user.get(key);
    }

}
