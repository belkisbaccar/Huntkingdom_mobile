/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui.front;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import com.mycompany.myapp.MyApplication;
import com.mycompany.myapp.gui.login.acceuil;
import com.mycompany.myapp.gui.front.login;

/**
 *
 * @author hazem
 */
public class menuevent extends Form {
    Form current;
    
    
     public menuevent(Form previous)
     {
     current=this;
        setTitle("Menu Evenement");
        setLayout(BoxLayout.y());
        getToolbar().addMaterialCommandToLeftBar("back", 
                FontImage.MATERIAL_BACKUP, ev->{new acceuil(current).show();});
          getToolbar().addCommandToOverflowMenu("Exit",
            null, ev->{Display.getInstance().exitApplication();});
Style loginStyle= getAllStyles();

        loginStyle.setBgImage(MyApplication.theme.getImage("hunt.jpg")); 
  /**************************************************************************************************/       

ImageViewer Logo=new ImageViewer(MyApplication.theme.getImage("logohunt.png"));

  /**************************************************************************************************/ 
   Button btnval = new Button("Vos Evenement Ajoutés");
Style butStyle=btnval.getAllStyles();
butStyle.setBorder(RoundRectBorder.create().
        strokeColor(0xCD853F).
        strokeOpacity(120)
        );
butStyle.setBgColor(0xCD853F);
butStyle.setFgColor(0x000000);
butStyle.setBgTransparency(255);
butStyle.setMarginUnit(Style.UNIT_TYPE_DIPS);
butStyle.setMargin(Component.BOTTOM, 3);       

          butStyle.setMargin(Component.TOP,10);  
              
          
          butStyle.setMargin(Component.LEFT,10);  
           butStyle.setMargin(Component.RIGHT,10); 
 /**************************************************************************************************/        
    Button btnval1 = new Button("Les Evenement");
Style butStyle1=btnval1.getAllStyles();
butStyle1.setBorder(RoundRectBorder.create().
        strokeColor(0xCD853F).
        strokeOpacity(120)
        );
butStyle1.setBgColor(0xCD853F);
butStyle1.setFgColor(0x000000);
butStyle1.setBgTransparency(255);
butStyle1.setMarginUnit(Style.UNIT_TYPE_DIPS);
butStyle1.setMargin(Component.BOTTOM, 3);       

          butStyle1.setMargin(Component.TOP,5);  
              
          
          butStyle1.setMargin(Component.LEFT,10);  
           butStyle1.setMargin(Component.RIGHT,10); 
     /**************************************************************************************************/ 
  
   
      /**************************************************************************************************/        
               addAll(Logo,btnval,btnval1);
               
  /**************************************************************************************************/             
               
               btnval.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               new crudevent(current).show(); 
            }
               });
               btnval1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               new event(current).show(); 
            }
               });
              
             
               
/**************************************************/
               
               
                        //Container cnt1=new Container(new FlowLayout(Container.CENTER));

                       // add(Logo3);
               
                getToolbar().addCommandToOverflowMenu("Exit",
            null, ev->{Display.getInstance().exitApplication();});
        
          
          
          
          
          

     }
}