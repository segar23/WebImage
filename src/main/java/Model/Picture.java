/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Session;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Garces
 */
@ManagedBean
@SessionScoped
public class Picture {
    private UploadedFile file;

    public Picture() 
    {
        System.out.println("Constructor");
    }
    
    
 
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
     
    @SuppressWarnings({"ConvertToTryWithResources", "CallToPrintStackTrace"})
    public void handleFileUpload(FileUploadEvent event) {
        try
        {            
            File targetFolder = new File("/Users/Garces/NetBeansProjects/WebImage/src/main/webapp/resources/" + Session.USERNAME);
            InputStream inputStream = event.getFile().getInputstream();
            OutputStream out = new FileOutputStream(new File(targetFolder,
                event.getFile().getFileName()));
            int read;
            byte[] bytes = new byte[1024];
            
            while((read = inputStream.read(bytes)) != -1)
            {
                out.write(bytes, 0, read);
            }
            inputStream.close();
            out.flush();
            out.close();
            
            FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
