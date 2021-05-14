package com.efub.efubCRUDexample.dao;

import com.efub.efubCRUDexample.model.User;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository @Primary
public class UserDAO {
    public static List<User> users;

    static{
        users = new ArrayList<>();
        users.add(new User(1,"testName1","testId1", "1234"));
        users.add(new User(2,"testName2","testId2", "1234"));
        users.add(new User(3,"testName3","testId3", "1234"));
        users.add(new User(4,"testName4","testId4", "1234"));
        users.add(new User(5,"testName5","testId5", "1234"));
    }

    // Select all users
    public List<User> getAllUsers(){
        return users;
    }

    // Select one user by userId
    public User getUserByUserId(String userId) {
        return users
                .stream().filter(user->user.getUserId().equals(userId))
                .findAny().orElse(new User(-1, "", "", ""));
    }

    // Insert user
    public User insertUser(User user) {
        users.add(user);
        return user;
    }

    // Modify user
    public void updateUser(String userId, User user) {
        users.stream().filter(curUser-> curUser.getUserId().equals(userId))
                .findAny().orElse(new User(-1, "", "", ""))
                .setUserName(user.getUserName());
    }

    // Delete user
    public void deleteUser(String userId) {
        users.removeIf(user -> user.getUserId().equals(userId));
    }
}
