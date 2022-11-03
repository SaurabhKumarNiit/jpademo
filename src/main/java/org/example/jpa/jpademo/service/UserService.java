package org.example.jpa.jpademo.service;

import org.example.jpa.jpademo.domain.User;

import java.util.List;

public interface UserService {
    public User addUser(User user);
    public List<User> gerAllUser();
    public User updateUser(User user,String email);
    public boolean deleteUserByEmail(String email);

    public List<User> getUserByName(String userName);
}
