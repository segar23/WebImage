/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Session;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Garces
 */
@ManagedBean
@RequestScoped
public class ImagesView {
    private List<String> images;
     
    @PostConstruct
    public void init() {
        File folder = new File("/Users/Garces/NetBeansProjects/WebImage/src/main/webapp/resources/" + Session.USERNAME);
        if (!folder.exists()) folder.mkdir();
        File[] listOfFiles = folder.listFiles();
        int pos;
        String name;
        images = new ArrayList<>();
        
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                pos = listOfFile.getPath().lastIndexOf('/');
                name = listOfFile.getPath().substring(++pos, listOfFile.getPath().length());
                if(!name.startsWith("."))
                    images.add(Session.USERNAME + "/" + name);
            }
        }
    }
 
    public List<String> getImages() {
        return images;
    }
}
