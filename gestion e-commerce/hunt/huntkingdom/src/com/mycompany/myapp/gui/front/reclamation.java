/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui.front;

import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.gui.login.acceuil;

/**
 *
 * @author hazem
 */
public class reclamation extends Form {
     Form current;

    public reclamation(Form current) {
        this.current = current;
        setTitle("Reclamation");
        setLayout(BoxLayout.y());
    getToolbar().addMaterialCommandToLeftBar("back", 
                FontImage.MATERIAL_BACKUP, ev->{new acceuil(current).show();});
     getToolbar().addCommandToOverflowMenu("Exit",
            null, ev->{Display.getInstance().exitApplication();});
    }
    
}
