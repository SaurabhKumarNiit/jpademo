package org.example.jpa.jpademo.service;

import org.example.jpa.jpademo.domain.User;
import org.example.jpa.jpademo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    public UserServiceImpl (UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> gerAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user, String email) {

        Optional<User> optionalUser=userRepository.findById(email);
        if(optionalUser.isEmpty()){
            return null;
        }

        User existingUser=optionalUser.get();
        if(user.getUserName()!=null){
            existingUser.setUserName(user.getUserName());
        }

        if(user.getUserPassword()!=null){
            existingUser.setUserPassword(user.getUserPassword());
        }

        return userRepository.save(existingUser);
    }

    @Override
    public boolean deleteUserByEmail(String email) {
        userRepository.deleteById(email);
        return true;
    }

    @Override
    public List<User> getUserByName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
