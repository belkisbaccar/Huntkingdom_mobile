/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;



//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class UserSession {
    private static UserSession instance;
 
    private String userName; 
    private int id;

   
   

    public void setId(String photo) {
        this.id =id;
    }

    public int getId() {
        return id;
    }

   

   
    public UserSession(String userName) {
        this.userName = userName;
    }

    public static UserSession getInstance() {
        return instance;
    }

    public String getUserName() {
        return userName;
    }

    public static void setInstance(UserSession instance) {
        UserSession.instance = instance; 
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserSession(String userName, int id) {
        this.userName = userName;
        this.id = id;
        
    }

    @Override
    public String toString() {
        return "UserSession{" + "userName=" + userName + ", id=" + id + '}';
    }

    
    
    public static UserSession getInstace(String userName, int id) {
        if(instance == null) {
         instance = new UserSession(userName,id);
        }
        return instance;
    }   
    
     public void cleanUserSession() {
        userName = "";
        id = 0;//7 or null
      instance = null;
        
       // or null
    }  
     
     
     
     
    
      
      
      
}
