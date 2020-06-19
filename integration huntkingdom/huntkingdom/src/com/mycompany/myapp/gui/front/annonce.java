/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui.front;

import com.codename1.components.ImageViewer;
import com.codename1.location.Location;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import com.mycompany.myapp.MyApplication;
import com.mycompany.myapp.entities.Annonces.Annonce;
import com.mycompany.myapp.entities.Reclamation_Reponse.Reponse;
import com.mycompany.myapp.gui.Annonces.ajouter_annonce;
import com.mycompany.myapp.gui.Annonces.consulter_annonce;
import com.mycompany.myapp.gui.Annonces.consulter_annonces;
import com.mycompany.myapp.gui.Reclamation_Reponse.afficher_reclamations;
import com.mycompany.myapp.gui.Reclamation_Reponse.afiicher_reponses;
import com.mycompany.myapp.gui.login.acceuil;
import com.mycompany.myapp.services.UserSession;
import com.mycompany.myapp.services.annonceService;
import com.mycompany.myapp.services.reponseService;
import java.util.ArrayList;

/**
 *
 * @author abdelhamid
 */
public class annonce extends Form {
  Form current;
    
    public annonce(Form previous) {
      
        setTitle("Annonce");
       
         
          UserSession n = UserSession.getInstance();
    
        this.current = current;
      
        setLayout(BoxLayout.y());

        Style reclamation = getAllStyles();
    
        reclamation.setBgImage(MyApplication.theme.getImage("2.jpg")); 
        
        /**
         * ***********************************************************************************************
         */

        ImageViewer Logo = new ImageViewer(MyApplication.theme.getImage("logohunt.png"));
        Location loc = null;

        /**
         * ***********************************************************************************************
         */
        
     
        Button ajouter = new Button("Ajouter annonce ");
        Style butStyle = ajouter.getAllStyles();
        butStyle.setBorder(RoundRectBorder.create().
                strokeColor(0xCD853F).
                strokeOpacity(120)
        );
        butStyle.setBgColor(0xCD853F);
        butStyle.setFgColor(0x000000);
        butStyle.setBgTransparency(255);
        butStyle.setMarginUnit(Style.UNIT_TYPE_DIPS);
        butStyle.setMargin(Component.BOTTOM, 3);

        butStyle.setMargin(Component.TOP, 10);

        butStyle.setMargin(Component.LEFT, 10);
        butStyle.setMargin(Component.RIGHT, 10);

        Button consulter = new Button("Consulter mes annonces");
        Style butStyle5 = consulter.getAllStyles();
        butStyle5.setBorder(RoundRectBorder.create().
                strokeColor(0xCD853F).
                strokeOpacity(120)
        );
        butStyle5.setBgColor(0xCD853F);
        butStyle5.setFgColor(0x000000);
        butStyle5.setBgTransparency(255);
        butStyle5.setMarginUnit(Style.UNIT_TYPE_DIPS);
        butStyle5.setMargin(Component.BOTTOM, 3);

        butStyle5.setMargin(Component.TOP, 1);

        butStyle5.setMargin(Component.LEFT, 10);
        butStyle5.setMargin(Component.RIGHT, 10);
        
        

        Button annonces = new Button("Consulter toutes les annonces");
        Style repStyle5 = annonces.getAllStyles();
        repStyle5.setBorder(RoundRectBorder.create().
                strokeColor(0xCD853F).
                strokeOpacity(120)
        );
        repStyle5.setBgColor(0xCD853F);
        repStyle5.setFgColor(0x000000);
        repStyle5.setBgTransparency(255);
        repStyle5.setMarginUnit(Style.UNIT_TYPE_DIPS);
        repStyle5.setMargin(Component.BOTTOM, 3);

        repStyle5.setMargin(Component.TOP, 1);

        repStyle5.setMargin(Component.LEFT, 10);
        repStyle5.setMargin(Component.RIGHT, 10);

       
        ajouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
              new ajouter_annonce(current).show();
            }
        });
        consulter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new consulter_annonces(current).show();
            }
        });
        
        
        annonces.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               new consulter_annonce(current).show();
            }
        });
        getToolbar().addMaterialCommandToLeftBar("back",
                FontImage.MATERIAL_BACKUP, ev -> {
                 new acceuil(current).show();
                });
        getToolbar().addCommandToOverflowMenu("Exit",
                null, ev -> {
                    Display.getInstance().exitApplication();
                });
        
        
        /*
         ArrayList<Annonce> newra=new ArrayList<>();
 newra= annonceService.getInstance().getAllAnnonces(n.getId());
 int a=newra.size();
        System.out.println("nb : "+a);
       
        Button notif = new Button(FontImage.MATERIAL_NOTIFICATIONS);
        //System.out.println("list "+newra);
        if(a!=0){
        
        notif.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                 Dialog.show("Notifications", "Vous avez de nouvelles réclamations pour aujourd'hui", new Command("OK"));
            }
        });
        
        add(notif);
        }
         addAll(Logo, consulter,reponses);
    }
*/
        addAll(Logo,ajouter,consulter,annonces);
    }
    
}

