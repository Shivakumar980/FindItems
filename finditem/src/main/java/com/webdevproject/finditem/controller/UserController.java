package com.webdevproject.finditem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webdevproject.finditem.exception.ExistUserException;
import com.webdevproject.finditem.model.AuthenticationRequest;
import com.webdevproject.finditem.model.User;
import com.webdevproject.finditem.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/rs")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;



    @PostMapping("/signup")
    public String clientSignup(@RequestBody User user) throws ExistUserException {
        try {
            Integer updatedCount = userService.clientSignup(user);
            System.out.println("updatedCount "+updatedCount);
            if(updatedCount ==1)
            return "User Added";
        } catch (ExistUserException e) {
            return e.getMessage();
        }
        return "user add error";
    }
    @PostMapping("/authenticate")
    public Integer signUpUser(@RequestBody AuthenticationRequest authenticateReq) {
    
            log.info("Authenticate User");
            Integer b = userService.authenticate(authenticateReq.getLoginId(), authenticateReq.getPassword());
            System.out.println(b);
            return b;
    
    }


    @GetMapping("/users/all")
    public List<User> getAllUsers() {

          
       return  userService.getAllUsers();

    } 


    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable("userId") String id) {
        
        return userService.getUserById(id);
    }


    @PatchMapping("/userupdate")
    public String updateUser(@RequestBody User user) {
        System.out.println(user.getId());
      
   Integer updated =  userService.updateUser(user);
        if(updated == 1){
            return "User Updated Successfully";
        }

        return "User not updated Successfully";

} 

}


