/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.MongoDatabase;
import java.util.List;

/**
 *
 * @author Garces
 */
public class User {
    private String username;
    private String password;
    private List<String> pictures;
    
    public void createUser()
    {
        try
        {
            MongoDatabase mongo = new MongoDatabase();
            mongo.insertUser(username, password);
        } 
        catch (Exception e)
        {
        }
    }

    public String getUser() {
        return username;
    }

    public String getPass() {
        return password;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setUser(String user) {
        this.username = user;
    }

    public void setPass(String pass) {
        this.password = pass;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }
    
    
}
