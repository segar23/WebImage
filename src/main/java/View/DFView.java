/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Garces
 */
@ManagedBean (name = "dfView")
public class DFView {
    
    public void viewNewUser()
    {
        Map<String,Object> options = new HashMap<>();
        options.put("resizable", false);
        RequestContext.getCurrentInstance().openDialog("newUser", options, null);
    }
}
