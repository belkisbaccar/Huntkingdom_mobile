/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui.front;

import Publicite.PubliciteService;
import Publicite.chasseEntite;
import com.codename1.googlemaps.MapContainer;
import com.codename1.maps.Coord;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.NORTH;
import static com.codename1.ui.CN.WEST;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import com.mycompany.myapp.MyApplication;
import static com.mycompany.myapp.MyApplication.theme;
import com.mycompany.myapp.gui.login.acceuil;
import java.util.List;

/**
 *
 * @author walid
 */
public class chasse extends Form{
    
     Form current;
    
    public chasse(Form previous) {
      current=this;
        setTitle("Chasse");
        Style loginStyle= getAllStyles();
        loginStyle.setBgImage(MyApplication.theme.getImage("2.jpg")); 
        setLayout(BoxLayout.y());
         getToolbar().addMaterialCommandToLeftBar("back", 
                FontImage.MATERIAL_ARROW_BACK, ev->{new acceuil(current).show();});
          getToolbar().addCommandToOverflowMenu("Exit",
            null, ev->{Display.getInstance().exitApplication();});
   
       MapContainer googleMap = new MapContainer();
 PubliciteService sp = new PubliciteService();
  List<chasseEntite> chasse;
           chasse=sp.getChasse();
            for(int i=0; i<chasse.size(); i++){
            
                Label animal = new Label("Animal : "+chasse.get(i).getAnimal());
    Label region = new Label("Region : "+chasse.get(i).getRegion());
    Label dateDebut= new Label("date debut :"+chasse.get(i).getDate_debut());
    Label dateFin= new Label("date fin :"+chasse.get(i).getDate_fin());
    Label type = new Label("type : "+chasse.get(i).getType());
    
        Label region1= new Label("Region : "+chasse.get(i).getRegion());
    Label dateDebut1= new Label("date debut :"+chasse.get(i).getDate_debut());
    Label dateFin1= new Label("date fin :"+chasse.get(i).getDate_fin());
    
    
             Container c = new Container(BoxLayout.yCenter());
         Style butStyle21=c.getAllStyles();
butStyle21.setBorder(RoundRectBorder.create().
        strokeColor(0xCD853F).
        strokeOpacity(120)
        );
butStyle21.setBgColor(0xFFFFFF);
butStyle21.setFgColor(0x000000);
butStyle21.setBgTransparency(255);
butStyle21.setMarginUnit(Style.UNIT_TYPE_DIPS);
             butStyle21.setMargin(Component.TOP,5);  
             butStyle21.setMargin(Component.LEFT,10);  
           butStyle21.setMargin(Component.RIGHT,10);
        c.addAll(animal,region,dateDebut,dateFin,type);
               add(c);
               EncodedImage encImg
                = EncodedImage.createFromImage(theme.getImage("round.png").scaled(100,100), false);
               if(chasse.get(i).getRegion().equals("Bizerte"))
               {
                   double latitude=37.2724;
    double longitude =9.7847;
    Coord lastLocation = new Coord(latitude, longitude);
    googleMap.addMarker(encImg, lastLocation, WEST, NORTH,(evt) -> {
        Dialog d= new Dialog(BoxLayout.yCenter());
        Button bt = new Button("ok");
       bt.addActionListener((evt2) -> {
        
            d.dispose();
            d.removeAll();
            
        });
        d.addAll(region1,dateDebut1,dateFin1,bt);
        d.show();
       
        
        
        
    });
               }
                       if(chasse.get(i).getRegion().equals("Zaghouan"))
               {
                   double latitude=36.4113;
    double longitude =10.1033;
    Coord lastLocation = new Coord(latitude, longitude);
    googleMap.addMarker(encImg, lastLocation, WEST, NORTH,(evt) -> {
        Dialog d= new Dialog(BoxLayout.yCenter());
        Button bt = new Button("ok");
       bt.addActionListener((evt2) -> {
        
            d.dispose();
            d.removeAll();
            
        });
        d.addAll(region1,dateDebut1,dateFin1,bt);
        d.show();
       
        
        
        
    });
               }
                       
                                 if(chasse.get(i).getRegion().equals("Nabeul"))
               {
                   double latitude=36.4826;
    double longitude =10.6818;
    Coord lastLocation = new Coord(latitude, longitude);
    googleMap.addMarker(encImg, lastLocation, WEST, NORTH,(evt) -> {
        Dialog d= new Dialog(BoxLayout.yCenter());
        Button bt = new Button("ok");
       bt.addActionListener((evt2) -> {
        
            d.dispose();
            d.removeAll();
            
        });
        d.addAll(region1,dateDebut1,dateFin1,bt);
        d.show();
       
        
        
        
    });
               }
            }
         
            double latitude=37.2724;
    double longitude =9.7847;

    Coord lastLocation = new Coord(latitude, longitude);
       
    googleMap.zoom(lastLocation,8);
    Style butStyle=googleMap.getAllStyles();
   googleMap.setHeight(250);
    butStyle.setMarginUnit(Style.UNIT_TYPE_DIPS);
             butStyle.setMargin(Component.TOP,5);  
             butStyle.setMargin(Component.LEFT,5);  
           butStyle.setMargin(Component.RIGHT,5);
                        Container c = new Container(BoxLayout.yCenter());
         Style butStyle21=c.getAllStyles();
butStyle21.setBorder(RoundRectBorder.create().
        strokeColor(0xCD853F).
        strokeOpacity(120)
        );
butStyle21.setBgColor(0xFFFFFF);
butStyle21.setFgColor(0x000000);
butStyle21.setBgTransparency(255);
butStyle21.setMarginUnit(Style.UNIT_TYPE_DIPS);
             butStyle21.setMargin(Component.TOP,5);  
             butStyle21.setMargin(Component.LEFT,10);  
           butStyle21.setMargin(Component.RIGHT,10);
           c.add(googleMap);
         add(c);
         
    
    }
    
    
}
