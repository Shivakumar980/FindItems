package com.webdevproject.finditem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webdevproject.finditem.exception.ExistUserException;
import com.webdevproject.finditem.model.User;
import com.webdevproject.finditem.repository.UserRepo;

@Service
public class UserService {
   
    
    @Autowired
    UserRepo userRepo;
    
    public  List<User>  getAllUsers()  {

        List<User> completeUsers = userRepo.getAllUsers();

        return completeUsers;

}

    public Integer clientSignup(User user) throws ExistUserException {


        return userRepo.addUser(user);
    }

    public User getUserById(String userId) {
        User user = userRepo.findUserById(userId);
        return user;
    }

   

    public Integer updateUser(User user) {
        return userRepo.updateUser(user);
    }

    public Integer authenticate(String  userName, String password) {
        if(userRepo.authenticate(userName,password)==1){ 
           Integer id = userRepo.getUserId(userName, password);
        return id;
        }
        return 0;
      
   }

}
