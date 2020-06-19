/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui.front;

import Produit.historique;
import Produit.service;
import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import com.codename1.components.ShareButton;
import com.codename1.components.SpanLabel;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.io.Util;
import com.codename1.location.Location;
import com.codename1.location.LocationManager;
import com.codename1.share.FacebookShare;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.mycompany.myapp.MyApplication;
import com.mycompany.myapp.gui.login.acceuil;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hazem
 */
public class ecommerce extends Form{
  Form current;
   Image imgs;
    
     
    public ecommerce(Form previous) {
      
      current=this;
   List<String> shop = new ArrayList<>(); 
      service s = new service();
      List data= s.getProd();
      List data2= s.getImage();
      List dataPrixP=s.getPrixPromo();
        System.out.println(data2);
      List data3=s.getPrix();
      Style loginStyle= getAllStyles();
        
        loginStyle.setBgImage(MyApplication.theme.getImage("Shop.jpg")); 
        setTitle("ecommerce");
        setLayout(BoxLayout.y());
         getToolbar().addMaterialCommandToLeftBar("back", 
                FontImage.MATERIAL_BACKUP, ev->{new acceuil(current).show();});
          getToolbar().addCommandToOverflowMenu("Exit",
            null, ev->{Display.getInstance().exitApplication();});
          Label likes = new Label();
          likes.setTextPosition(Component.RIGHT);
        Style heartStyle = new Style(likes.getUnselectedStyle());
        heartStyle.setFgColor(0xff2d55);
        FontImage heartImage = FontImage.createMaterial(FontImage.MATERIAL_ADD_SHOPPING_CART, heartStyle);
        likes.setIcon(heartImage);
        likes.setTextPosition(RIGHT);
         current.add(likes);
          likes.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //debut in valider action
               new historique(current,shop).show(); 
                //finvalider action

            }
        }); 
          for(int i=0; i<data.size(); i++){
               Image imgs2=function2(data2.get(i).toString());  
               
             Container c = new Container();
             Container c2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
              Container c3 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
             Label l = new Label(data.get(i).toString());
         
              Label l2 = new Label(data3.get(i).toString()+"dt");
              Label PrixPromo= new Label(dataPrixP.get(i).toString()+"dt");
             ImageViewer img = new ImageViewer(imgs2);
             Button b = new Button("add to list ");
             
              ShareButton share = new ShareButton();
              
                  
     b.getAllStyles().setBorder(Border.createEmpty());
     b.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_UNDERLINE);
    b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                shop.add(l.getText()+"__ prix:"+l2.getText());
               likes.setText(shop.size()+"");
                System.out.println(shop.size());
            }
        });
    Button b2 = new Button("remove from list ");
     b2.getAllStyles().setBorder(Border.createEmpty());
     b2.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_UNDERLINE);
    b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                shop.remove(l.getText()+"__ prix:"+l2.getText()); 
               likes.setText(shop.size()+"");
                System.out.println(shop.size());
            }
        });
               
               c.add(img);
            c2.add(l);
            String pp= dataPrixP.get(i).toString();
           float ppp=Float.parseFloat(pp);
            if(ppp>0)
            {c3.add(l2);
            c3.add(PrixPromo);}
            else {
            c3.add(l2);
            }
             c.add(c2).add(c3).add(b).add(b2).add(share);
             current.add(c);
          }
          


    }
          public String  function (String nom)
     {
        String url = "http://localhost/hunt/groupee/symfony2/web/uploads/images/"+nom+""; 
         return  url;
    
     }
     public Image function2(String nom)
     {
         int deviceWidth = 250;
         Image placeholder = Image.createImage(deviceWidth, deviceWidth, 0xbfc9d2);
          EncodedImage enc = EncodedImage.createFromImage(placeholder, false);
          imgs = URLImage.createToStorage(enc, function(nom), function(nom),URLImage.RESIZE_SCALE);
          return imgs;
     }
    
}