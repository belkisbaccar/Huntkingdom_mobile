/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui.login;

import Publicite.PubliciteService;
import Publicite.Publicite_entite;
import Publicite.chasseEntite;
import com.codename1.components.ImageViewer;
import com.codename1.components.MediaPlayer;
import com.codename1.components.SpanLabel;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Stroke;
import com.codename1.ui.Tabs;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.DefaultLookAndFeel;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.UIBuilder;
import com.mycompany.myapp.MyApplication;
import static com.mycompany.myapp.MyApplication.theme;
import com.mycompany.myapp.entities.Reclamation_Reponse.Reponse;
import com.mycompany.myapp.gui.front.annonce;
import com.mycompany.myapp.gui.front.chasse;
import com.mycompany.myapp.gui.front.ecommerce;
import com.mycompany.myapp.gui.front.event;
import com.mycompany.myapp.gui.front.newsletter;
import com.mycompany.myapp.gui.front.profil;
import com.mycompany.myapp.gui.front.reclamation;
import com.mycompany.myapp.services.UserSession;
import com.mycompany.myapp.services.reponseService;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;





/**
 *
 * @author hazem
 */
public class acceuil extends Form {
    Form current;
        MediaPlayer m;

    public MediaPlayer getM() {
        return m;
    }

    public void setM(MediaPlayer m) {
        this.m = m;
    }
    
    
    public void showVid() throws IOException{
        PubliciteService sp = new PubliciteService();
           List<Publicite_entite> tasks;
          tasks=sp.getPub();
         for(int i=0; i<tasks.size(); i++){
          String ext=tasks.get(i).getImage().substring(tasks.get(i).getImage().lastIndexOf(".") + 1);
          if(ext.equals("mp4")) {
   
           String file = "file://C:/wamp64/www/hunt/groupee/symfony2/web/imagesPub/"+tasks.get(i).getImage();
         Media video = MediaManager.createMedia(file, true);
         
         Dialog d = new Dialog();
         Button bt = new Button("close");
          Button bt1 = new Button("like");
         bt.addActionListener((evt) -> {
             video.pause();
            d.dispose();
         });
         d.add(video.getVideoComponent());
         video.play();
         
         d.add(bt);
         d.add(bt1);
         
         d.show();
          }
         }
    }
    
