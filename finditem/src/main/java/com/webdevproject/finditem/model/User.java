package com.webdevproject.finditem.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class User {
    private Integer id;
    private String name;
    private String address;
    private String userName;
    private String password;
    private String pincode;


   // No-arg constructor    
   public User() {
   }

   // All-args constructor
   public User(Integer id, String name, String address, String userName, String password, String pincode) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.userName = userName;
    this.password = password;
    this.pincode = pincode;
}

// Getters and setters
public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getAddress() {
    return address;
}

public void setAddress(String address) {
    this.address = address;
}

public String getUserName() {
    return userName;
}

public void setUserName(String userName) {
    this.userName = userName;
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}

public String getPincode() {
    return pincode;
}

public void setPincode(String pincode) {
    this.pincode = pincode;
}


   // toString method


   @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", pincode='" + pincode + '\'' +
                '}';
    }

   
}

