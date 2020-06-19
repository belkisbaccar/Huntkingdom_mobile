/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui.front;

import Produit.produit_entities;
import com.mycompany.myapp.services.PubliciteService;
import Publicite.chasseEntite;
import Publicite.newsletter_entite;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.myapp.MyApplication;
import static com.mycompany.myapp.MyApplication.theme;
import com.mycompany.myapp.gui.login.acceuil;
import java.io.IOException;
import java.util.List;




/**
 *
 * @author walid
 */
public class newsConsulter extends Form{
    Form current;
     public newsConsulter(Form previous, newsletter_entite n) {
      current=this;
      Toolbar.setGlobalToolbar(true);
Style s = UIManager.getInstance().getComponentStyle("Title");
      TextField searchField = new TextField("", "Search");
      TextField searchField1 = new TextField("", "Search");// <1>
searchField.getHintLabel().setUIID("Title");
searchField.setUIID("Title");
searchField.getAllStyles().setAlignment(Component.LEFT);
searchField1.getHintLabel().setUIID("Title");
searchField1.setUIID("Title");
searchField1.getAllStyles().setAlignment(Component.LEFT);

Tabs ttt = new Tabs();
ttt.hideTabs();
      
      
      
     
        setLayout(BoxLayout.y());
         Style loginStyle= getAllStyles();        
        loginStyle.setBgImage(MyApplication.theme.getImage("2.jpg")); 
         System.out.println(n);
         getToolbar().addMaterialCommandToLeftBar("back", 
                FontImage.MATERIAL_ARROW_BACK, ev->{new newsletter(current).show();});
         
          getToolbar().addCommandToOverflowMenu("Exit",
            null, ev->{Display.getInstance().exitApplication();});
          Label l = new Label("Nouvelles du jour :");
          Label l1 = new Label();
          Label l2 = new Label();
          Label l3 = new Label();
          PubliciteService ps= new PubliciteService();
          String countP = ps.countPNews();
          String countE= ps.countENews();
          String countC= ps.countCNews();
          Container c = new Container(BoxLayout.yCenter());
           Container Chasse= new Container(BoxLayout.yCenter());
           Container Produit= new Container(BoxLayout.yCenter());
         
           
          searchField.addDataChangeListener((i1, i2) -> { // <2>
    String t = searchField.getText();
    if(t.length() < 1) {
        for(Component cmp : Chasse) {
            cmp.setHidden(false);
            cmp.setVisible(true);
        }
    } else {
        t = t.toLowerCase();
        for(Component cmp : Chasse) {
            String val = null;
            if(cmp instanceof Label) {
                val = ((Label)cmp).getText();
            } else {
                if(cmp instanceof TextArea) {
                    val = ((TextArea)cmp).getText();
                } else {
                    val = (String)cmp.getPropertyValue("text");
                }
            }
            boolean show = val != null && val.toLowerCase().indexOf(t) > -1;
            cmp.setHidden(!show); // <3>
            cmp.setVisible(show);
        }
    }
    getContentPane().animateLayout(250);
});
                  searchField1.addDataChangeListener((i1, i2) -> { // <2>
    String t = searchField1.getText();
    if(t.length() < 1) {
        for(Component cmp : Produit) {
            cmp.setHidden(false);
            cmp.setVisible(true);
        }
    } else {
        t = t.toLowerCase();
        for(Component cmp : Produit) {
            String val = null;
            if(cmp instanceof Label) {
                val = ((Label)cmp).getText();
            } else {
                if(cmp instanceof TextArea) {
                    val = ((TextArea)cmp).getText();
                } else {
                    val = (String)cmp.getPropertyValue("text");
                }
            }
            boolean show = val != null && val.toLowerCase().indexOf(t) > -1;
            cmp.setHidden(!show); // <3>
            cmp.setVisible(show);
        }
    }
    getContentPane().animateLayout(250);
});


             Style butStyle21=c.getAllStyles();
butStyle21.setBorder(RoundRectBorder.create().
        strokeColor(0xCD853F).
        strokeOpacity(120)
        );
butStyle21.setBgColor(0xFFFFFF);
butStyle21.setFgColor(0x000000);
butStyle21.setBgTransparency(255);
butStyle21.setMarginUnit(Style.UNIT_TYPE_DIPS);
butStyle21.setMargin(Component.BOTTOM, 3);       

          butStyle21.setMargin(Component.TOP,10);  
              
          
          butStyle21.setMargin(Component.LEFT,1);  
           butStyle21.setMargin(Component.RIGHT,1);
           if(n.getEtat()==1)
           { if(countP.equals("0"))
                   l1.setText("Nouvelles sur les promotions : pas de nouvelle ");
               else 
           {l1.setText("Nouvelles sur les promotions : "+countP+" ajoutee");
           Produit.add(searchField1);
            PubliciteService sp = new PubliciteService();
             Style butStyle2=Produit.getAllStyles();
butStyle2.setBorder(RoundRectBorder.create().
        strokeColor(0xCD853F).
        strokeOpacity(120)
        );
butStyle2.setBgColor(0xFFFFFF);
butStyle2.setFgColor(0x000000);
butStyle2.setBgTransparency(255);
butStyle2.setMarginUnit(Style.UNIT_TYPE_DIPS);
             butStyle2.setMargin(Component.TOP,5);  
             butStyle2.setMargin(Component.LEFT,9);  
           butStyle2.setMargin(Component.RIGHT,9);
            List<produit_entities> produit;
           produit=sp.getPromoToday();
              for(int i=0; i<produit.size(); i++){
                  SpanLabel animal= new SpanLabel();
         if(produit.get(i).getNom().length()>4)
                animal = new SpanLabel("Nom : "+produit.get(i).getNom()+
                        "        Prix :"+produit.get(i).getPrix()+"                  "
                        +"Prix Promo :"+produit.get(i).getPrix_promo());
            else
             animal = new SpanLabel("Nom : "+produit.get(i).getNom()+
                        "           Prix :"+produit.get(i).getPrix()+"                  "
                        +"      Prix Promo :"+produit.get(i).getPrix_promo());
             
                  String path ="http://localhost/hunt/groupee/symfony2/web/uploads/images/"+produit.get(i).getImage()+""; 
               EncodedImage encImg
                = EncodedImage.createFromImage(theme.getImage("logohunt.png").scaled(150,150), false);
         
              URLImage  imgUrl = URLImage.createToStorage(encImg,produit.get(i).getImage(),path);
              animal.setIcon(imgUrl);
               
              

            Produit.addAll(animal);
           
            }
               ttt.addTab("Promotion",Produit);
           }
         
               
           
           if(countE.equals("0"))
                   l2.setText("Nouvelles sur les events : pas de nouvelle ");
               else 
                   l2.setText("Nouvelles sur les events : "+countE+" ajoutee");
             if(countC.equals("0"))
                   l3.setText("Nouvelles sur les chasses : pas de nouvelle ");
               else 
             { l3.setText("Nouvelles sur les chasses : "+countC+" ajoutee");
               Chasse.add(searchField);
             PubliciteService sp = new PubliciteService();
            
             Style butStyle2=Chasse.getAllStyles();
butStyle2.setBorder(RoundRectBorder.create().
        strokeColor(0xCD853F).
        strokeOpacity(120)
        );
butStyle2.setBgColor(0xFFFFFF);
butStyle2.setFgColor(0x000000);
butStyle2.setBgTransparency(255);
butStyle2.setMarginUnit(Style.UNIT_TYPE_DIPS);
             butStyle2.setMargin(Component.TOP,5);  
             butStyle2.setMargin(Component.LEFT,9);  
           butStyle2.setMargin(Component.RIGHT,9);
             List<chasseEntite> chasse;
           chasse=sp.getChasseToday();
            for(int i=0; i<chasse.size(); i++){
         
                SpanLabel animal = new SpanLabel("Animal : "+chasse.get(i).getAnimal()+"                      Region : "+chasse.get(i).getRegion()+"                  "
                        + "date debut :"+chasse.get(i).getDate_debut()+"       date fin :"+chasse.get(i).getDate_fin()+"            type : "+chasse.get(i).getType()+"  ");
             

            Chasse.addAll(animal);
           
            }
             ttt.addTab("Chasse",Chasse);
             }
               c.add(l);
               c.addAll(l1,l2,l3);
               
      
               add(c);
               
               
               add(ttt);
               
           }
           
           
           if(n.getEtat()==2)
           { if(countP.equals("0"))
                   l1.setText("Nouvelles sur les promotions : pas de nouvelle ");
               else 
           { l1.setText("Nouvelles sur les promotions : "+countP+" ajoutee");
           l1.setText("Nouvelles sur les promotions : "+countP+" ajoutee");
           Produit.add(searchField1);
            PubliciteService sp = new PubliciteService();
             Style butStyle2=Produit.getAllStyles();
butStyle2.setBorder(RoundRectBorder.create().
        strokeColor(0xCD853F).
        strokeOpacity(120)
        );
butStyle2.setBgColor(0xFFFFFF);
butStyle2.setFgColor(0x000000);
butStyle2.setBgTransparency(255);
butStyle2.setMarginUnit(Style.UNIT_TYPE_DIPS);
             butStyle2.setMargin(Component.TOP,5);  
             butStyle2.setMargin(Component.LEFT,9);  
           butStyle2.setMargin(Component.RIGHT,9);
            List<produit_entities> produit;
           produit=sp.getPromoToday();
              for(int i=0; i<produit.size(); i++){
                  SpanLabel animal= new SpanLabel();
         if(produit.get(i).getNom().length()>4)
                animal = new SpanLabel("Nom : "+produit.get(i).getNom()+
                        "        Prix :"+produit.get(i).getPrix()+"                  "
                        +"Prix Promo :"+produit.get(i).getPrix_promo());
            else
             animal = new SpanLabel("Nom : "+produit.get(i).getNom()+
                        "           Prix :"+produit.get(i).getPrix()+"                  "
                        +"      Prix Promo :"+produit.get(i).getPrix_promo());
             
                  String path ="http://localhost/hunt/groupee/symfony2/web/uploads/images/"+produit.get(i).getImage()+""; 
               EncodedImage encImg
                = EncodedImage.createFromImage(theme.getImage("logohunt.png").scaled(150,150), false);
         
              URLImage  imgUrl = URLImage.createToStorage(encImg,produit.get(i).getImage(),path);
              animal.setIcon(imgUrl);
               
              

            Produit.addAll(animal);
           
            }
               ttt.addTab("Promotion",Produit);
           }
               c.add(l);
               c.add(l1);
              
               add(c);
               add(ttt);
           }
           if(n.getEtat()==3)
           { 
           if(countE.equals("0"))
                   l2.setText("Nouvelles sur les events : pas de nouvelle ");
               else 
                   l2.setText("Nouvelles sur les events : "+countE+" ajoutee");
         
               c.add(l);
               c.add(l2);

               add(c);
           }
           
            if(n.getEtat()==4)
           { if(countP.equals("0"))
                   l1.setText("Nouvelles sur les promotions : pas de nouvelle ");
               else 
           {   l1.setText("Nouvelles sur les promotions : "+countP+" ajoutee");
           l1.setText("Nouvelles sur les promotions : "+countP+" ajoutee");
           l1.setText("Nouvelles sur les promotions : "+countP+" ajoutee");
           Produit.add(searchField1);
            PubliciteService sp = new PubliciteService();
             Style butStyle2=Produit.getAllStyles();
butStyle2.setBorder(RoundRectBorder.create().
        strokeColor(0xCD853F).
        strokeOpacity(120)
        );
butStyle2.setBgColor(0xFFFFFF);
butStyle2.setFgColor(0x000000);
butStyle2.setBgTransparency(255);
butStyle2.setMarginUnit(Style.UNIT_TYPE_DIPS);
             butStyle2.setMargin(Component.TOP,5);  
             butStyle2.setMargin(Component.LEFT,9);  
           butStyle2.setMargin(Component.RIGHT,9);
            List<produit_entities> produit;
           produit=sp.getPromoToday();
              for(int i=0; i<produit.size(); i++){
                  SpanLabel animal= new SpanLabel();
         if(produit.get(i).getNom().length()>4)
                animal = new SpanLabel("Nom : "+produit.get(i).getNom()+
                        "        Prix :"+produit.get(i).getPrix()+"                  "
                        +"Prix Promo :"+produit.get(i).getPrix_promo());
            else
             animal = new SpanLabel("Nom : "+produit.get(i).getNom()+
                        "           Prix :"+produit.get(i).getPrix()+"                  "
                        +"      Prix Promo :"+produit.get(i).getPrix_promo());
             
                  String path ="http://localhost/hunt/groupee/symfony2/web/uploads/images/"+produit.get(i).getImage()+""; 
               EncodedImage encImg
                = EncodedImage.createFromImage(theme.getImage("logohunt.png").scaled(150,150), false);
         
              URLImage  imgUrl = URLImage.createToStorage(encImg,produit.get(i).getImage(),path);
              animal.setIcon(imgUrl);
               
              

            Produit.addAll(animal);
           
            }
               ttt.addTab("Promotion",Produit);
           
           }
           if(countE.equals("0"))
                   l2.setText("Nouvelles sur les events : pas de nouvelle ");
               else 
                   l2.setText("Nouvelles sur les events : "+countE+" ajoutee");
            
           
               c.add(l);
               c.addAll(l1,l2);
              
               add(c);
               add(ttt);
           } 
    }
}
