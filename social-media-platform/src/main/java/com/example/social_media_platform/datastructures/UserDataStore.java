/*
//HashMap for Storing User Details
//will provide fast access to info based on unique key(userID))

package com.example.social_media_platform.datastructures;
import com.example.social_media_platform.model.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
@Component
public class UserDataStore {
    private HashMap<Long, User> userMap = new HashMap<>();

    public void addUser(User user){
        userMap.put(user.getId(),user);
    }

    public User getUser(Long id){
        return  userMap.get(id);
    }

    public void removeUser(Long id){
        userMap.remove(id);
    }
}
*/