     public acceuil(Form previous)
     {Tabs t = new Tabs();
t.hideTabs();
Style but=t.getAllStyles();
but.setBorder(RoundRectBorder.create().
        strokeColor(0xCD853F).
        strokeOpacity(120)
        );
but.setBgColor(0xCD853F);
but.setFgColor(0x000000);
but.setBgTransparency(255);

       
          but.setMargin(Component.LEFT,150);  
           but.setMargin(Component.RIGHT,150); 










         
         PubliciteService sp = new PubliciteService();
        
         UserSession n = UserSession.getInstance();
         System.out.println(n);
    
          if(!sp.countAllNews().equals("0") && sp.getNews(n.getId()))
          {getToolbar().addMaterialCommandToRightBar(sp.countAllNews(), 
                FontImage.MATERIAL_NEW_RELEASES, ev->{new newsletter(current).show();});
                  
          }
          List<Publicite_entite> tasks;
          
          tasks=sp.getPub();
         for(int i=0; i<tasks.size(); i++){
          String ext=tasks.get(i).getImage().substring(tasks.get(i).getImage().lastIndexOf(".") + 1);             
         if(!ext.equals("mp4")){
             String path ="http://127.0.0.1/hunt/groupee/symfony2/web/imagesPub/"+tasks.get(i).getImage()+""; 
               EncodedImage encImg
                = EncodedImage.createFromImage(theme.getImage("logohunt.png").scaled(150,150), false);
         
              URLImage  imgUrl = URLImage.createToStorage(encImg,tasks.get(i).getImage(),path);
              ImageViewer v1 =new ImageViewer();
               v1.setImage(imgUrl);
               Container container2 = new Container(BoxLayout.y());
                Button like = new Button("like");
                FontImage.setMaterialIcon(like, FontImage.MATERIAL_THUMB_UP, 5);
              if(sp.getPubAimer(tasks.get(i).getId(),n.getId()))
              {
              like.setText("dislike");
               FontImage.setMaterialIcon(like, FontImage.MATERIAL_THUMB_DOWN, 5);
              
              }  int idPub= tasks.get(i).getId();
                like.addActionListener(new ActionListener() {
                    
                 @Override
                 public void actionPerformed(ActionEvent evt) {
                     if (like.getText().equals("like"))
                     { sp.ajoutPubAimer(idPub,n.getId());
                       like.setText("dislike");
               FontImage.setMaterialIcon(like, FontImage.MATERIAL_THUMB_DOWN, 5);
                     
                     } 
                     else {
                         sp.supprimerPubAimer(idPub,n.getId());
                              like.setText("like");
                              
               FontImage.setMaterialIcon(like, FontImage.MATERIAL_THUMB_UP, 5);
                     }
                 }
             });
                container2.addAll(v1,like);
             Container container1 = new Container(BoxLayout.xCenter());
             container1.add(container2);
             
t.addTab("Tab1", container1);

          }
         
         }
     current=this;
        setTitle("Acceuil");
        setLayout(BoxLayout.y());
Style loginStyle= getAllStyles();


        loginStyle.setBgImage(MyApplication.theme.getImage("2.jpg")); 
  /**************************************************************************************************/ 
  

ImageViewer Logo=new ImageViewer(MyApplication.theme.getImage("logohunt.png"));

  /**************************************************************************************************/ 
   Button btnval = new Button("Ecommerce");
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
    Button btnval1 = new Button("Evenement");
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

          butStyle1.setMargin(Component.TOP,1);  
              
          
          butStyle1.setMargin(Component.LEFT,10);  
           butStyle1.setMargin(Component.RIGHT,10); 
     /**************************************************************************************************/ 
               Button btnval2 = new Button("Annonce");
Style butStyle2=btnval2.getAllStyles();
butStyle2.setBorder(RoundRectBorder.create().
        strokeColor(0xCD853F).
        strokeOpacity(120)
        );
butStyle2.setBgColor(0xCD853F);
butStyle2.setFgColor(0x000000);
butStyle2.setBgTransparency(255);
butStyle2.setMarginUnit(Style.UNIT_TYPE_DIPS);
butStyle2.setMargin(Component.BOTTOM, 3);       

          butStyle2.setMargin(Component.TOP,1);  
              
          
          butStyle2.setMargin(Component.LEFT,10);  
           butStyle2.setMargin(Component.RIGHT,10);
    /**************************************************************************************************/ 
        Button btnval3 = new Button("Reclamation");
Style butStyle3=btnval3.getAllStyles();
butStyle3.setBorder(RoundRectBorder.create().
        strokeColor(0xCD853F).
        strokeOpacity(120)
        );
butStyle3.setBgColor(0xCD853F);
butStyle3.setFgColor(0x000000);
butStyle3.setBgTransparency(255);
butStyle3.setMarginUnit(Style.UNIT_TYPE_DIPS);
butStyle3.setMargin(Component.BOTTOM, 3);       

          butStyle3.setMargin(Component.TOP,1);  
              
          
          butStyle3.setMargin(Component.LEFT,10);  
           butStyle3.setMargin(Component.RIGHT,10); 
    /**************************************************************************************************/ 
               Button btnval4 = new Button("Chasse");
Style butStyle4=btnval4.getAllStyles();
butStyle4.setBorder(RoundRectBorder.create().
        strokeColor(0xCD853F).
        strokeOpacity(120)
        );
butStyle4.setBgColor(0xCD853F);
butStyle4.setFgColor(0x000000);
butStyle4.setBgTransparency(255);
butStyle4.setMarginUnit(Style.UNIT_TYPE_DIPS);
butStyle4.setMargin(Component.BOTTOM, 3);       

          butStyle4.setMargin(Component.TOP,1);  
              
          
          butStyle4.setMargin(Component.LEFT,10);  
           butStyle4.setMargin(Component.RIGHT,10);
               /**************************************************************************************************/ 
               Button btnval8 = new Button("Newsletter");
Style butStyle48=btnval8.getAllStyles();
butStyle48.setBorder(RoundRectBorder.create().
        strokeColor(0xCD853F).
        strokeOpacity(120)
        );
butStyle48.setBgColor(0xCD853F);
butStyle48.setFgColor(0x000000);
butStyle48.setBgTransparency(255);
butStyle48.setMarginUnit(Style.UNIT_TYPE_DIPS);
butStyle48.setMargin(Component.BOTTOM, 3);       

          butStyle48.setMargin(Component.TOP,1);  
              
          
          butStyle48.setMargin(Component.LEFT,10);  
           butStyle48.setMargin(Component.RIGHT,10);
           btnval8.addActionListener((evt) -> {
               new newsletter(current).show();
               
           });
             /**************************************************************************************************/ 
           Button btnval5 = new Button("Deconnexion");
Style butStyle5=btnval5.getAllStyles();
butStyle5.setBorder(RoundRectBorder.create().
        strokeColor(0xCD853F).
        strokeOpacity(120)
        );
butStyle5.setBgColor(0xCD853F);
butStyle5.setFgColor(0x000000);
butStyle5.setBgTransparency(255);
butStyle5.setMarginUnit(Style.UNIT_TYPE_DIPS);
butStyle5.setMargin(Component.BOTTOM, 3);       

          butStyle5.setMargin(Component.TOP,1);  
              
          
          butStyle5.setMargin(Component.LEFT,10);  
           butStyle5.setMargin(Component.RIGHT,10); 
      /**************************************************************************************************/        
               addAll(Logo,t,btnval,btnval1,btnval2,btnval3,btnval4,btnval8,btnval5);


               
  /**************************************************************************************************/             
               
               btnval.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               new ecommerce(current).show(); 
            }
               });
               btnval1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               new event(current).show(); 
            }
               });
               btnval2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               new annonce(current).show(); 
            }
               });
               btnval3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               new reclamation(current).show(); 
            }
               });
               btnval4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               new chasse(current).show(); 
            }
               });
                 btnval5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               UserSession.getInstance().cleanUserSession();
                new login().show();
            }
               });
               
       

                       // add(Logo3);
               
                getToolbar().addCommandToOverflowMenu("Exit",
            null, ev->{Display.getInstance().exitApplication();});
        
          
          
          ArrayList<Reponse> newra=new ArrayList<>();
 newra= reponseService.getInstance().getNewReponses(n.getId());
 int a=newra.size();
        System.out.println("nb : "+a);
        //System.out.println("list "+newra);
        if(a!=0){
        
        LocalNotification not = new LocalNotification();
        not.setId("demo-notification");
        not.setAlertBody("Vous venez d'avoir "+a+" nouvelle réponse");
        not.setAlertTitle("Réponses");
        not.setAlertSound("/notification_sound_bells.mp3"); //file name must begin with notification_sound


        Display.getInstance().scheduleLocalNotification(
                not,
                System.currentTimeMillis() + 10 , // fire date/time
                LocalNotification.REPEAT_MINUTE  // Whether to repeat and what frequency
        );
      
        }
          
          

     }
}

