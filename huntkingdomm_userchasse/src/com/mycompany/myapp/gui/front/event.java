/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui.front;


import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import com.codename1.components.ShareButton;
import com.codename1.components.SpanLabel;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Stroke;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.ImageIO;
import com.codename1.util.StringUtil;
import com.mycompany.myapp.entitie.evenement;
import com.mycompany.myapp.entitie.participation;
import com.mycompany.myapp.gui.login.acceuil;
import com.mycompany.myapp.services.eventService;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javafx.scene.layout.HBox;

/**
 *
 * @author hazem
 */
public class event extends Form {
   Form current;
   Image imgs;
ArrayList<evenement> list2=new ArrayList<>();
ArrayList<participation> list3=new ArrayList<>();
    public event() {
    }
    
    public event(Form previous) {
      current=this;
      Style eventStyle= getAllStyles();
        eventStyle.setBgColor(0xCD853F);
      eventService s = new eventService();
      List data0= s.getid();
      List data= s.gettitre();
      List data2= s.getImage();
      List data3=s.getdescription();
      List data4=s.getdatedebut();
      List data5=s.getdatefin();
      List data6=s.getnombreplace();
      List data7=s.getidUserr();
      List data8=s.getetat();
      
        setTitle("Evenement");
        setLayout(BoxLayout.y());
         getToolbar().addMaterialCommandToLeftBar("back", 
                FontImage.MATERIAL_BACKUP, ev->{new menuevent(current).show();});
          getToolbar().addCommandToOverflowMenu("Exit",
            null, ev->{Display.getInstance().exitApplication();});
          TextField searchField = new TextField("", "Search");
     
searchField.getHintLabel().setUIID("Title");
searchField.setUIID("Title");
searchField.getAllStyles().setAlignment(Component.LEFT);
  
         /*
                        TextField Username = new TextField("", "Rechercher");
                        Style userStyle = Username.getAllStyles();
Stroke borderStroke = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
userStyle.setBorder(RoundRectBorder.create().
        strokeColor(0).
        strokeOpacity(120));
userStyle.setBgColor(0xffffff);
userStyle.setBgTransparency(255);
userStyle.setMarginUnit(Style.UNIT_TYPE_DIPS);
userStyle.setMargin(Component.BOTTOM, 3);       
          userStyle.setMargin(Component.TOP,1); */
          current.add(searchField);
          for(int i=0; i<data.size(); i++){
              Label etat = new Label(data8.get(i).toString());
             String etatt = StringUtil.replaceAll(etat.getText(), ".0", "");
               int etata=Integer.parseInt(etatt);
              if(etata==1){
              
  /**********************************************************************************/  
             Container c4 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
             Container c2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
             Container c6 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            // Label a=new Label("date debut");
             Label titre = new Label(data.get(i).toString());
             
                      searchField.addDataChangeListener((l, l1) -> { // <2>
    String t = searchField.getText();
    if(t.length() < 1) {
        for(Component cmp : c4) {
            cmp.setHidden(false);
            cmp.setVisible(true);
        }
    } else {
        t = t.toLowerCase();
        for(Component cmp : c4) {
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
               
               
              Label k=new Label("date debut:");
              Label kk=new Label("nombre place:");
               Label idEvent = new Label(data0.get(i).toString());
               Label nombre = new Label(data6.get(i).toString());
               Label a=new Label(data4.get(i).toString());
               Label b=new Label("date fin:");
               Label d=new Label(data5.get(i).toString());
               String av=data0.get(i).toString();
               String resultt = StringUtil.replaceAll(idEvent.getText(), ".0", "");
               int foo=Integer.parseInt(resultt);
               
               Label idUserr = new Label(data7.get(i).toString());
             String resultu = StringUtil.replaceAll(idUserr.getText(), ".0", "");
               int foou=Integer.parseInt(resultu);
              
               c4.add(titre);
  
  Style aStyle=k.getAllStyles();
  aStyle.setFgColor(0x000000);
  Style bStyle=b.getAllStyles();
  bStyle.setFgColor(0x000000);
  Style dStyle=kk.getAllStyles();
  dStyle.setFgColor(0x000000);
  Style titreStyle=titre.getAllStyles();
  Font largeBoldSystemFont = Font.createSystemFont(Font.FACE_MONOSPACE, Font.STYLE_BOLD, Font.SIZE_LARGE);
  titreStyle.setFont(largeBoldSystemFont);
  titreStyle.setFgColor(0x000000);
  titreStyle.setMargin(Component.TOP,10); 
  titreStyle.setMargin(Component.LEFT,450); 
  titreStyle.setMargin(Component.BOTTOM,3);
                
               current.add(c4);
               

/*Picker datePicker = new Picker();
datePicker.setType(Display.PICKER_TYPE_STRINGS);


datePicker.setDate(new Date());/*



  /**********************************************************************************/      
               
               
   Container c = new Container();
              Image imgs2=function2(data2.get(i).toString()); 
              ImageViewer img = new ImageViewer(imgs2);
              c.add(img);
   Style imgStyle=img.getAllStyles(); 
  imgStyle.setMargin(Component.LEFT,1); 
  imgStyle.setMargin(Component.BOTTOM,3);
             c6.add(kk);
             c6.add(nombre);
             c6.add(k);
             c6.add(a);
             c6.add(b);
             c6.add(d);
              c.add(c6);
             
             current.add(c);
 /**********************************************************************************/
            Label l = new Label("Description:");
            Style lStyle=l.getAllStyles();
  lStyle.setFgColor(0x000000);
            SpanLabel sp = new SpanLabel();
            sp.setText(data3.get(i).toString());
        Style spStyle=sp.getAllStyles();
  Font largeBoldSystemFontt = Font.createSystemFont(Font.FACE_MONOSPACE, Font.STYLE_BOLD, Font.SIZE_LARGE);
  spStyle.setFont(largeBoldSystemFontt);
  spStyle.setFgColor(0x000000);
  spStyle.setMargin(Component.TOP,10); 
  spStyle.setMargin(Component.LEFT,2); 
  spStyle.setMargin(Component.BOTTOM,3);
               current.add(l);
              current.add(sp);
 /**********************************************************************************/ 
                System.err.println(foou);
                System.err.println(login.t.getId());
              if(login.t.getId()!=foou){
              participation x=new participation();
              
             
              Button btnval = new Button("");
Style butStyle=btnval.getAllStyles();
           
butStyle.setBorder(RoundRectBorder.create().
        strokeColor(0xA0522D).
        strokeOpacity(120));
butStyle.setBgColor(0xA0522D);
butStyle.setFgColor(0x000000);
butStyle.setBgTransparency(255);
butStyle.setMarginUnit(Style.UNIT_TYPE_DIPS);
butStyle.setMargin(Component.BOTTOM, 3);       

          butStyle.setMargin(Component.TOP,2);  
              
          butStyle.setMargin(Component.LEFT,10);  
           butStyle.setMargin(Component.RIGHT,10);
           eventService ev1= new eventService();
        
                    if(ev1.getPubAimer(login.t.getUsername(),foo)){
                        btnval.setText("vous avez déja participé");
                        btnval.remove();
            
                    }else {btnval.setText("participer");
                    if (btnval.getText().equals("participer")){
                              btnval.addActionListener(e->{
                  
                  
participation ee=new participation();

ee.setUsername(login.t.getUsername());

ee.setId_event(foo);
Picker datef1 = new Picker();
      datef1.setType(Display.PICKER_TYPE_DATE);
      String result = StringUtil.replaceAll(datef1.getText(), "/", "-");
ee.setDateReservation(result);


ev1.addparticipation(ee,foo);
    System.out.println(ee);
                           Dialog.show("Success","ajout avec succes",new Command("OK"));
                           btnval.remove();
                           
                          
});}}
    
              current.add(btnval);
              }    
/*************************************************************************************/
           Button ss = new Button("Faire un screenshot");
              
               ss.addActionListener(e1 -> {

                    Image screenshot = Image.createImage(current.getWidth(), current.getHeight());
                    current.revalidate();
                    current.setVisible(true);
                    current.paintComponent(screenshot.getGraphics(), true);

                    String imageFile = FileSystemStorage.getInstance().getAppHomePath() + "test.png";
                    try (OutputStream os = FileSystemStorage.getInstance().openOutputStream(imageFile)) {
                        ImageIO.getImageIO().save(screenshot, os, ImageIO.FORMAT_PNG, 1);
                    } catch (IOException err) {
                        Log.e(err);
                    }
                });
               current.add(ss);
               ShareButton share = new ShareButton();
               current.add(share);
               
/*************************************************************************************/           
  
          
           
             
            /**********************************************************************************/ 
          }
          


    }}
          public String  function (String nom)
     {
        String url = "http://localhost/hunt/groupee/symfony2/web/imagesEvent/"+nom+""; 
         return  url;
    
     }
     public Image function2(String nom)
     {
         int deviceWidth = 600;
         Image placeholder = Image.createImage(deviceWidth, deviceWidth, 0xbfc9d2);
          EncodedImage enc = EncodedImage.createFromImage(placeholder, false);
          imgs = URLImage.createToStorage(enc, function(nom), function(nom),URLImage.RESIZE_SCALE);
          return imgs;
     }
}